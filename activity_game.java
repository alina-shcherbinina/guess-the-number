package com.example.guessthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class activity_game extends AppCompatActivity {

    TextView questionText;
    int min, max;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        questionText = (TextView) findViewById(R.id.question);
        Intent i = getIntent();
        String minStr = i.getStringExtra("min");
        String maxStr = i.getStringExtra("max");
        min = Integer.parseInt(minStr);
        max = Integer.parseInt(maxStr);

        Log.d("my", "min = " + minStr + " max = "+maxStr);
        questionText.setText("Угадываем число от " + minStr + " до "+maxStr + "\nВаше число больше " + (max-min)/2);

    }
    public void onYesNoClick(View v)
    {
        if (v.getId() == R.id.yes)
        {
            // if Yes button is pressed
            // its new min

            questionText = (TextView) findViewById(R.id.question);
            Intent i = getIntent();
            String minStr = i.getStringExtra("min");
            String maxStr = i.getStringExtra("max");
            max = Integer.parseInt(maxStr);
            min = (max-min)/2;

            Log.d("my", "min = " + minStr + " max = "+maxStr);
            questionText.setText("Угадываем число от " + minStr + " до "+maxStr + "\nВаше число больше " + (max+min)/2 + " ?");


        }
        if (v.getId() == R.id.no)
        {
            // if No button is pressed
            // new max
            questionText = (TextView) findViewById(R.id.question);
            Intent i = getIntent();
            String minStr = i.getStringExtra("min");
            String maxStr = i.getStringExtra("max");
            min = Integer.parseInt(minStr);
            max = (max-min)/2;

            Log.d("my", "min = " + minStr + " max = "+maxStr);
            questionText.setText("Угадываем число от " + minStr + " до "+maxStr + "\nВаше число больше " + (max-min)/2);

        }

    }
}