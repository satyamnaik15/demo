package luck.materialdesign.demo.tabs;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import demo.test.spoot.R;
import luck.materialdesign.demo.MainActivity;
import luck.materialdesign.demo.adapter.listAdapter;
import luck.materialdesign.demo.model.EachItem_Model;


/**
 * Created by satyam naik on 2016/07/18.
 */
public class Tab1 extends Fragment {
    private MainActivity activity;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_1,container,false);

        recyclerView = (RecyclerView)view.findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(layoutManager);
        loadJSON();

        return view;
    }

    private void loadJSON() {

        ArrayList<EachItem_Model> data = new ArrayList<>();

        EachItem_Model tempSyabusModel=new EachItem_Model();
        tempSyabusModel.setHead("EMPTINESS FT. JUSTIN TIBLEKAR ");
        tempSyabusModel.setTime("18 HOURS AGO");
        tempSyabusModel.setDetail("There is someting that will have be be Explore in these days.");
        tempSyabusModel.setImage(R.drawable.fivee);
        data.add(tempSyabusModel);

        EachItem_Model tempSyabusModel1=new EachItem_Model();
        tempSyabusModel1.setHead("I 'M FALLING LOVE WITH YOU");
        tempSyabusModel1.setTime("12 HOUR AGO");
        tempSyabusModel1.setDetail("My life is spiralling downward. I couldn't get enough MetroLyrics ");
        tempSyabusModel1.setImage(R.drawable.two);
        data.add(tempSyabusModel1);

        EachItem_Model tempSyabusModel2=new EachItem_Model();
        tempSyabusModel2.setHead("BABY FT. JUSTIN BIBER");
        tempSyabusModel2.setTime("20 HOUR AGO");
        tempSyabusModel2.setDetail("I'm an emo kid, non-conforming as can be I Must Be Emo Lyrics ");
        tempSyabusModel2.setImage(R.drawable.three);
        data.add(tempSyabusModel2);

        EachItem_Model tempSyabusModel3=new EachItem_Model();
        tempSyabusModel3.setHead("WHITE HORSE FT. TAYLOR SWIFT");
        tempSyabusModel3.setTime("22 HOUR AGO");
        tempSyabusModel3.setDetail("Stop my breathing and slit my throat Hollywood Undead ");
        tempSyabusModel3.setImage(R.drawable.four);
        data.add(tempSyabusModel3);

        EachItem_Model tempSyabusModel4=new EachItem_Model();
        tempSyabusModel4.setHead("DON'T LET IT FT. ALI ");
        tempSyabusModel4.setTime("32 HOUR AGO");
        tempSyabusModel4.setDetail("I'm dark, and sensetive with low self-esteem breathing and slit my throat Hollywood Undead ");
        tempSyabusModel4.setImage(R.drawable.fivee);
        data.add(tempSyabusModel4);


        listAdapter adapter = new listAdapter(activity, data);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity=(MainActivity)context;
    }

    @Override
    public void onDetach() {
        super.onDetach();

    }
}
