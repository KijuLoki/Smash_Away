package smashaway.goldenwork.com.smashaway.Adapters;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mikepenz.iconics.view.IconicsImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

import smashaway.goldenwork.com.smashaway.BClass.PoolItem;
import smashaway.goldenwork.com.smashaway.PersonalPPActivity;
import smashaway.goldenwork.com.smashaway.PledgePoolActivity;
import smashaway.goldenwork.com.smashaway.R;
import smashaway.goldenwork.com.smashaway.helpers.CircleTransform;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by kader on 12/08/2017.
 */

public class PledgePoolAdapter extends RecyclerView.Adapter<PledgePoolAdapter.MyViewHolder> {

    private List<PoolItem> poolList;
    private String TAG = "DBOARDADAPT";
    public Context cont;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView profile_icon;
        public IconicsImageView type_icon;

        public RelativeLayout relayrow;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            profile_icon = (ImageView)view.findViewById(R.id.profile_icon);
            type_icon = (IconicsImageView)view.findViewById(R.id.type_icon);
            cont = view.getContext();
            relayrow = (RelativeLayout)view.findViewById(R.id.relayrow);

        }
    }


    public PledgePoolAdapter(List<PoolItem> poolList) {
        this.poolList = poolList;
        Log.e(TAG, String.valueOf(poolList.size()));
    }

    @Override
    public MyViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row_pledgepool, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final PoolItem pitem = poolList.get(position);

        holder.title.setText(pitem.getName());

        if(pitem.getUrlprofile().equals("")){
            holder.profile_icon.setImageResource(R.drawable.account_circle);
        } else{
            Picasso.with(holder.profile_icon.getContext())
                    .load(pitem.getUrlprofile())
                    .placeholder(R.drawable.account_circle)
                    .error(R.drawable.account_circle)
                    .transform(new CircleTransform())
                    .into(holder.profile_icon );
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref =cont.getSharedPreferences("MyPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("NAME",pitem.getName());
                editor.putString("PROFILE", pitem.getUrlprofile());
                editor.apply();
                Intent intent = new Intent(cont, PersonalPPActivity.class);

                cont.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return poolList.size();
    }
}