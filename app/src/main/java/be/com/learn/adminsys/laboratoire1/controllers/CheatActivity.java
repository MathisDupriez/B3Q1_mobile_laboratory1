package be.com.learn.adminsys.laboratoire1.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import be.com.learn.adminsys.laboratoire1.R;

public class CheatActivity extends AppCompatActivity {
    public static final String ANSWER_EXTRA = "ANSWER_EXTRA";
    public static final String EXTRA_ANSWER_SHOWN = "EXTRA_ANSWER_SHOWN";
    private String mAnswerIsTrue;
    private Button mShowAnswerButton;
    private TextView mAnswerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cheat);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        mAnswerIsTrue = getIntent().getStringExtra(ANSWER_EXTRA);

        mShowAnswerButton = findViewById(R.id.show_answer_button);
        mAnswerTextView = findViewById(R.id.answer_text_view);

        mShowAnswerButton.setOnClickListener(v -> {
            mAnswerTextView.setText(mAnswerIsTrue);
            Intent data = new Intent();
            data.putExtra(EXTRA_ANSWER_SHOWN, true);
            this.setResult(RESULT_OK, data);
        });

    }
}