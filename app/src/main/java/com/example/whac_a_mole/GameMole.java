package com.example.whac_a_mole;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;
import android.os.AsyncTask;
import android.os.SystemClock;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class GameMole extends AppCompatActivity {

    protected int[] btnMoleHole = new int[]{R.id.imgBtn00, R.id.imgBtn01, R.id.imgBtn02,
                                            R.id.imgBtn10, R.id.imgBtn11, R.id.imgBtn12,
                                            R.id.imgBtn20, R.id.imgBtn21, R.id.imgBtn22};
    protected Random r = new Random();
    Delay delay = new Delay();
    protected int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_mole);

        final ImageButton imgBackButton = (ImageButton) findViewById(R.id.imgBack);

        imgBackButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameMole.this, MainActivity.class);
                startActivity(intent);
            }
        });

        time();
        delay.execute();
    }

    private void time() {
        TextView textViewTime = (TextView) findViewById(R.id.textViewTime);
        new CountDownTimer(30000, 1000){

            @Override
            public void onTick(long l) {
                textViewTime.setText(Long.toString(l/1000));
            }

            @Override
            public void onFinish() {
                try {
                    String resultMoleHole = delay.textView.getText().toString();
                    Intent intent = new Intent(GameMole.this, MainActivity.class);
                    intent.putExtra(Intent.EXTRA_TEXT, resultMoleHole);
                    startActivity(intent);
                }catch (Exception e){}
            }
        }.start();
    }

    class Delay extends AsyncTask<Void, Integer, Void> {

        public TextView textView;
        private int randomResource;
        @Override
        protected Void doInBackground(Void... voids) {
            while (true) {
                randomResource = r.nextInt(btnMoleHole.length);
                publishProgress(randomResource);
                try {
                    Thread.sleep(800);
                    if (isCancelled()) return null;
                }catch (Exception e){}
            }
        }

        @Override
        protected void onProgressUpdate(Integer... values) {

            final ImageButton imgBtn00 = (ImageButton) findViewById(btnMoleHole[0]);
            final ImageButton imgBtn01 = (ImageButton) findViewById(btnMoleHole[1]);
            final ImageButton imgBtn02 = (ImageButton) findViewById(btnMoleHole[2]);
            final ImageButton imgBtn10 = (ImageButton) findViewById(btnMoleHole[3]);
            final ImageButton imgBtn11 = (ImageButton) findViewById(btnMoleHole[4]);
            final ImageButton imgBtn12 = (ImageButton) findViewById(btnMoleHole[5]);
            final ImageButton imgBtn20 = (ImageButton) findViewById(btnMoleHole[6]);
            final ImageButton imgBtn21 = (ImageButton) findViewById(btnMoleHole[7]);
            final ImageButton imgBtn22 = (ImageButton) findViewById(btnMoleHole[8]);
            textView = (TextView) findViewById(R.id.textView);

            imgBtn00.setEnabled(false);
            imgBtn01.setEnabled(false);
            imgBtn02.setEnabled(false);
            imgBtn10.setEnabled(false);
            imgBtn11.setEnabled(false);
            imgBtn12.setEnabled(false);
            imgBtn20.setEnabled(false);
            imgBtn21.setEnabled(false);
            imgBtn22.setEnabled(false);

            final Animation a = AnimationUtils.loadAnimation(GameMole.this, R.anim.mole);

            switch (randomResource){
                case 0: imgBtn00.setEnabled(true);
                        imgBtn00.setImageResource(R.drawable.mole_hole);
                        imgBtn00.startAnimation(a);
                        imgBtn00.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                textView.setText(String.valueOf(++i));
                            }
                        });
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgBtn00.setImageResource(R.drawable.img_hole);
                                imgBtn00.setEnabled(false);
                            }
                        }, 800);
                        break;
                case 1: imgBtn01.setEnabled(true);
                        imgBtn01.setImageResource(R.drawable.mole_hole);
                        imgBtn01.startAnimation(a);
                        imgBtn01.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                textView.setText(String.valueOf(++i));
                            }
                        });
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgBtn01.setImageResource(R.drawable.img_hole);
                                imgBtn01.setEnabled(false);
                            }
                        }, 800);
                        break;
                case 2: imgBtn02.setEnabled(true);
                        imgBtn02.setImageResource(R.drawable.mole_hole);
                        imgBtn02.startAnimation(a);
                        imgBtn02.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                textView.setText(String.valueOf(++i));
                            }
                        });
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgBtn02.setImageResource(R.drawable.img_hole);
                                imgBtn02.setEnabled(false);
                            }
                        }, 800);
                        break;
                case 3: imgBtn10.setEnabled(true);
                        imgBtn10.setImageResource(R.drawable.mole_hole);
                        imgBtn10.startAnimation(a);
                        imgBtn10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                textView.setText(String.valueOf(++i));
                            }
                        });
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgBtn10.setImageResource(R.drawable.img_hole);
                                imgBtn10.setEnabled(false);
                            }
                        }, 800);
                        break;
                case 4: imgBtn11.setEnabled(true);
                        imgBtn11.setImageResource(R.drawable.mole_hole);
                        imgBtn11.startAnimation(a);
                        imgBtn11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                textView.setText(String.valueOf(++i));
                            }
                        });
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgBtn11.setImageResource(R.drawable.img_hole);
                                imgBtn11.setEnabled(false);
                            }
                        }, 800);
                        break;
                case 5: imgBtn12.setEnabled(true);
                        imgBtn12.setImageResource(R.drawable.mole_hole);
                        imgBtn12.startAnimation(a);
                        imgBtn12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                textView.setText(String.valueOf(++i));
                            }
                        });
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgBtn12.setImageResource(R.drawable.img_hole);
                                imgBtn12.setEnabled(false);
                            }
                        }, 800);
                        break;
                case 6: imgBtn20.setEnabled(true);
                        imgBtn20.setImageResource(R.drawable.mole_hole);
                        imgBtn20.startAnimation(a);
                        imgBtn20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                textView.setText(String.valueOf(++i));
                            }
                        });
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgBtn20.setImageResource(R.drawable.img_hole);
                                imgBtn20.setEnabled(false);
                            }
                        }, 800);
                        break;
                case 7: imgBtn21.setEnabled(true);
                        imgBtn21.setImageResource(R.drawable.mole_hole);
                        imgBtn21.startAnimation(a);
                        imgBtn21.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                textView.setText(String.valueOf(++i));
                            }
                        });
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgBtn21.setImageResource(R.drawable.img_hole);
                                imgBtn21.setEnabled(false);
                            }
                        }, 800);
                        break;
                case 8: imgBtn22.setEnabled(true);
                        imgBtn22.setImageResource(R.drawable.mole_hole);
                        imgBtn22.startAnimation(a);
                        imgBtn22.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                textView.setText(String.valueOf(++i));
                            }
                        });
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgBtn22.setImageResource(R.drawable.img_hole);
                                imgBtn22.setEnabled(false);
                            }
                        }, 800);
                        break;
                default: break;
            }

        }

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(GameMole.this, MainActivity.class);
        startActivity(intent);
    }
}