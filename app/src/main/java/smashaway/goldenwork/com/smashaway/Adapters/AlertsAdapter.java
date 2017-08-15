package smashaway.goldenwork.com.smashaway.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mikepenz.iconics.view.IconicsImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

import smashaway.goldenwork.com.smashaway.BClass.PoolItem;
import smashaway.goldenwork.com.smashaway.R;
import smashaway.goldenwork.com.smashaway.helpers.CircleTransform;

/**
 * Created by kader on 12/08/2017.
 */

public class AlertsAdapter extends RecyclerView.Adapter<AlertsAdapter.MyViewHolder> {

    private List<PoolItem> poolList;
    private String TAG = "DBOARDADAPT";

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, genre;
        public ImageView profile_icon;
        public IconicsImageView type_icon;
        public Context cont;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            profile_icon = (ImageView)view.findViewById(R.id.profile_icon);
            type_icon = (IconicsImageView)view.findViewById(R.id.type_icon);
            cont = view.getContext();
        }
    }


    public AlertsAdapter(List<PoolItem> poolList) {
        this.poolList = poolList;
        Log.e(TAG, String.valueOf(poolList.size()));
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row_alert, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        PoolItem pitem = poolList.get(position);

        holder.title.setText(pitem.getName()+" : "+pitem.getUstensile());
        holder.genre.setText(pitem.getDateclaim());
        if(pitem.getType().equals("car")){
            holder.type_icon.setIcon("cmd-car");
            holder.type_icon.setColorRes(R.color.clo2);

        }
        if(pitem.getType().equals("heart")){
            holder.type_icon.setIcon("cmd-heart");
            holder.type_icon.setColorRes(R.color.colorGrey1);
        }
        if(pitem.getType().equals("house")){
            holder.type_icon.setIcon("cmd-home");
        }
        /*if(pitem.getUrlprofile().equals("")){
            holder.profile_icon.setImageResource(R.drawable.account_circle);
        } else{
            Picasso.with(holder.profile_icon.getContext())
                    .load(pitem.getUrlprofile())
                    .placeholder(R.drawable.account_circle)
                    .error(R.drawable.account_circle)
                    .transform(new CircleTransform())
                    .into(holder.profile_icon );
        }*/
    }

    @Override
    public int getItemCount() {
        return poolList.size();
    }
}