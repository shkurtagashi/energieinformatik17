package com.usi.shkurtagashi.energieinformatik.Survey;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.usi.shkurtagashi.energieinformatik.LocalDataStorage.DatabaseHelper;
import com.usi.shkurtagashi.energieinformatik.R;

import java.util.Calendar;
import java.util.Date;

public class Questionnaire extends AppCompatActivity {

    String answer;
    Date currentTimestamp;
    Survey survey;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        currentTimestamp = Calendar.getInstance().getTime();
        dbHelper = new DatabaseHelper(this);

        survey = new Survey();
        survey.setTimestamp(currentTimestamp+"");


        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("End of the day question");
        alertDialog.setMessage("Is there any favorite moment during the conference? If yes, please describe it.");

        final EditText input = new EditText(Questionnaire.this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        input.setLayoutParams(lp);
        alertDialog.setView(input);
        alertDialog.setIcon(R.drawable.logo3);

        alertDialog.setPositiveButton("Submit",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        answer = input.getText().toString();
                        survey.setQuestion7(answer);
                        dbHelper.addSurvey2(survey, getApplicationContext());

                        Log.v("Questionnaire", answer);

                        Toast.makeText(getApplicationContext(), "Thank you very much for your answer!", Toast.LENGTH_SHORT).show();

                        finish();
                    }
                });

        alertDialog.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        finish();
                    }
                });
        alertDialog.show();
    }
}
