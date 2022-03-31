package com.adenosinetp10.ex2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView name = findViewById(R.id.textView5);
        TextView regno = findViewById(R.id.textView6);
        TextView dept = findViewById(R.id.textView7);
        Button back = findViewById(R.id.backButton);

        Intent intent = getIntent();

        name.setText(intent.getStringExtra("name"));
        regno.setText(intent.getStringExtra("regno"));
        dept.setText(intent.getStringExtra("dept"));

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}