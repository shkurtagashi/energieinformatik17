package com.example.shkurtagashi.energieinformatik.Fragments;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.shkurtagashi.energieinformatik.LocalDataStorage.DatabaseHelper;
import com.example.shkurtagashi.energieinformatik.MainActivity;
import com.example.shkurtagashi.energieinformatik.R;
import com.example.shkurtagashi.energieinformatik.User.User;
import com.example.shkurtagashi.energieinformatik.User.UserData;
import com.example.shkurtagashi.energieinformatik.User.UsersContract;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {
    private static final String TAG = "RegisterFragment";

    DatabaseHelper dbHelper;

    private EditText usernameEditText;
    private EditText empaticaIDEditText;
    private Spinner ageOptions;
    private RadioGroup genderOptions;
    private Spinner workOptions;
    private Spinner statusOptions;

    private Button submitRegistrationFormButton;
    private Button cancelRegistrationFormButton;

    public String username;
    public String empaticaID;

    private String genderSelection = "";
    private String ageSelection = "";
    private String workSelection = "";
    private String statusSelection = "";

    private String android_id;


    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_register, container, false);

        dbHelper = new DatabaseHelper(getContext());
        android_id = Settings.Secure.getString(getContext().getContentResolver(), Settings.Secure.ANDROID_ID);

        usernameEditText = (EditText) rootview.findViewById(R.id.username_value);
        empaticaIDEditText = (EditText) rootview.findViewById(R.id.empatica_value);
        ageOptions = (Spinner) rootview.findViewById(R.id.age_range);
        genderOptions = (RadioGroup) rootview.findViewById(R.id.genderRadioButtons);
//        workOptions = (Spinner) rootview.findViewById(R.id.work_title);
        statusOptions = (Spinner) rootview.findViewById(R.id.status_choices);

        setUpGenderRadioButtons();
        setUpAgeSpinner();
//        setUpWorkSpinner();
        setUpStatusSpinner();


        submitRegistrationFormButton = (Button)rootview.findViewById(R.id.submit_button);
        submitRegistrationFormButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = usernameEditText.getText().toString();
                empaticaID = empaticaIDEditText.getText().toString();
                Log.v("RegistrationActivity", username + empaticaID);

                if(genderSelection.equals("")){
                    Toast.makeText(getContext(), "Please select your Gender!", Toast.LENGTH_LONG).show();
                    return;
                }

                if(ageSelection.equals("")){
                    Toast.makeText(getContext(), "Please select your Age!", Toast.LENGTH_LONG).show();
                    return;
                }


                if(statusSelection.equals("")){
                    Toast.makeText(getContext(), "Please select your Status!", Toast.LENGTH_LONG).show();
                    return;
                }

                User user = new User();
                user._android_id = android_id;
                user._username = username;
                user._empaticaID = empaticaID;
                user._age = ageSelection;
                user._gender = genderSelection;
