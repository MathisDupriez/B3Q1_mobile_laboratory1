package be.com.learn.adminsys.laboratoire1.models;

import java.io.Serializable;

public class Question implements Serializable {
    private final int mTextResId;
    private final int mExplication;
    private final Boolean mAnswerTrue;

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