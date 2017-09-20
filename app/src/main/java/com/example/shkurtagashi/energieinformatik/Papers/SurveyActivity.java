package com.example.shkurtagashi.energieinformatik.Papers;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.shkurtagashi.energieinformatik.LocalDataStorage.DatabaseHelper;
import com.example.shkurtagashi.energieinformatik.R;

import java.util.Calendar;
import java.util.Date;

public class SurveyActivity extends AppCompatActivity {

    Button submitSurveyButton;
    private RadioGroup question1Options;
    private RadioGroup question2Options;
    private RadioGroup question3Options;
    private RadioGroup question4Options;
    private RadioGroup question5Options;
    private RadioGroup question6Options;

    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private CheckBox checkBox4;

    int question1Selection = 0;
    int question2Selection = 0;
    int question3Selection = 0;
    int question4Selection = 0;
    int question5Selection = 0;
    int question6Selection = 0;

    String question7Answer = "";


    DatabaseHelper dbHelper;

    Date currentTimestamp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        dbHelper = new DatabaseHelper(this);

        Bundle extras = getIntent().getExtras();
        final int paperId = extras.getInt("paperID");

        currentTimestamp = Calendar.getInstance().getTime();

        submitSurveyButton = (Button) findViewById(R.id.submitSurveyButton);
        question1Options = (RadioGroup) findViewById(R.id.question1Options);
        question2Options = (RadioGroup) findViewById(R.id.question2Options);
        question3Options = (RadioGroup) findViewById(R.id.question3Options);
        question4Options = (RadioGroup) findViewById(R.id.question4Options);
        question5Options = (RadioGroup) findViewById(R.id.question5Options);
        question6Options = (RadioGroup) findViewById(R.id.question6Options);

        checkBox1 = (CheckBox) findViewById(R.id.checkbox1);
        checkBox2 = (CheckBox) findViewById(R.id.checkbox2);
        checkBox3 = (CheckBox) findViewById(R.id.checkbox3);
        checkBox4 = (CheckBox) findViewById(R.id.checkbox4);

        setUpQuestion1RadioButtons();
        setUpQuestion2RadioButtons();
        setUpQuestion3RadioButtons();
        setUpQuestion4RadioButtons();
        setUpQuestion5RadioButtons();
        setUpQuestion6RadioButtons();


        submitSurveyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Ask if they are sure to add or update the data
                //Alert Dialog
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(SurveyActivity.this);
                alertDialog.setTitle("Submit Survey Answers");
                alertDialog.setMessage("Are you sure you want to save the answers for this survey?");
                alertDialog.setIcon(R.drawable.logo);

