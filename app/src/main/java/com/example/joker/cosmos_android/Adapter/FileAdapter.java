package com.example.joker.cosmos_android.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.joker.cosmos_android.R;
import com.example.joker.cosmos_android.Utils.FileClickListner;

import java.util.List;

public class FileAdapter extends RecyclerView.Adapter<FileAdapter.ViewHolder> {

    private Context context;
    private List<String> algorithmFiles;
    private FileClickListner fileClickListner;

    public FileAdapter(Context context) {
        this.context = context;
        fileClickListner = (FileClickListner) context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.file_list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return algorithmFiles == null ? 0 : algorithmFiles.size();
    }

    public void setAdapter(List<String> fileName) {
        this.algorithmFiles = fileName;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.fileNameTextView);
        }

        public void bind(int position) {

            textView.setText(algorithmFiles.get(position).trim());

            textView.setOnClickListener((v) -> {
                fileClickListner.onFileClick(algorithmFiles.get(position));
            });

        }
    }
}
