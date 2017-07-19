package luck.materialdesign.demo;

import android.graphics.Color;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import demo.test.spoot.R;
import luck.materialdesign.demo.custom.viewpager.AutoScrollViewPager;
import luck.materialdesign.demo.custom.viewpager.BaseViewPagerAdapter;
import luck.materialdesign.demo.sliding.SlidingTabLayout;
import luck.materialdesign.demo.tabs.ViewPagerAdapter;

/**
 * Created by satyam naik on 2016/07/18.
 */

public class MainActivity extends AppCompatActivity {

    // Declaring Your View and Variables

    private ViewPager pager;
    private ViewPagerAdapter adapter;
    private SlidingTabLayout tabs;
    private CharSequence Titles[] = {"VIDEOS", "IMAGES", "MILESTONE"};
    private CharSequence titlesMain[] = {"chain smoker new album 2016", "new song 2016", "upcoming movie video"
                                ,"play video 2011","play list of videos"};
    private CharSequence titlesSub[] = {"love me like you do", "shape of you", "i am in your heart","i don't know why",
                                 "do what you love"};
    int Numboftabs = 3;

    private Integer[] paths = {
            R.drawable.one, R.drawable.five,
            R.drawable.three, R.drawable.one,
            R.drawable.five,
    };
    private BaseViewPagerAdapter<String> mBaseViewPagerAdapter;

    private AutoScrollViewPager mViewPager;

    private ImageView bug;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init_slider();



        mBaseViewPagerAdapter = new BaseViewPagerAdapter<String>(this,listener) {
            @Override
            public void loadImage(ImageView view, int position, String url) {
                try {
                    int x=position % getRealCount();
                    view.setImageResource(paths[x]);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void setSubTitle(TextView textView, int position, String s) {

                int x=position % getRealCount();
                textView.setText(titlesMain[x]);
            }

            @Override
            public void setSubTitle1(TextView textView, int position, String s) {
                int x=position % getRealCount();
                textView.setText(titlesSub[x]);
            }
        };
        mViewPager.setAdapter(mBaseViewPagerAdapter);

        mBaseViewPagerAdapter.add(initData());

    }
    private List<String> initData() {
        List<String> data = new ArrayList<>();
        for (int i = 0 ; i < paths.length ;i++){
            data.add(""+paths[i]);
        }
        return data;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mViewPager.onDestroy();
    }
    private BaseViewPagerAdapter.OnAutoViewPagerItemClickListener listener = new BaseViewPagerAdapter.OnAutoViewPagerItemClickListener<String>() {

        @Override
        public void onItemClick(int position, String url) {

        }
    };
    private void init_slider() {
        bug=(ImageView)findViewById(R.id.bug);
        bug.setColorFilter(Color.parseColor("#FAFAFA"));
        // Creating The ViewPagerAdapter and Passing Fragment Manager, Titles fot the Tabs and Number Of Tabs.
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), Titles, Numboftabs);

        // Assigning ViewPager View and setting the adapter
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);

        // Assiging the Sliding Tab Layout View
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width

        // Setting Custom Color for the Scroll bar indicator of the Tab View
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    return MainActivity.this.getColor(R.color.tabsScrollColor);
                } else {
                    //noinspection deprecation
                    return getResources().getColor(R.color.tabsScrollColor);
                }
            }
        });

        // Setting the ViewPager For the SlidingTabsLayout
        tabs.setViewPager(pager, MainActivity.this);

        setTabColor(0, Color.GRAY);

        mViewPager = (AutoScrollViewPager) findViewById(R.id.viewPager);


    }



//        setTabColor(position, Color.WHITE);


    public void setTabColor(int position, int white) {
        ViewGroup vg = (ViewGroup) tabs.getChildAt(0);
        int tabsCount = vg.getChildCount();
        for (int j = 0; j < tabsCount; j++) {
            ViewGroup vgTab = (ViewGroup) vg.getChildAt(j);
            int tabChildsCount = vgTab.getChildCount();
            for (int i = 0; i < tabChildsCount; i++) {
                View tabViewChild = vgTab.getChildAt(i);
                if (tabViewChild instanceof TextView) {
                    if (position == j)
                        ((TextView) tabViewChild).setTextColor(Color.parseColor("#E64A19"));
                    else
                        ((TextView) tabViewChild).setTextColor(white);


                }
                if (tabViewChild instanceof ImageView) {
                    if(j==0) {
                        if (position == j)
                            ((ImageView) tabViewChild).setImageResource(R.drawable.select_video);
                        else
                            ((ImageView) tabViewChild).setImageResource(R.drawable.video);

                    }
                    if(j==1) {
                        if (position == j)
                            ((ImageView) tabViewChild).setImageResource(R.drawable.select_image);
                        else
                            ((ImageView) tabViewChild).setImageResource(R.drawable.image);

                    }
                    if(j==2) {
                        if (position == j)
                            ((ImageView) tabViewChild).setImageResource(R.drawable.select_milestone);
                        else
                            ((ImageView) tabViewChild).setImageResource(R.drawable.milestone);

                    }
                }
            }
        }
    }


}