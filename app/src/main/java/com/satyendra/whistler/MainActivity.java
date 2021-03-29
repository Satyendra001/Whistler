package com.satyendra.whistler;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private SoundPool sp;
    private final int NR_OF_SIMULTANEOUS_SOUNDS = 7;
    private final float LEFT_VOLUME = 1.0f;
    private final float RIGHT_VOLUME = 1.0f;
    private final int NO_LOOP = 0;
    private final int PRIORITY = 0;
    private final float NORMAL_PLAY_RATE = 1.0f;

      int s1_id;
      int s2_id;
      int s3_id;
    Button change;

    ImageButton wh1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        change = findViewById(R.id.change);

        wh1 = findViewById(R.id.whistle1);

        sp = new SoundPool(NR_OF_SIMULTANEOUS_SOUNDS, AudioManager.STREAM_MUSIC,0);

        s1_id = sp.load(getApplicationContext(),R.raw.s1,PRIORITY);
        s2_id = sp.load(getApplicationContext(),R.raw.s2,PRIORITY);
        s3_id = sp.load(getApplicationContext(),R.raw.s3,PRIORITY);

        final int whistles[] = {
                R.drawable.wh1,
                R.drawable.wh2,
                R.drawable.wh3
        };

        final int sounds[] = {
                s1_id,
                s2_id,
                s3_id
        };

        final Random rd = new Random();


        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number = rd.nextInt(3);

                wh1.setImageResource(whistles[number]);
//                Toast.makeText(MainActivity.this, "Saty", Toast.LENGTH_SHORT).show();
            }
        });

        wh1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number = rd.nextInt(3);
//                Toast.makeText(MainActivity.this, "Saty", Toast.LENGTH_SHORT).show();
                sp.play(s3_id,LEFT_VOLUME,RIGHT_VOLUME,PRIORITY,NO_LOOP,NORMAL_PLAY_RATE );
            }
        });
    }
}
