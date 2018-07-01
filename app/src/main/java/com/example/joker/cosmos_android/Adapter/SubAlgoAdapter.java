package com.example.joker.cosmos_android.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.joker.cosmos_android.Acitvity.SubAlgoActivity;
import com.example.joker.cosmos_android.Database.SubAlgorithms;
import com.example.joker.cosmos_android.R;
import com.example.joker.cosmos_android.Utils.SubAlgorithmClickListener;

import java.util.List;

public class SubAlgoAdapter extends RecyclerView.Adapter<SubAlgoAdapter.ViewHolder> {


    private Context context;
    private List<SubAlgorithms> subAlgorithms;
    private SubAlgorithmClickListener clickListener;

    public SubAlgoAdapter(SubAlgoActivity context) {
        clickListener = context;
    }



    public SubAlgoAdapter(Context context) {
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

      View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_row,parent,false);

        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.textView.setText(subAlgorithms.get(position).getSubAlgorithm());
        holder.cardView.setOnClickListener((v)->
        {
            int id=subAlgorithms.get(position).getId();
            clickListener.languages(id);
        });

    }


    @Override
    public int getItemCount() {
        return subAlgorithms == null ? 0 : subAlgorithms.size();
    }

    public void setAdapter(List<SubAlgorithms> subAlgorithms) {

        assert subAlgorithms != null;
        this.subAlgorithms = subAlgorithms;
        notifyDataSetChanged();

    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        CardView cardView;


        public ViewHolder(View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView);
            cardView=itemView.findViewById(R.id.card_view);



        }
    }

}
