package com.wit.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.espressif.wifi_provisioning.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
}