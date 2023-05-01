package com.example.myyogaapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class FullScreenImageActivity extends AppCompatActivity {
    private ImageView imageView;
    private Button startTimerButton;
    private Button stopTimerButton;
    private TextView timerTextView;

    private CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.full_screen_img);

        imageView = findViewById(R.id.fullscreen_imageview);
        startTimerButton = findViewById(R.id.start_timer_button);
        stopTimerButton = findViewById(R.id.stop_timer_button);
        timerTextView = findViewById(R.id.timer_textview);

        int imageResourceId = getIntent().getIntExtra("image_resource_id", 0);
        imageView.setImageResource(imageResourceId);

        startTimerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTimer();
            }
        });

        stopTimerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopTimer();
            }
        });
    }

    private void startTimer() {
        if (timer != null) {
            timer.cancel();
        }

        timer = new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timerTextView.setText("Time left: " + millisUntilFinished / 1000 + " seconds");
            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onFinish() {
                timerTextView.setText("Timer finished!");
            }
        };

        timer.start();
    }

    @SuppressLint("SetTextI18n")
    private void stopTimer() {
        if (timer != null) {
            timer.cancel();
            timerTextView.setText("Timer stopped!");
        }
    }

    @Override
    public void onBackPressed() {
        if (timer != null) {
            timer.cancel();
        }
        super.onBackPressed();
    }
}

