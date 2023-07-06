package com.yasinguzel.basitzikirmatik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity extends AppCompatActivity {



    TextView textView;
    int score = 0;
    Button zikirButton;
    Button resetButton;
    int clickCounter = 0;
    ImageView shape1;
    ImageView shape2;
    ImageView shape3;
    ImageView shape4;
    ImageView shape5;

    private AdView mAdView;
    


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        zikirButton = findViewById(R.id.zikirButton);
        zikirButton.setBackgroundColor(Color.TRANSPARENT);
        resetButton = findViewById(R.id.resetButton);
        resetButton.setBackgroundColor(Color.TRANSPARENT);
        shape1 = findViewById(R.id.imageView4);
        shape2 = findViewById(R.id.imageView6);
        shape3 = findViewById(R.id.imageView7);
        shape4 = findViewById(R.id.imageView8);
        shape5 = findViewById(R.id.imageView9);

        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        score = sharedPreferences.getInt("zikirCount", 0);
        textView.setText(String.valueOf(score));

        //My Real code : ca-app-pub-9582732495383626~5645803958

        //reklamıd Code : ca-app-pub-9582732495383626/3728666176

        //Asıl try bu : ca-app-pub-3940256099942544/6300978111

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);








    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("zikirCount", score);
        editor.apply();
    }






   public void zikircek(View view){
        if(score < 1000000){
            score++;
            textView.setText(String.valueOf(score));
        }else{
            textView.setText("ERROR");
        }



   }

   public void resetzikir(View view){
        score = 0;
        textView.setText(String.valueOf(score));

   }

   public void changecolor(View view){
        if(clickCounter < 4){
            clickCounter++;
        }else{
            clickCounter = 0;
        }


        if(clickCounter == 0){
            shape1.setVisibility(View.VISIBLE);
            shape2.setVisibility(View.INVISIBLE);
            shape3.setVisibility(View.INVISIBLE);
            shape4.setVisibility(View.INVISIBLE);
            shape5.setVisibility(View.INVISIBLE);
        }else if(clickCounter == 1){
            shape1.setVisibility(View.INVISIBLE);
            shape2.setVisibility(View.VISIBLE);
            shape3.setVisibility(View.INVISIBLE);
            shape4.setVisibility(View.INVISIBLE);
            shape5.setVisibility(View.INVISIBLE);

        }else if(clickCounter == 2){
            shape1.setVisibility(View.INVISIBLE);
            shape2.setVisibility(View.INVISIBLE);
            shape3.setVisibility(View.VISIBLE);
            shape4.setVisibility(View.INVISIBLE);
            shape5.setVisibility(View.INVISIBLE);

        }else if(clickCounter == 3){
            shape1.setVisibility(View.INVISIBLE);
            shape2.setVisibility(View.INVISIBLE);
            shape3.setVisibility(View.INVISIBLE);
            shape4.setVisibility(View.VISIBLE);
            shape5.setVisibility(View.INVISIBLE);

        }else{
            shape1.setVisibility(View.INVISIBLE);
            shape2.setVisibility(View.INVISIBLE);
            shape3.setVisibility(View.INVISIBLE);
            shape4.setVisibility(View.INVISIBLE);
            shape5.setVisibility(View.VISIBLE);

        }

   }
}