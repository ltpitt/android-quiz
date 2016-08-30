package com.example.android.quiz;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioButton firstRadioButton = (RadioButton) findViewById(R.id.firstRadioButton);
        firstRadioButton.setChecked(true);


    }


    public void submitForm(View view) {

        // get Answer 1 text
        EditText answer1;
        answer1 = (EditText) findViewById(R.id.answer1);

        // get Answer 2 text
        EditText answer2;
        answer2 = (EditText) findViewById(R.id.answer2);


        CheckBox checkbox1;
        checkbox1 = (CheckBox) findViewById(R.id.checkbox1);
        CheckBox checkbox2;
        checkbox2 = (CheckBox) findViewById(R.id.checkbox2);
        CheckBox checkbox3;
        checkbox3 = (CheckBox) findViewById(R.id.checkbox3);
        CheckBox checkbox4;
        checkbox4 = (CheckBox) findViewById(R.id.checkbox4);

        String checkbox1Value;
        checkbox1Value = "";
        if (checkbox1.isChecked()) {
            checkbox1Value = "Java";
        }

        String checkbox2Value;
        checkbox2Value = "";
        if (checkbox2.isChecked()) {
            checkbox2Value = "PHP";
        }

        String checkbox3Value;
        checkbox3Value = "";
        if (checkbox3.isChecked()) {
            checkbox3Value = "Python";
        }

        String checkbox4Value;
        checkbox4Value = "";
        if (checkbox4.isChecked()) {
            checkbox4Value = "Ruby";
        }

        // get selected Radio Button text
        RadioButton selectedRadioButton;
        RadioGroup radioGroupCodingHoursPerDay;
        radioGroupCodingHoursPerDay = (RadioGroup) findViewById(R.id.radioGroupCodingHoursPerDay);
        // get selected radio button from radioGroup
        int selectedId = radioGroupCodingHoursPerDay.getCheckedRadioButtonId();
        // find the radiobutton by returned id
        selectedRadioButton = (RadioButton) findViewById(selectedId);

        //Log.v("Radiobutton", selectedRadioButton.getText().toString());
        Log.v("Nickname : ", answer1.getText().toString());
        Log.v("GitHub : ", answer2.getText().toString());
        Log.v("Programming language 1: ", checkbox1Value );
        Log.v("Programming language 2: ", checkbox2Value );
        Log.v("Programming language 3: ", checkbox3Value );
        Log.v("Programming language 4: ", checkbox4Value );
        Log.v("Coding hours per day: ", selectedRadioButton.getText().toString());

        StringBuffer result = new StringBuffer();
        int totalPoints = 0;
        int question3Points = 0;

        if (answer1.getText().toString().equals("google")) {
            result.append("Answer to question 1 is right");
            totalPoints += 1;
        } else {
            result.append("\nAnswer to question 1 is wrong");
        }
        if (answer2.getText().toString().equals("mountain view")) {
            result.append("\nAnswer to question 2 is right");
            totalPoints += 1;
        } else {
            result.append("\nAnswer to question 2 is wrong");
        }
        if (checkbox1Value.equals("Java")) {
            question3Points += 1;
            if (checkbox2Value.equals("PHP") || checkbox3Value.equals("Python") || checkbox4Value.equals("Ruby")) {
                question3Points -= 1;
            }
        }
        if (question3Points > 0) {
            result.append("\nAnswer to question 3 is right");
            totalPoints += 1;
        } else {
            result.append("\nAnswer to question 3 is wrong");
        }

        if (selectedRadioButton.getText().toString().equals("2008")) {
            result.append("\nAnswer to question 4 is right\n");
            totalPoints += 1;
        } else {
            result.append("\nAnswer to question 4 is wrong\n");
        }

        if (totalPoints == 4) {
            result.append("\nHooray!\nYou got the maximum:\n4 correct answers!");
        } else if (totalPoints == 3) {
            result.append("\nAch, that was close...\nYou got almost the maximum:\n3 correct answers.\nTry again!");
        } else if (totalPoints == 2) {
            result.append("\nNot that bad...\n2 correct answers.\nI bet you can do better than that!");
        } else if (totalPoints == 1) {
            result.append("\nMmmh...\nCome on!\nI was expecting more...\n1 correct answer.\nYou can to it! Try again.");
        } else if (totalPoints == 0) {
            result.append("\nDid you fall asleep on the keyboard?\n0 correct answers.\nWake up, Neo!");
        }


        Toast.makeText(MainActivity.this,
                result.toString(), Toast.LENGTH_LONG).show();

    }

}