package com.example.recyclerviewwithfragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.holder> {

    List<String>arr;
    ItemClickListener itemClickListener;
    Context context;
    public CustomAdapter(List<String>arr,ItemClickListener itemClickListener,Context context) {
        this.arr=arr;
       this.itemClickListener=itemClickListener;
       this.context=context;

    }

    public interface ItemClickListener{
        void OnItemClick(String msg);
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
          View view= LayoutInflater.from(context).inflate(R.layout.row_layout,parent,false);
          return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {

        holder.view.setText(arr.get(position));
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.OnItemClick(arr.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return arr.size();
    }

    class holder extends RecyclerView.ViewHolder{

        TextView view;
        public holder(@NonNull View itemView) {
            super(itemView);
            view=itemView.findViewById(R.id.text_view);
        }
    }
}
