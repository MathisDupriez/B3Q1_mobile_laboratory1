package be.com.learn.adminsys.laboratoire1.models;

import java.io.Serializable;

public record UiState(
        int currentQuestionResId,
        int explanationResId,
        int score,
        int currentQuestionNumber,
        int progress,
        boolean isGameStarted,
        boolean isLastQuestion,
        boolean isAnswerCorrect,
        Boolean doesThePlayerRespond
)implements Serializable {}
