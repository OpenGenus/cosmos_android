package com.example.joker.cosmos_android.ViewModel;

public class Question {
    String question;
    String answer;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;

    }
}
