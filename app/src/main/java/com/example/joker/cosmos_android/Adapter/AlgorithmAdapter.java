package com.example.joker.cosmos_android.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.joker.cosmos_android.Acitvity.Tab1;
import com.example.joker.cosmos_android.Database.Algorithms;
import com.example.joker.cosmos_android.R;
import com.example.joker.cosmos_android.Utils.AlgorithmsClickListener;

import java.util.ArrayList;
import java.util.List;

public class AlgorithmAdapter extends RecyclerView.Adapter<AlgorithmAdapter.ViewHolder> {

    private List<Algorithms> algorithms = new ArrayList<>();
    private Context context;

    public AlgorithmAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.algorithms_list_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.bind(position);

    }

    @Override
    public int getItemCount() {
        return algorithms == null ? 0 : algorithms.size();
    }

    public void setAlgorithms(List<Algorithms> algorithms) {

        this.algorithms = algorithms;
        notifyDataSetChanged();

    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        int id = 0;
        TextView textView = null;

        public ViewHolder(View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.algorithm_textView);

        }

        public void bind(int position) {

            id = position;
            textView.setText(algorithms.get(position).getAlgoName());

        }
    }
}
