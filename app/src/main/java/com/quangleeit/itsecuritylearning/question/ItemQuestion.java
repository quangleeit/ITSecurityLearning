package com.quangleeit.itsecuritylearning.question;


public class ItemQuestion {
    private int numberQuiz;
    private String question;
    private String answerA, answerB, answerC, answerD;
    private int trueAnswer;
    private String favorite;


    public ItemQuestion(int numberQuiz, String question, String answerA, String answerB, String answerC, String answerD, int trueAnswer, String favorite) {
        this.numberQuiz = numberQuiz;
        this.question = question;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.trueAnswer = trueAnswer;
        this.favorite = favorite;
    }

    public int getNumberQuiz() {
        return numberQuiz;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswerA() {
        return answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public int getTrueAnswer() {
        return trueAnswer;
    }

    public String getFavorite() {
        return favorite;
    }
}
