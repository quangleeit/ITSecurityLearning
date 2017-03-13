package com.quangleeit.itsecuritylearning.interview;



public class ItemInterviewQuestion {
    private String questionInterview;
    private String answerInterview;
    private String favorite;

    public ItemInterviewQuestion(String questionInterview, String answerInterview, String favorite) {
        this.questionInterview = questionInterview;
        this.answerInterview = answerInterview;
        this.favorite = favorite;
    }

    public String getQuestionInterview() {
        return questionInterview;
    }

    public String getAnswerInterview() {
        return answerInterview;
    }

    public String getFavorite() {
        return favorite;
    }
}
