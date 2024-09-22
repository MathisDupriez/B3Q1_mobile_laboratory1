package be.com.learn.adminsys.laboratoire1.controllers;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import be.com.learn.adminsys.laboratoire1.R;
import be.com.learn.adminsys.laboratoire1.models.Quiz;
import be.com.learn.adminsys.laboratoire1.view.ViewController;

public class MainActivity extends AppCompatActivity implements ViewController.ViewListener {

    private Quiz mQuiz;
    private ViewController mViewController;
    private Boolean doesThePlayerRespond = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        this.init(findViewById(R.id.main),this);
    }

    //assign the component to the variable
    protected void init(View mainView, Context context){
        mViewController = new ViewController(mainView,context);
        mQuiz = new Quiz();
        mViewController.setListeners(this);

    }

    @Override
    public void onTrueButtonClick() {
        Log.d("MainActivity","Clique sur True");
        if(mQuiz.isCurrentAnswerTrue()){
            mQuiz.addPoint();
            mViewController.setGreenColor();
        }else{
            mViewController.setRedColor();
        }
        mViewController.displayCurrentScore(mQuiz.getCurrentScore(),mQuiz.getProgress()+1);
        mViewController.showExplanation();
        mViewController.setExplanationTextView(mQuiz.getCurrentExplanation());
        mViewController.showAnswerResponse(mQuiz.isCurrentAnswerTrue());
        mViewController.disableResponseButton();
        doesThePlayerRespond = true;
    }

    @Override
    public void onFalseButtonClick() {
        Log.d("MainActivity","Clique sur false");
        if(!mQuiz.isCurrentAnswerTrue()){
            mQuiz.addPoint();
            mViewController.setGreenColor();
        }else{
            mViewController.setRedColor();
        }
        mViewController.displayCurrentScore(mQuiz.getCurrentScore(),mQuiz.getProgress()+1);
        mViewController.showExplanation();
        mViewController.setExplanationTextView(mQuiz.getCurrentExplanation());
        mViewController.showAnswerResponse(!mQuiz.isCurrentAnswerTrue());
        mViewController.disableResponseButton();
        doesThePlayerRespond = true;
    }

    @Override
    public void onNextButtonClick() {
        if(!doesThePlayerRespond){
            mViewController.sayToThePlayerToRespond();
            return;
        }
        mViewController.disableExplanation();
        mViewController.setDefaultColor();
        mViewController.enableResponseButton();
        //set the text of NextButton
        mViewController.setNextButtonText(mQuiz.isBeforeLastQuestion());
        //chose what interface should be display next
        if(mQuiz.isLastQuestion()){
            mViewController.showStartControl();
            mViewController.disableGameControl();
            mViewController.setProgress(0);
            mViewController.setScoreText(true);
        }else{
            mQuiz.nextQuestion();
            mViewController.setQuestionTextView(mQuiz.getCurrentQuestion());
            mViewController.setProgress(mQuiz.getProgress());
        }
        doesThePlayerRespond =false;
    }

    @Override
    public void onStartButtonClick() {
        mQuiz.reStartQuiz();
        mViewController.setQuestionTextView(mQuiz.getCurrentQuestion());
        mViewController.disableStartControl();
        mViewController.showGameControl();
        mViewController.setScoreText(false);
        mViewController.displayCurrentScore(mQuiz.getCurrentScore(),mQuiz.getProgress()+1);
    }
}