package com.istiaq66.admissionform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Second_activity extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_activity);


        tv = (TextView) findViewById(R.id.txt);
        String result = getIntent().getExtras().getString("dv1");
        tv.setText(result);
    }
}