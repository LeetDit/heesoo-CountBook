package com.example.heesoopark.heesoo_countbook;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.id.list;

public class MainActivity extends AppCompatActivity {

    private static final int NEW_ACTIVITY_RESULT_CODE = 0;
    private static final int NEXT_ACTIVITY_RESULT_CODE = 0;

    private ArrayList<usefulData> usefulDatas = new ArrayList<usefulData>();
    private ArrayAdapter<usefulData> adapter;
    private ListView list1;
    TextView sizeview;

    private int size = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    protected void onStart() {
        super.onStart();
        list1 = (ListView) findViewById(R.id.list1);
        adapter = new ArrayAdapter<usefulData>(this,R.layout.arraylist,usefulDatas);
        list1.setAdapter(adapter);

    }

    public void onButton1Clicked(View v) {
        Intent intent = new Intent(getApplicationContext(), NewActivity.class);
        startActivityForResult(intent, NEW_ACTIVITY_RESULT_CODE);
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == NEW_ACTIVITY_RESULT_CODE){
            if(resultCode == RESULT_OK){
                SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
                String name = sharedPref.getString("name", "");
                int initvalue = sharedPref.getInt("initvalue", 0) ;

                usefulDatas.add(new usefulData(name, initvalue));

                ArrayList<Integer> numbers = new ArrayList<Integer>();

                int size = list1.getAdapter().getCount();

                sizeview = (TextView) findViewById(R.id.textView3);

                sizeview.setText(String.valueOf(size));

            }
        }

      list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView parent, View view, int position, long id) {
              Intent intent = new Intent(MainActivity.this, Modify_values.class);
              startActivityForResult(intent, NEXT_ACTIVITY_RESULT_CODE);
          }

      });

    }


}
