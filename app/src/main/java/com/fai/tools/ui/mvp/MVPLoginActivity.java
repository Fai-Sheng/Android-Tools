package com.fai.tools.ui.mvp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.fai.tools.R;
import com.fai.tools.model.ParcelData;

public class MVPLoginActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        Intent intent = getIntent();
        ParcelData data = intent.getParcelableExtra("parcel");

    }
}
