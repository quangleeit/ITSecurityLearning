package com.quangleeit.itsecuritylearning.quiz;


public class ItemQuiz {
    private String title;
    private int score;

    public ItemQuiz(String title, int score) {
        this.title = title;
        this.score = score;
    }

    public String getTitle() {
        return title;
    }

    public int getScore() {
        return score;
    }
}
