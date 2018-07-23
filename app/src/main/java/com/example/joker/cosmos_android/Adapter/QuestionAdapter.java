package com.example.joker.cosmos_android.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.joker.cosmos_android.R;
import com.example.joker.cosmos_android.ViewModel.Question;

import java.util.List;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.PersonViewHolder> {
    private Context context;
    private List<Question> questionList = null;

    public QuestionAdapter(Context context, List<Question> questionList) {
        this.context = context;
        this.questionList = questionList;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.question_list_items, viewGroup, false);
        return new PersonViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder personViewHolder, int position) {
        Question question = questionList.get(position);
        personViewHolder.question.setText(question.getQuestion());

    }

    @Override
    public int getItemCount() {
        return questionList == null ? 0 : questionList.size();
    }

    class PersonViewHolder extends RecyclerView.ViewHolder {
        TextView question;

        public PersonViewHolder(@NonNull View itemView)
        {
            super(itemView);
            question = (TextView) itemView.findViewById(R.id.question);
        }
    }
}
