package com.kunal.lecture;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.kunal.lecture.pinlockview.IndicatorDots;
import com.kunal.lecture.pinlockview.PinLockListener;
import com.kunal.lecture.pinlockview.PinLockView;

public class lockActivity extends AppCompatActivity {

    PinLockView view;
    TextView textView;
    IndicatorDots indicatorDots;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lock);

        view = findViewById(R.id.pin);
        indicatorDots = findViewById(R.id.indicator);
        textView = findViewById(R.id.title);

        sharedPreferences = getSharedPreferences("my", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        System.out.println(sharedPreferences.getString("first", ""));
        if (sharedPreferences.getString("first", "").equals("")) {
            System.out.println("first time app open");
            textView.setText("Set your passwrord");
        } else if (sharedPreferences.getString("first", "").equals("yes")) {
            textView.setText("Repeat your password");
        } else {
            System.out.println("not first time app open");
            textView.setText("Unlock App");
        }

        view.attachIndicatorDots(indicatorDots);
        view.setPinLength(4);
//        view.setTextColor(ContextCompat.getColor(this, R.color.white));

        indicatorDots.setIndicatorType(IndicatorDots.IndicatorType.FILL_WITH_ANIMATION);

        view.setPinLockListener(new PinLockListener() {
            @Override
            public void onComplete(String pin) {
                Log.d("TAG", "Pin complete: " + pin);
                if (sharedPreferences.getString("first", "").equals("")) {
                    System.out.println("second time app open");
                    textView.setText("Repeat your passwrord");
                    editor.putString("first", "yes");
                    editor.putString("password", pin);
                    editor.commit();
                    Intent intent = new Intent(lockActivity.this, lockActivity.class);
                    startActivity(intent);
                    finish();
                } else if (sharedPreferences.getString("first", "").equals("yes")) {
                    System.out.println("second time app open");
                    textView.setText("Repeat your passwrord");
                    if (sharedPreferences.getString("password", "").equals(pin)) {
                        editor.putString("finalpassword", pin);
                        editor.putString("first", "confirm");
                        editor.commit();
                        Intent intent = new Intent(lockActivity.this, lockActivity.class);
                        startActivity(intent);
                        finish();
                    }
                } else if (sharedPreferences.getString("first", "").equals("confirm")) {
                    if (sharedPreferences.getString("finalpassword", "").equals(pin)) {
                        Intent intent = new Intent(lockActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            }

            @Override
            public void onEmpty() {
                Log.d("TAG", "Pin empty");
            }

            @Override
            public void onPinChange(int pinLength, String intermediatePin) {
                password = intermediatePin;
                Log.d("TAG", "Pin changed new length " + pinLength + " with intermediate pin " + intermediatePin);
            }
        });
    }
}