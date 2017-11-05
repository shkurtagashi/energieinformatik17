package com.usi.shkurtagashi.energieinformatik.Fragments;


import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.usi.shkurtagashi.energieinformatik.LocalDataStorage.DatabaseHelper;
import com.usi.shkurtagashi.energieinformatik.R;
import com.usi.shkurtagashi.energieinformatik.User.User;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    TextView username, empaticaId, age, gender, status, email;
    String androidId;

    DatabaseHelper dbHelper;


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_profile, container, false);
        dbHelper = new DatabaseHelper(getContext());

        androidId = Settings.Secure.getString(getContext().getContentResolver(), Settings.Secure.ANDROID_ID);

        User user = dbHelper.getUserInfo(androidId);

        username = (TextView) rootview.findViewById(R.id.usernameValue);
        empaticaId = (TextView)rootview.findViewById(R.id.empaticaID);
        email = (TextView)rootview.findViewById(R.id.email);
        age = (TextView)rootview.findViewById(R.id.ageValue);
        gender = (TextView)rootview.findViewById(R.id.genderValue);
        status = (TextView) rootview.findViewById(R.id.statusValue);

        username.setText("Username: "+ user.getUsername());
        empaticaId.setText("E4 Id: "+ user.getEmpaticaID());
        email.setText("Email:  " + user.getEmail());
        age.setText(user.getAge());
        gender.setText(user.getGender());
        status.setText(user.getStatus());

        return rootview;
    }

}
