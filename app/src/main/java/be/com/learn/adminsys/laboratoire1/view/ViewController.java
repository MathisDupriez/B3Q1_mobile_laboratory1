package be.com.learn.adminsys.laboratoire1.view;

import android.content.Context;
import android.view.View;

import java.io.Serializable;

import be.com.learn.adminsys.laboratoire1.models.UiState;

public class ViewController implements Serializable {
    private final ViewUtils mViewUtils;

    public ViewController(View rootView, Context context) {
        //button
        mViewUtils = new ViewUtils(rootView, context);
    }

    //View event for start button
    public void onStartButtonClick(int currentQuestion, int score, int progress) {
        mViewUtils.setQuestionTextView(currentQuestion);
        mViewUtils.disableStartControl();
        mViewUtils.showGameControl();
        mViewUtils.setScoreText(false);
        mViewUtils.displayCurrentScore(score,progress);
    }

    //View Event for False and true button
    public void switchColor(String color){
        if(color.equals("green")){
            mViewUtils.setGreenColor();
        }else if(color.equals("red")){
            mViewUtils.setRedColor();
        }else{
            mViewUtils.setDefaultColor();
        }
    }

    public void onResponseButtonClick(int currentScore, int questionIndex, int currentExplanation, boolean isCurrentAnswerTrue) {
        mViewUtils.displayCurrentScore(currentScore,questionIndex);
        mViewUtils.showExplanation();
        mViewUtils.setExplanationTextView(currentExplanation);
        mViewUtils.disableResponseButton();
        mViewUtils.showAnswerResponse(isCurrentAnswerTrue);
    }


    //View event for next button
    public void onLastNextButtonClick() {
        mViewUtils.showStartControl();
        mViewUtils.disableGameControl();
        mViewUtils.setProgress(0);
        mViewUtils.setScoreText(true);
    }
    public void sayToThePlayerToRespond(){
        mViewUtils.sayToThePlayerToRespond();
    }
    public void switchToNextQuestion(Boolean isBeforeLastQuestion){
        mViewUtils.disableExplanation();
        mViewUtils.setDefaultColor();
        mViewUtils.enableResponseButton();
        //set the text of NextButton
        mViewUtils.setNextButtonText(isBeforeLastQuestion);
    }
    public void setSecondQuestion(int currentQuestion, int progress){
        mViewUtils.setQuestionTextView(currentQuestion);
        mViewUtils.setProgress(progress);
    }



    public void setListeners(ViewUtils.ViewListener listener){
        mViewUtils.setListeners( listener);
    }

    public void updateUi(UiState uiState) {
        // Mettre à jour le texte de la question
        mViewUtils.setQuestionTextView(uiState.currentQuestionResId()); // ID de ressource de la chaîne pour la question actuelle

        // Mettre à jour le texte de l'explication
        mViewUtils.setExplanationTextView(uiState.explanationResId()); // ID de ressource de l'explication actuelle

        // Mettre à jour l'affichage du score
        mViewUtils.displayCurrentScore(uiState.score(), uiState.currentQuestionNumber()); // Affichage du score
        mViewUtils.setScoreText(uiState.isLastQuestion()); // Vérifie si c'est le dernier score
        // Mettre à jour la progression de la barre de progression
        mViewUtils.setProgress(uiState.progress()); // Progression actuelle

        // Mettre à jour le texte du bouton "Suivant"
        mViewUtils.setNextButtonText(uiState.isLastQuestion()); // Vérifie si c'est la dernière question

        // Afficher ou masquer les contrôles du jeu en fonction de l'état du jeu
        if (uiState.isGameStarted()) {
            mViewUtils.showGameControl(); // Afficher les contrôles de jeu si le jeu a commencé
            mViewUtils.disableStartControl(); // Masquer le menu de démarrage
            mViewUtils.enableResponseButton(); // Activer les boutons de réponse

            // Vérifie si le joueur a répondu à la question
            if (uiState.doesThePlayerRespond()) {
                // Ajuste la couleur de fond en fonction de la réponse correcte
                if (uiState.isAnswerCorrect()) {
                    mViewUtils.setGreenColor(); // Réponse correcte
                } else {
                    mViewUtils.setRedColor(); // Réponse incorrecte
                }
                mViewUtils.disableResponseButton();
            } else {
                mViewUtils.setDefaultColor(); // Réinitialiser la couleur si aucune réponse n'a été donnée
            }
        } else {
            mViewUtils.showStartControl(); // Affiche le menu de démarrage
            mViewUtils.disableGameControl(); // Masque les contrôles de jeu
            mViewUtils.setDefaultColor(); // Réinitialiser la couleur
            mViewUtils.disableResponseButton(); // Désactiver les boutons de réponse
        }
    }


}
