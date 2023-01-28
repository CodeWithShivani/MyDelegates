package org.marg.mydelegatesapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.marg.mydelegatesapp.R;
import org.marg.mydelegatesapp.activity.Detail_Activity;
import org.marg.mydelegatesapp.model.Dashboard_Model;

import java.util.ArrayList;

public class Dashborad_Adapter extends RecyclerView.Adapter<Dashborad_Adapter.MyViewHolder> {

    ArrayList<Dashboard_Model> dashboard_modelArrayList;
    Context context;

    public Dashborad_Adapter(ArrayList<Dashboard_Model> dashboard_modelArrayList, Context context) {
        this.dashboard_modelArrayList = dashboard_modelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public Dashborad_Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.dashboard_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Dashborad_Adapter.MyViewHolder holder, int position) {
        Dashboard_Model dashboard_model=dashboard_modelArrayList.get(position);
        Picasso.get().load(dashboard_model.getImage()).into(holder.placeimg);
        holder.title.setText(dashboard_model.getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, Detail_Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("title",dashboard_model.getTitle());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dashboard_modelArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView placeimg;
        TextView title;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            placeimg=itemView.findViewById(R.id.placeimg);
            title=itemView.findViewById(R.id.title);
        }
    }
}
