package com.example.timerlivia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.PowerManager;
import android.provider.Settings;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button btn;
    private TextView txt;
    int seconds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.edtTxt);
        btn = (Button) findViewById(R.id.btnPress);
        txt = (TextView) findViewById(R.id.txtTimer);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnStop();
                String text = editText.getText().toString();
                if(!text.equalsIgnoreCase("")) {
                    seconds = Integer.valueOf(text);
                    CountDownTimer countDownTimer = new CountDownTimer(seconds * 1000, 1000) {
                        @Override
                        public void onTick(long millis) {
                            txt.setText("seconds: " + (int) (millis / 1000));
                        }
                        @Override
                        public void onFinish() {
                            Toast.makeText(MainActivity.this, "Finished", Toast.LENGTH_SHORT).show();
                            btnStart();
                            setTimeout();
                        }
                    }.start();
                }
            }
        });
    }

    private void btnStop() {
        btn.setText("Cancel");

    }
    private void btnStart() {
        btn.setText("Start");
        txt.setText("Set Timer");
    }

    private void setTimeout() {

    }
}
