package com.herokuapp.raydashapp.quizapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

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
        CheckBox Q7Answer1 = (CheckBox) findViewById(R.id.chkbox_q7_opt2);
        CheckBox Q7Answer2 = (CheckBox) findViewById(R.id.chkbox_q7_opt3);
        CheckBox Q7Answer3 = (CheckBox) findViewById(R.id.chkbox_q7_opt1);
        CheckBox Q7Answer4 = (CheckBox) findViewById(R.id.chkbox_q7_opt4);
        EditText Q8Answer = findViewById(R.id.q8_input);

        TextView Q1AnswerText = findViewById(R.id.q1_answer);
        TextView Q2AnswerText = findViewById(R.id.q2_answer);
        TextView Q3AnswerText = findViewById(R.id.q3_answer);
        TextView Q4AnswerText = findViewById(R.id.q4_answer);
        TextView Q5AnswerText = findViewById(R.id.q5_answer);
        TextView Q6AnswerText = findViewById(R.id.q6_answer);
        TextView Q7AnswerText = findViewById(R.id.q7_answer);
        TextView Q8AnswerText = findViewById(R.id.q8_answer);

        ValidateRadioAnswer(Q1Answer, Q1AnswerText);
        ValidateRadioAnswer(Q2Answer, Q2AnswerText);
        ValidateRadioAnswer(Q3Answer, Q3AnswerText);
        ValidateRadioAnswer(Q4Answer, Q4AnswerText);
        ValidateRadioAnswer(Q5Answer, Q5AnswerText);
        ValidateRadioAnswer(Q6Answer, Q6AnswerText);
        ValidateCheckBoxAnswers(Q7Answer1, Q7Answer2, Q7Answer3, Q7Answer4, Q7AnswerText);
        ValidateTextAnswer(Q8Answer, Q8AnswerText);
        CalculateTotalScore();
    }


    public void ValidateRadioAnswer(RadioButton Answer, TextView QAnswer){
            if (Answer.isChecked()) {
                score++;
                QAnswer.setTextColor(getResources().getColor(R.color.green));
                QAnswer.setText("Correct Answer!");
            } else {
                QAnswer.setTextColor(getResources().getColor(R.color.colorAccent));
                QAnswer.setText("Wrong, Correct Answer is " + Answer.getText());
            }
        }

        public void ValidateCheckBoxAnswers(CheckBox Answer1, CheckBox Answer2, CheckBox Answer3, CheckBox Answer4, TextView QAnswer){
            if(Answer1.isChecked() && Answer2.isChecked() && !Answer3.isChecked() && !Answer4.isChecked()){
                score++;
                QAnswer.setTextColor(getResources().getColor(R.color.green));
                QAnswer.setText("Correct Answer!");
            } else {
                QAnswer.setTextColor(getResources().getColor(R.color.colorAccent));
                QAnswer.setText("Wrong, Correct Answers are " + Answer1.getText() + " and " + Answer2.getText());
            }
        }

        public void ValidateTextAnswer(EditText userInput, TextView QAnswer){
            if (userInput.getText().toString() == getResources().getString(R.string.q8_answer)){
                score++;
                QAnswer.setTextColor(getResources().getColor(R.color.green));
                QAnswer.setText("Correct Answer!");
            } else {
                QAnswer.setTextColor(getResources().getColor(R.color.colorAccent));
                QAnswer.setText("Wrong, Correct Answer is " + getResources().getString(R.string.q8_answer));
            }
        }

        public void CalculateTotalScore(){
            Context context = getApplicationContext();
            CharSequence text = "Your Final Score is " + score;
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            score = 0;
        }

    public void closeApp(View view) {
        finish();
        System.exit(0);
    }

}
