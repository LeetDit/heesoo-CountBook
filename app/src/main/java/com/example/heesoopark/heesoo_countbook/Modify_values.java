package com.example.heesoopark.heesoo_countbook;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Modify_values extends AppCompatActivity {

    TextView nameshow;
    TextView initshow;
    TextView currentshow;
    TextView dateshow;
    TextView commentshow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_values);

        SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        String name = sharedPref.getString("name", "");
        String date = sharedPref.getString("date","");
        String comment = sharedPref.getString("comment","");
        int initvalue = sharedPref.getInt("initvalue", 0);
        int currentvalue = sharedPref.getInt("currentvalue", 0);


        nameshow = (TextView) findViewById(R.id.nameshow);
        initshow = (TextView) findViewById(R.id.initshow);
        currentshow = (TextView) findViewById(R.id.currentshow);
        dateshow = (TextView) findViewById(R.id.dateshow);
        commentshow = (TextView) findViewById(R.id.commentshow);

        nameshow.setText(name);
        initshow.setText(String.valueOf(initvalue));
        currentshow.setText(String.valueOf(currentvalue));
        dateshow.setText(date);
        commentshow.setText(comment);

    }

}