                alertDialog.setNegativeButton(R.string.yes,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                                //Get all selected values from views
                                final Survey s = new Survey();
                                s.setPaperId(paperId);
                                s.setTimestamp(currentTimestamp+"");
                                s.setQuestion1(question1Selection);
                                s.setQuestion2(question2Selection);
                                s.setQuestion3(question3Selection);
                                s.setQuestion4(question4Selection);
                                s.setQuestion5(question5Selection);
                                s.setQuestion6(question6Selection);

                                setUpQuestion7Checkboxes();

                                s.setQuestion7(question7Answer);

                                //Add/update the data to local database
                                dbHelper.addSurvey(s, getApplicationContext());

                                //Show thank you message
                                Toast.makeText(getApplicationContext(), "Thank you very much!", Toast.LENGTH_SHORT).show();

                                //Close this activity
                                finish();

                            }
                        });

                alertDialog.setPositiveButton(R.string.no,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                alertDialog.show();



            }
        });



    }

    /*
    *   Question 7 -  Checkboxes
     */
    private void setUpQuestion7Checkboxes() {

        if(checkBox1.isChecked()){
            question7Answer += SurveyContract.SurveyEntry.ASK_QUESTION;
        }

        if(checkBox2.isChecked()){
            question7Answer += SurveyContract.SurveyEntry.MAKE_PHOTO;
        }

        if(checkBox3.isChecked()){
            question7Answer += SurveyContract.SurveyEntry.CLAP_HANDS;
        }

        if(checkBox4.isChecked()){
            question7Answer += SurveyContract.SurveyEntry.OTHER;
        }

    }

    /*
    *   Question 1 -  Radio Buttons
     */
    private void setUpQuestion1RadioButtons(){

        question1Options.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.answer1:
                        question1Selection = SurveyContract.SurveyEntry.ANSWER_1;
                        break;
                    case R.id.answer2:
                        question1Selection = SurveyContract.SurveyEntry.ANSWER_2;
                        break;
                    case R.id.answer3:
                        question1Selection = SurveyContract.SurveyEntry.ANSWER_3;
                        break;
                    case R.id.answer4:
                        question1Selection = SurveyContract.SurveyEntry.ANSWER_4;
                        break;
                    case R.id.answer5:
                        question1Selection = SurveyContract.SurveyEntry.ANSWER_5;
                        break;
                    case R.id.answer6:
                        question1Selection = SurveyContract.SurveyEntry.ANSWER_6;
                        break;
                    case R.id.answer7:
                        question1Selection = SurveyContract.SurveyEntry.ANSWER_7;
                        break;
                    default:
                        question1Selection = 0;
                }
            }
        });
    }

    /*
*   Question 2 -  Radio Buttons
 */
    private void setUpQuestion2RadioButtons(){

        question2Options.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.answer12:
                        question2Selection = SurveyContract.SurveyEntry.ANSWER_1;
                        break;
                    case R.id.answer22:
                        question2Selection = SurveyContract.SurveyEntry.ANSWER_2;
                        break;
                    case R.id.answer32:
                        question2Selection = SurveyContract.SurveyEntry.ANSWER_3;
                        break;
                    case R.id.answer42:
                        question2Selection = SurveyContract.SurveyEntry.ANSWER_4;
                        break;
                    case R.id.answer52:
                        question2Selection = SurveyContract.SurveyEntry.ANSWER_5;
                        break;
                    case R.id.answer62:
                        question2Selection = SurveyContract.SurveyEntry.ANSWER_6;
                        break;
                    case R.id.answer72:
                        question2Selection = SurveyContract.SurveyEntry.ANSWER_7;
                        break;
                    default:
                        question2Selection = 0;
                }
            }
        });
    }

    /*
*   Question 3 -  Radio Buttons
*/
    private void setUpQuestion3RadioButtons(){

        question3Options.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.answer13:
                        question3Selection = SurveyContract.SurveyEntry.ANSWER_1;
                        break;
                    case R.id.answer23:
                        question3Selection = SurveyContract.SurveyEntry.ANSWER_2;
                        break;
                    case R.id.answer33:
                        question3Selection = SurveyContract.SurveyEntry.ANSWER_3;
                        break;
                    case R.id.answer43:
                        question3Selection = SurveyContract.SurveyEntry.ANSWER_4;
                        break;
                    case R.id.answer53:
                        question3Selection = SurveyContract.SurveyEntry.ANSWER_5;
                        break;
                    case R.id.answer63:
                        question3Selection = SurveyContract.SurveyEntry.ANSWER_6;
                        break;
                    case R.id.answer73:
                        question3Selection = SurveyContract.SurveyEntry.ANSWER_7;
                        break;
                    default:
                        question3Selection = 0;
                }
            }
        });
    }

    /*
*   Question 4 -  Radio Buttons
*/
    private void setUpQuestion4RadioButtons(){

        question4Options.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.answer14:
                        question4Selection = SurveyContract.SurveyEntry.ANSWER_1;
                        break;
                    case R.id.answer24:
                        question4Selection = SurveyContract.SurveyEntry.ANSWER_2;
                        break;
                    case R.id.answer34:
                        question4Selection = SurveyContract.SurveyEntry.ANSWER_3;
                        break;
                    case R.id.answer44:
                        question4Selection = SurveyContract.SurveyEntry.ANSWER_4;
                        break;
                    case R.id.answer54:
                        question4Selection = SurveyContract.SurveyEntry.ANSWER_5;
                        break;
                    case R.id.answer64:
                        question4Selection = SurveyContract.SurveyEntry.ANSWER_6;
                        break;
                    case R.id.answer74:
                        question4Selection = SurveyContract.SurveyEntry.ANSWER_7;
                        break;
                    default:
                        question4Selection = 0;
                }
            }
        });
    }

    /*
*   Question 5 -  Radio Buttons
*/
    private void setUpQuestion5RadioButtons(){

        question5Options.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.answer15:
                        question5Selection = SurveyContract.SurveyEntry.ANSWER_1;
                        break;
                    case R.id.answer25:
                        question5Selection = SurveyContract.SurveyEntry.ANSWER_2;
                        break;
                    case R.id.answer35:
                        question5Selection = SurveyContract.SurveyEntry.ANSWER_3;
                        break;
                    case R.id.answer45:
                        question5Selection = SurveyContract.SurveyEntry.ANSWER_4;
                        break;
                    case R.id.answer55:
                        question5Selection = SurveyContract.SurveyEntry.ANSWER_5;
                        break;
                    case R.id.answer65:
                        question5Selection = SurveyContract.SurveyEntry.ANSWER_6;
                        break;
                    case R.id.answer75:
                        question5Selection = SurveyContract.SurveyEntry.ANSWER_7;
                        break;
                    default:
                        question5Selection = 0;
                }
            }
        });
    }

    /*
*   Question 6 -  Radio Buttons
*/
    private void setUpQuestion6RadioButtons(){

        question6Options.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.answer16:
                        question6Selection = SurveyContract.SurveyEntry.ANSWER_1;
                        break;
                    case R.id.answer26:
                        question6Selection = SurveyContract.SurveyEntry.ANSWER_2;
                        break;
                    case R.id.answer36:
                        question6Selection = SurveyContract.SurveyEntry.ANSWER_3;
                        break;
                    case R.id.answer46:
                        question6Selection = SurveyContract.SurveyEntry.ANSWER_4;
                        break;
                    case R.id.answer56:
                        question6Selection = SurveyContract.SurveyEntry.ANSWER_5;
                        break;
                    case R.id.answer66:
                        question6Selection = SurveyContract.SurveyEntry.ANSWER_6;
                        break;
                    case R.id.answer76:
                        question6Selection = SurveyContract.SurveyEntry.ANSWER_7;
                        break;
                    default:
                        question6Selection = 0;
                }
            }
        });
    }

}
