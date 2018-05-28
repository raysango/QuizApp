package com.herokuapp.raydashapp.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int score;
    public void checkAnswers(View view){
        RadioButton Q1Answer = (RadioButton) findViewById(R.id.radiobtn_q1_opt1);
        RadioButton Q2Answer = (RadioButton) findViewById(R.id.radiobtn_q2_opt2);
        RadioButton Q3Answer = (RadioButton) findViewById(R.id.radiobtn_q3_opt2);
        RadioButton Q4Answer = (RadioButton) findViewById(R.id.radiobtn_q4_opt2);
        RadioButton Q5Answer = (RadioButton) findViewById(R.id.radiobtn_q5_opt4);
        RadioButton Q6Answer = (RadioButton) findViewById(R.id.radiobtn_q6_opt3);
        TextView Q1AnswerText = findViewById(R.id.q1_answer);
        TextView Q2AnswerText = findViewById(R.id.q2_answer);
        TextView Q3AnswerText = findViewById(R.id.q3_answer);
        TextView Q4AnswerText = findViewById(R.id.q4_answer);
        TextView Q5AnswerText = findViewById(R.id.q5_answer);
        TextView Q6AnswerText = findViewById(R.id.q6_answer);
        ValidateAnswer(Q1Answer, Q1AnswerText);
        ValidateAnswer(Q2Answer, Q2AnswerText);
        ValidateAnswer(Q3Answer, Q3AnswerText);
        ValidateAnswer(Q4Answer, Q4AnswerText);
        ValidateAnswer(Q5Answer, Q5AnswerText);
        ValidateAnswer(Q6Answer, Q6AnswerText);
        CalculateTotalScore();
    }


    public void ValidateAnswer(RadioButton Answer, TextView QAnswer){
            if (Answer.isChecked()) {
                score++;
                QAnswer.setTextColor(getResources().getColor(R.color.green));
                QAnswer.setText("Correct Answer!");
            } else {
                QAnswer.setTextColor(getResources().getColor(R.color.colorAccent));
                QAnswer.setText("Wrong, Correct Answer is " + Answer.getText());
            }
        }

        public void CalculateTotalScore(){
        TextView Score = findViewById(R.id.score);
            Score.setText("Your Final Score is " + score);
        }

    public void closeApp(View view) {
        finish();
        System.exit(0);
    }

}
