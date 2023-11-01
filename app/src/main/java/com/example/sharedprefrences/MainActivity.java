package com.example.sharedprefrences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    /**
     * @author		Peleg Bar-Hen pb7677@bs.amalnet.k12.il
     * @version	2022.3.1 (current version number of program)
     * @since		2022/3/1
     * the app counts how many times you pressed the button "count" and what you wrote in the box "name"
     while not losing the information when you close the app
     */

    TextView TV;
    Button count;
    Button reset;
    Button exit;
    EditText ET;
    SharedPreferences saving;
    SharedPreferences.Editor editor;
    int counter = 0;
    String ET2 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TV = findViewById(R.id.textView);
        count = findViewById(R.id.button);
        reset = findViewById(R.id.button2);
        exit = findViewById(R.id.button3);
        ET = findViewById(R.id.editTextText);

        saving = getSharedPreferences("INFO",MODE_PRIVATE);
        editor = saving.edit();

        counter = saving.getInt("count",0);
        ET2 = saving.getString("output","");
        ET.setText(ET2);
        TV.setText(String.valueOf(counter));
    }

    public void Count(View view) {
        counter+=1;
        TV.setText(String.valueOf(counter));
    }

    public void Reset(View view) {
        counter=0;
        TV.setText(String.valueOf(counter));
    }

    public void Exit(View view) {
        ET2 = ET.getText().toString();
        editor.putInt("count",counter);
        editor.putString("output",ET2);
        editor.commit();
        finish();
    }
}