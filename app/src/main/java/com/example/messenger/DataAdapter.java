package com.example.messenger;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Vector;


public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    Context ctx;
    ArrayList<Data> dat;

    public DataAdapter(Context ctx, ArrayList<Data> dat){
        this.ctx = ctx;
        this.dat = dat;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_data_row,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.ViewHolder holder, int position) {
        Data data = dat.get(position);
        holder.tvName.setText(data.getName());
        holder.tvChat.setText(data.getChat());
        // Reference : https://stackoverflow.com/questions/41156698/loading-images-in-recyclerview-with-picasso-from-api#:~:text=Image%20loading%20using%20Picasso%20is,show%20them%20along%20with%20Picasso.
        Picasso.get().load(data.getImageURL()).into(holder.ivImage);

    }

    public int getItemCount(){
        return dat.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvName;
        TextView tvChat;
        ImageView ivImage;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvChat = (TextView) itemView.findViewById(R.id.tvChat);
            ivImage = (ImageView) itemView.findViewById(R.id.ivImage);
        }


    }
}
