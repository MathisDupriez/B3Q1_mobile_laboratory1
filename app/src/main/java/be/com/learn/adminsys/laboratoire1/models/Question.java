package be.com.learn.adminsys.laboratoire1.models;

public class Question {
    private int mTextResId;
    private int mExplication;
    private Boolean mAnswerTrue;

    public Question(Boolean mAnswerTrue, int mTextResId,int mExplication) {
        this.mAnswerTrue = mAnswerTrue;
        this.mTextResId = mTextResId;
        this.mExplication = mExplication;
    }
    //getter for mTextResId
    public int getTextResId() {
        return mTextResId;
    }
    //getter for mExplication
    public int getExplication(){
        return mExplication;
    }
    //getter for mAnswerTrue
    public Boolean isAnswerTrue(){
        return mAnswerTrue;
    }
}