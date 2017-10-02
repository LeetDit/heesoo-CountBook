package com.example.heesoopark.heesoo_countbook;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Date;

import static com.example.heesoopark.heesoo_countbook.R.string.currentvalue;

public class NewActivity extends AppCompatActivity {

    EditText nameinput;
    EditText initinput;
    EditText commentinput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        nameinput = (EditText) findViewById(R.id.nameinput);
        initinput = (EditText) findViewById(R.id.initinput);
        commentinput = (EditText) findViewById(R.id.commentinput);

    }


    public void onBackButtonClicked(View v) {
        finish();
    }

    public void onSaveButtonClicked(View v) {
        Intent intent = new Intent();
        SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);

        int initvalue = Integer.parseInt(initinput.getText().toString());
        int currentvalue = 0;
        Date date = new Date();


        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("name", nameinput.getText().toString());
        editor.putInt("initvalue", initvalue);
        editor.putInt("currentvalue", initvalue);
        editor.putString("comment", commentinput.getText().toString());
        editor.putString("date", String.valueOf(date));
        editor.apply();

        setResult(RESULT_OK, intent);

        finish();

    }
}

