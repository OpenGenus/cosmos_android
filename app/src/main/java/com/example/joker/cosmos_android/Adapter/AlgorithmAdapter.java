package com.example.joker.cosmos_android.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.joker.cosmos_android.R;
import com.example.joker.cosmos_android.Utils.DataSet;

public class AlgorithmAdapter extends RecyclerView.Adapter<AlgorithmAdapter.ViewHolder> {

    private Context context;
    private String[] algorithmsNames = null;

    public AlgorithmAdapter(Context context) {
        this.context = context;
        this.algorithmsNames = DataSet.algorithms;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.algorithms_list_item,parent,false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.algoTextView.setText(algorithmsNames[position]);

    }

    @Override
    public int getItemCount() {
        return algorithmsNames == null ? 0 : algorithmsNames.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView algoTextView;

        public ViewHolder(View itemView) {
            super(itemView);

            algoTextView = itemView.findViewById(R.id.algorithm_textView);

        }

    }
}
