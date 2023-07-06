package com.yasinguzel.basitzikirmatik;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    int score = 0;
    Button zikirButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        zikirButton = findViewById(R.id.zikirButton);
        zikirButton.setBackgroundColor(Color.TRANSPARENT);
    }

   public void zikircek(View view){
        score++;
        textView.setText(String.valueOf(score));
   }

   public void resetzikir(View view){
        score = 0;
        textView.setText(String.valueOf(score));

   }
}