//                user._work = workSelection;
                user._status = statusSelection;

                Log.v(TAG, user._username);
                UserData._username = user._username;

                dbHelper.addUser(user);

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
                alertDialog.setTitle("New User Account");
                alertDialog.setMessage("You have successfully created account with: \n \n" + "Username: " + username + "\nEmpaticaID: " + empaticaID + "\nAge: " + ageSelection +
                        "\nGender: " + genderSelection + "\nStatus: " + statusSelection + "\n \n \n Do you want to proceed?");

                alertDialog.setIcon(R.drawable.account);

                alertDialog.setNegativeButton(R.string.yes,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getContext(), "Thank you!", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent (getContext(), MainActivity.class);
                                startActivity(i);
                                getActivity().finish();
                            }
                        });

                alertDialog.setPositiveButton(R.string.no,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                alertDialog.show();

//                Toast.makeText(getApplicationContext(), "You have successfully created profile with username: " + username + ", age: " + ageSelection +
//                        ", gender: " + genderSelection + ", faculty: " + facultySelection + ", programme " + programmeSelection +
//                        ", course " + selectedCoursesString + ", status " + statusSelection + " and with teaching experience of: " + teachingExpSelection,
//                        Toast.LENGTH_LONG).show();

            }
        });

        cancelRegistrationFormButton = (Button)rootview.findViewById(R.id.cancel_button);
        cancelRegistrationFormButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        return rootview;
    }

    /*
   *   Gender Radio Buttons
    */
    private void setUpGenderRadioButtons(){

        genderOptions.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.radiobutton_female:
                        genderSelection = UsersContract.UserEntry.GENDER_FEMALE;
                        break;
                    case R.id.radiobutton_male:
                        genderSelection = UsersContract.UserEntry.GENDER_MALE;
                        break;
                    default:
                        genderSelection = "";
                }
            }
        });
    }

    /*
    * Age range spinner
    */
    private void setUpAgeSpinner(){

        ArrayAdapter<CharSequence> ageAdapter = ArrayAdapter.createFromResource(getContext(),
                R.array.age_range_choices, android.R.layout.simple_spinner_item);

        ageAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ageOptions.setAdapter(ageAdapter);


        // Set the integer ageSelection to the constant values
        ageOptions.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String selection = (String) parent.getItemAtPosition(position);

                if (!TextUtils.isEmpty(selection)) {
                    if(selection.equals("Select Item")){
                        ageSelection = "";
                    } else if (selection.equals(getString(R.string.range20to30))) {
                        ageSelection = UsersContract.UserEntry.AGE_20_30;
                    } else if(selection.equals(getString(R.string.range30to40))){
                        ageSelection = UsersContract.UserEntry.AGE_30_40;
                    } else if (selection.equals(getString(R.string.range40to50))) {
                        ageSelection = UsersContract.UserEntry.AGE_40_50;
                    } else {
                        ageSelection = UsersContract.UserEntry.AGE_50_ABOVE;
                    }
                }
            }

            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ageSelection = ""; // Unknown
            }
        });
    }


    /*
    * Programme spinner
    */
//    private void setUpWorkSpinner(){
//        ArrayAdapter<CharSequence> workAdapter = ArrayAdapter.createFromResource(getContext(),
//                R.array.work_title_choices, android.R.layout.simple_spinner_item);
//        workAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        workOptions.setAdapter(workAdapter);
//
//        // Set the integer programmeSelection to the constant values
//        workOptions.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                String selection = (String) parent.getItemAtPosition(position);
//                if (!TextUtils.isEmpty(selection)) {
//                    if(selection.equals("Select Item")) {
//                        workSelection = "";
//                    } else if (selection.equals(getString(R.string.academia))) {
//                        workSelection = UsersContract.UserEntry.ACADEMIA;
//                    } else if(selection.equals(getString(R.string.industry))){
//                        workSelection = UsersContract.UserEntry.INDUSTRY;
//                    }
//                }
//            }
//
//            // Because AdapterView is an abstract class, onNothingSelected must be defined
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//                workSelection = ""; // Unknown
//            }
//        });
//
//    }


    /*
    * Status spinner
    */
    private void setUpStatusSpinner(){

        ArrayAdapter<CharSequence> statusAdapter = ArrayAdapter.createFromResource(getContext(),
                R.array.status_choices, android.R.layout.simple_spinner_item);
        statusAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        statusOptions.setAdapter(statusAdapter);

        // Set the integer statusSelection to the constant values
        statusOptions.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    if(selection.equals("Select Item")) {
                        statusSelection = "";
                    } else if (selection.equals(getString(R.string.professor))) {
                        statusSelection = UsersContract.UserEntry.STATUS_FULL_PROFESSOR;
                    } else if(selection.equals(getString(R.string.researcher))) {
                        statusSelection = UsersContract.UserEntry.RESEARCHER;
                    } else if(selection.equals(getString(R.string.post_doc))){
                        statusSelection = UsersContract.UserEntry.STATUS_POST_DOC;
                    } else if(selection.equals(getString(R.string.phd_student))){
                        statusSelection = UsersContract.UserEntry.STATUS_PHD_STUDENT;
                    } else if(selection.equals(getString(R.string.assistant))){
                        statusSelection = UsersContract.UserEntry.STATUS_ASSISTANT;
                    }else if(selection.equals(getString(R.string.student))){
                        statusSelection = UsersContract.UserEntry.STUDENT;
                    }
                }
            }

            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) { statusSelection = ""; // Unknown
            }

        });

    }


}
