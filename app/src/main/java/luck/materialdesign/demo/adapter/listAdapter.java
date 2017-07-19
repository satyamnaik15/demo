package luck.materialdesign.demo.adapter;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import demo.test.spoot.R;
import luck.materialdesign.demo.model.EachItem_Model;


/**
 * Created by satyam naik on 2016/07/18.
 */
public class listAdapter extends RecyclerView.Adapter<listAdapter.ViewHolder> {
    private ArrayList<EachItem_Model> holidaysModel;
    private Activity activity;

    public listAdapter(Activity activity, ArrayList<EachItem_Model> holidaysModel) {
        this.holidaysModel = holidaysModel;
        this.activity = activity;

    }

    @Override
    public listAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.eachrow, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(listAdapter.ViewHolder viewHolder, int i) {



        if(i==0){
            int margintop=0;
            float d = activity.getResources().getDisplayMetrics().density;

            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.MATCH_PARENT,
                    (int)(95 * d)
            );
            margintop=(int)(6 * d);

            params.setMargins(0,margintop , 0, 0);
            viewHolder.card.setLayoutParams(params);
        }

        viewHolder.img.setImageResource(holidaysModel.get(i).getImage());
        viewHolder.head_tv.setText(holidaysModel.get(i).getHead());
        viewHolder.detail_tv.setText(holidaysModel.get(i).getDetail());
        viewHolder.time_tv.setText(holidaysModel.get(i).getTime());

    }

    @Override
    public int getItemCount() {
        return holidaysModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView head_tv, time_tv, detail_tv;
        private ImageView img;
        private CardView card;

        public ViewHolder(View view) {
            super(view);

            img = (ImageView) view.findViewById(R.id.img);
            head_tv = (TextView) view.findViewById(R.id.head);
            time_tv = (TextView) view.findViewById(R.id.time_tv);
            detail_tv = (TextView) view.findViewById(R.id.detail_tv);
            card = (CardView) view.findViewById(R.id.card);
        }
    }
}