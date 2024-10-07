package be.com.learn.adminsys.laboratoire1.view;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

import be.com.learn.adminsys.laboratoire1.R;
import be.com.learn.adminsys.laboratoire1.models.UiState;

public class ViewUtils implements Serializable {
    private final Button mTrueButton;
    private final Button mFalseButton;
    private final Button mNextButton;
    private final Button mStarButton;
    private final TextView mQuestioTextView;
    private final TextView mExplanationTextView;
    private final TextView mScoreNumber;
    private final TextView mScoreText;
    private final ProgressBar mProgressBar;
    private final LinearLayout mGameControl;
    private final LinearLayout mStartControl;
    private final Context mContext;


    public ViewUtils(View rootView, Context context) {
        //button
        mTrueButton = rootView.findViewById(R.id.true_button);
        mFalseButton = rootView.findViewById(R.id.false_button);
        mNextButton = rootView.findViewById(R.id.next_button);
        mStarButton = rootView.findViewById(R.id.start_button);

        //textView
        mQuestioTextView = rootView.findViewById(R.id.question_text_view);
        mExplanationTextView= rootView.findViewById(R.id.question_explication);
        mScoreNumber = rootView.findViewById(R.id.scoreNumber);
        mScoreText = rootView.findViewById(R.id.score_text);

        //linearLayout
        mGameControl = rootView.findViewById(R.id.game_control);
        mStartControl = rootView.findViewById(R.id.start_control);

        //other
        mProgressBar = rootView.findViewById(R.id.progressBar);
        mContext = context;
    }

    // view for the Quiz things
    public void setQuestionTextView(int question){
        mQuestioTextView.setText(question);
    }

    public void setNextButtonText(Boolean isLastQuestion){
        if (isLastQuestion){
            mNextButton.setText(R.string.stop_button);
        }else{
            mNextButton.setText(R.string.next_button);
        }
    }
    public void showAnswerResponse(Boolean correctAnswer) {
        Toast toast;

        if (correctAnswer) {
            toast = Toast.makeText(mContext, R.string.good_answer, Toast.LENGTH_SHORT);
        } else {
            toast = Toast.makeText(mContext, R.string.bad_answer, Toast.LENGTH_SHORT);
        }

        // Positionner le toast au centre de l'écran
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
    public void sayToThePlayerToRespond(){
        Toast.makeText(mContext,R.string.please_respond,Toast.LENGTH_SHORT).show();
    }

    // display the current score
    public void displayCurrentScore(int score,int CurrentQuestionNumber){
        mScoreNumber.setText(String.format("%d/%d", score, CurrentQuestionNumber));
    }
    public void setScoreText(boolean isLastScore){
        // put true is entry for display the lastGame text
        // put false in entry for display the current Score text
        if(isLastScore){
            mScoreText.setText(R.string.last_game);
        }else{
            mScoreText.setText(R.string.score_text);
        }
    }
    //management of the progress bar
    public void setProgress(int progress){
        mProgressBar.setProgress(progress);
    }

    //view for the game control  thing
    public void showGameControl(){
        mGameControl.setVisibility(View.VISIBLE);
    }
    public void disableGameControl(){
        mGameControl.setVisibility(View.GONE);
    }

    // view for the start menu thing
    public void showStartControl(){
        mStartControl.setVisibility(View.VISIBLE);
        mQuestioTextView.setText(R.string.question_text);
    }
    public void disableStartControl(){
        mStartControl.setVisibility(View.GONE);
    }

    // view for explanation thing
    public void showExplanation(){
        mExplanationTextView.setVisibility(View.VISIBLE);
    }
    public void disableExplanation(){
        mExplanationTextView.setVisibility(View.INVISIBLE);
    }
    public void setExplanationTextView(int explanation){
        mExplanationTextView.setText(explanation);
    }
    // manage the status of the game control button
    public void disableResponseButton(){
        mTrueButton.setEnabled(false);
        mFalseButton.setEnabled(false);
    }
    public void enableResponseButton(){
        mTrueButton.setEnabled(true);
        mFalseButton.setEnabled(true);
    }
    // set the color by the reponse
    public void setRedColor(){
        mQuestioTextView.setBackgroundResource(R.drawable.border_background_red);
    }
    public void setGreenColor(){
        mQuestioTextView.setBackgroundResource(R.drawable.border_background_green);
    }
    public void setDefaultColor(){
        mQuestioTextView.setBackgroundResource(R.drawable.border_background);
    }
    //management of the listener interface
    public interface ViewListener {
        void onTrueButtonClick();
        void onFalseButtonClick();
        void onNextButtonClick();
        void onStartButtonClick();
    }


    public void setListeners(ViewListener listener){
        mTrueButton.setOnClickListener(v -> listener.onTrueButtonClick());
        mFalseButton.setOnClickListener(v -> listener.onFalseButtonClick());
        mNextButton.setOnClickListener(v -> listener.onNextButtonClick());
        mStarButton.setOnClickListener(v -> listener.onStartButtonClick());
    }
}
