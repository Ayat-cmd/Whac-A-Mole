package com.example.whac_a_mole;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.time.Instant;

public class MainActivity extends AppCompatActivity {

    private long backPressedTime;
    private Toast backToast;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonPlay = (Button) findViewById(R.id.buttonPlay);
        TextView textResultMoleHole = (TextView) findViewById(R.id.textResultMoleHole);

        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(MainActivity.this, GameMole.class);
                    startActivity(intent); finish();
                }catch (Exception e){}
            }
        });

        Intent intent = getIntent();
        if (intent.hasExtra(Intent.EXTRA_TEXT)) {
            String resultMoleHole = intent.getStringExtra(Intent.EXTRA_TEXT);
            textResultMoleHole.setText("Result hit: " + resultMoleHole);
            buttonPlay.setText("Play again");
        }
    }
    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel();
            super.onBackPressed();
            return;
        } else {
            backToast = Toast.makeText(getBaseContext(),"Click again to exit", Toast.LENGTH_LONG);
            backToast.show();
        }

        backPressedTime = System.currentTimeMillis();
    }
}