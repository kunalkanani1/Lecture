package com.kunal.lecture;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class checkbox extends AppCompatActivity {

    RadioButton r1, r2;
    CheckBox c1, c2, c3;
    StringBuilder stringBuilder = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox);

        r1 = findViewById(R.id.male);
        r2 = findViewById(R.id.female);
        c1 = findViewById(R.id.cricket);
        c2 = findViewById(R.id.music);
        c3 = findViewById(R.id.dance);

        c1.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                Toast.makeText(this, "clicked", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "unclicked", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void ok(View view) {

        if (r1.isChecked()) {
            System.out.println("male");
        } else {
            System.out.println("female");
        }

        stringBuilder.delete(0, stringBuilder.length());
        if (c1.isChecked()) {
            stringBuilder.append("/cricket");
        }
        if (c2.isChecked()) {
            stringBuilder.append("/music");
        }
        if (c3.isChecked()) {
            stringBuilder.append("/dance");
        }
        String str = stringBuilder.toString().substring(1);
        System.out.println(str);


    }
}