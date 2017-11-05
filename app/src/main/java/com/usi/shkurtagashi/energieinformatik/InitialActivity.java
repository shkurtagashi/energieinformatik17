package com.usi.shkurtagashi.energieinformatik;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class InitialActivity extends AppCompatActivity {

    public String android_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);

        android_id = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);

//        Intent intent;
//
//        //Check Database, if user already registered direct to HomeActivity, otherwise direct to Register Form Activity
//        if (checkAndroidID()) {
//            intent = new Intent(this, MainActivity.class);
//        }
////        } else {
//////            intent = new Intent(this, RegisterActivity.class);
////        }
//        startActivity(intent);
//        finish();
    }
}
