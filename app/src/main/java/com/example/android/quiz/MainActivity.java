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

        if (answer1.getText().toString().equals("ltpitt")) {
            result.append("Correct, Nickname: ").append(answer1.getText().toString());
        } else {
            result.append("Wrong, Nickname: ").append(answer1.getText().toString());
        }

        if (answer2.getText().toString().equals("github.com/ltpitt")) {
            result.append("\nCorrect, GitHub: ").append(answer2.getText().toString());
        } else {
            result.append("\nWrong, GitHub: ").append(answer2.getText().toString());
        }

        if (checkbox1Value.equals("Java")) {
            result.append("\nCorrect, you chose a great programming language: ").append(checkbox1Value);
        } else {
            result.append("\nWrong, Java is very important");
        }
        if (checkbox2Value.equals("PHP")) {
            result.append("\nWrong, why did you choose: ").append(checkbox2Value);
        } else {
            result.append("\nCorrect, wise choice. PHP is such a dinosaur!");
        }
        if (checkbox3Value.equals("Python")) {
            result.append("\nCorrect, you chose the best programming language ever: ").append(checkbox3Value);
        } else {
            result.append("\nWrong, sorry but Python is very important");
        }
        if (checkbox4Value.equals("Ruby")) {
            result.append("\nWrong, language chosen: ").append(checkbox4Value);
        } else {
            result.append("\nCorrect, wise choice. Ruby bores me to death!");
        }

        if (selectedRadioButton.getText().toString().equals("5")) {
            result.append("\nPerfect! You choose the right answer: ").append(selectedRadioButton.getText().toString());
        } else {
            result.append("\nI do not agree with the amount of hours you chose, try again!");
        }


        Toast.makeText(MainActivity.this,
                result.toString(), Toast.LENGTH_LONG).show();

    }

}