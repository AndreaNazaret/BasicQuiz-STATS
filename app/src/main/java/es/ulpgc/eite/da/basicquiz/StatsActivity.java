package es.ulpgc.eite.da.basicquiz;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class StatsActivity extends AppCompatActivity {

    public static final String TAG = "Quiz.StatsActivity";

    public static final String EXTRA_QUESTIONS = "EXTRA_TOTAL_QUESTIONS";
    public static final String EXTRA_ANSWERS = "EXTRA_CORRECT_ANSWERS";
    public static final String EXTRA_EXIT = "EXTRA_EXIT_APP";
    public static final String EXTRA_RESET = "EXTRA_RESET_QUIZ";
    public static final String EXTRA_BACK = "EXTRA_BACK_PRESSED";

    private TextView totalQuestionsField, correctAnswersField;
    private Button restartButton, exitButton;

    private int correctAnswers, totalQuestions;

    private boolean backPressed, exitPressed, resetPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        setTitle(R.string.stats_screen_title);
        Log.d(TAG, "onCreate");

        initLayoutData();
        linkLayoutComponents();
        updateLayoutContent();
        initLayoutButtons();

    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState");

    }

    @Override
    @SuppressWarnings("ALL")
    public void onBackPressed() {
        //super.onBackPressed();
        Log.d(TAG, "onBackPressed");

        // TODO:
        //  la pantalla "Stats" debe devolver un resultado a la pantalla "Question"
        //  para que esta última deje el estado de la pantalla como está pero
        //  desactive el botón de "Next" para impedir avanzar a la siguiente pregunta
        backPressed=true;
        Intent intent = new Intent();
        intent.putExtra(EXTRA_BACK, backPressed);
        setResult(RESULT_OK, intent);
        finish();
    }


    private void onRestartButtonClicked() {
        Log.d(TAG, "onRestartButtonClicked");

        // TODO:
        //  la pantalla "Stats" debe devolver un resultado a la pantalla "Question"
        //  para que esta última reinicie el Quiz
        resetPressed=true;
        Intent intent = new Intent();
        intent.putExtra(EXTRA_RESET, resetPressed);
        setResult(RESULT_OK, intent);
        finish();
    }


    private void onExitButtonClicked() {
        Log.d(TAG, "onExitButtonClicked");

        // TODO:
        //  la pantalla "Stats" debe devolver un resultado a la pantalla "Question"
        //  para que esta última finalice la app Quiz
        exitPressed=true;
        Intent intent = new Intent();
        intent.putExtra(EXTRA_EXIT, exitPressed);
        setResult(RESULT_OK, intent);
        finish();

    }


    private void updateLayoutContent() {
        Log.d(TAG, "updateLayoutContent");

        // Mostrar resultados
        totalQuestionsField.setText(
            getString(R.string.total_questions_text) + ": " + totalQuestions
        );
        correctAnswersField.setText(
            getString(R.string.correct_answers_text) + ": " + correctAnswers
        );
    }

    private void initLayoutButtons() {
        // Reiniciar Quiz
        restartButton.setOnClickListener(v -> onRestartButtonClicked());
        // Finalizar app
        exitButton.setOnClickListener(v -> onExitButtonClicked());

    }

    private void linkLayoutComponents() {

        totalQuestionsField = findViewById(R.id.totalQuestionsField);
        correctAnswersField = findViewById(R.id.correctAnswersField);

        restartButton = findViewById(R.id.restartButton);
        exitButton = findViewById(R.id.exitButton);
    }

    private void initLayoutData() {

        // Obtener valores pasados desde pantalla "Question"
        totalQuestions = getIntent().getIntExtra(EXTRA_QUESTIONS, 0);
        correctAnswers = getIntent().getIntExtra(EXTRA_ANSWERS, 0);
    }

}