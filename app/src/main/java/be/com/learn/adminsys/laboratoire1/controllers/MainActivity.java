package be.com.learn.adminsys.laboratoire1.controllers;

import android.content.Context;
import android.content.Intent;
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
import be.com.learn.adminsys.laboratoire1.models.UiState;
import be.com.learn.adminsys.laboratoire1.view.ViewController;
import be.com.learn.adminsys.laboratoire1.view.ViewUtils;

public class MainActivity extends AppCompatActivity implements ViewUtils.ViewListener {

    private Quiz mQuiz;
    private ViewController mViewController;
    public String LoggingProcess = "LoggingProcess";
    private String QUIZ_INDEX="index";
    private String VIEWCONTROLLER_INDEX="viewControlIndex";

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

        if(savedInstanceState != null) {
            mQuiz = (Quiz) savedInstanceState.getSerializable(QUIZ_INDEX);
            UiState uiState = (UiState) savedInstanceState.getSerializable(VIEWCONTROLLER_INDEX);
            if(uiState !=null){
                mViewController.updateUi(uiState);
            }
        }
    }

    //assign the component to the variable
    protected void init(View mainView, Context context){
        mViewController = new ViewController(mainView,context);
        mQuiz = new Quiz();
        mViewController.setListeners(this);
    }
    @Override
    public void onStartButtonClick() {
        mQuiz.reStartQuiz();
        mViewController.onStartButtonClick(mQuiz.getCurrentQuestion(), mQuiz.getCurrentScore(), mQuiz.getProgress()+1);
    }

    @Override
    public void onCheatButtonClick() {
        Intent intent = new Intent(MainActivity.this, CheatActivity.class);
        String explanation = getString(mQuiz.getCurrentExplanation());
        intent.putExtra(CheatActivity.ANSWER_EXTRA,explanation);
        startActivity(intent);
    }

    @Override
    public void onTrueButtonClick() {
        Log.d("MainActivity","Clique sur True");

        if(mQuiz.isCurrentAnswerTrue()){
            mQuiz.addPoint();
            mViewController.switchColor("green");
        }else{
            mViewController.switchColor("red");
        }
        mViewController.onResponseButtonClick(mQuiz.getCurrentScore(),mQuiz.getProgress()+1,mQuiz.getCurrentExplanation(),mQuiz.isCurrentAnswerTrue());
        mQuiz.setDoesThePlayerRespond(true);
    }

    @Override
    public void onFalseButtonClick() {
        Log.d("MainActivity","Clique sur false");

        if(!mQuiz.isCurrentAnswerTrue()){
            mQuiz.addPoint();
            mViewController.switchColor("green");
        }else{
            mViewController.switchColor("red");
        }
        mViewController.onResponseButtonClick(mQuiz.getCurrentScore(),mQuiz.getProgress()+1,mQuiz.getCurrentExplanation(),!mQuiz.isCurrentAnswerTrue());
        mQuiz.setDoesThePlayerRespond(true);
    }

    @Override
    public void onNextButtonClick() {
        if(!mQuiz.doesThePlayerRespond()){
            mViewController.sayToThePlayerToRespond();
            return;
        }else if(mQuiz.isLastQuestion()){
            mViewController.onLastNextButtonClick();
            return;
        }else{
            mQuiz.nextQuestion();
            mViewController.setSecondQuestion(mQuiz.getCurrentQuestion(),mQuiz.getProgress()+1);
        }

        mViewController.switchToNextQuestion(mQuiz.isBeforeLastQuestion());
        mQuiz.setDoesThePlayerRespond(false);
    }



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(LoggingProcess, "onSaveInstanceState");
        UiState uiState = buildUiState();
        outState.putSerializable(QUIZ_INDEX, mQuiz);
        outState.putSerializable(VIEWCONTROLLER_INDEX, uiState);
    }
    private UiState buildUiState() {
        return new UiState(
                mQuiz.getCurrentQuestion(),                  // Identifiant de la question actuelle
                mQuiz.getCurrentExplanation(),               // Identifiant de la ressource d'explication actuelle
                mQuiz.getCurrentScore(),                     // Score actuel
                mQuiz.getProgress() + 1,                     // Numéro de la question actuelle
                mQuiz.getProgress(),                         // Progression de la barre
                true,                                        // Le jeu a commencé
                mQuiz.isLastQuestion(),                      // Est-ce la dernière question ?
                mQuiz.isCurrentAnswerTrue(),                 // Est-ce que la réponse est correcte ?
                mQuiz.doesThePlayerRespond()                 // Le joueur a-t-il répondu ?
        );
    }






    //just for the exercise
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LoggingProcess, "onStart method");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LoggingProcess, "onStop method");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LoggingProcess, "onDestroy method");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LoggingProcess, "onPause method");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LoggingProcess, "onResume method");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LoggingProcess, "onRestart method");
    }
}