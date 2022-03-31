package com.adenosinetp10.ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int size = 20;
    int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnTextSize = findViewById(R.id.btnTextSizeChange);
        Button btnColor = findViewById(R.id.btnTextColorChange);

        TextView text = findViewById(R.id.textView);


        btnTextSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setTextSize(size);
                size += 5;
                if (size == 40) {
                    size = 20;
                }
            }
        });


        btnColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (i){
                    case 1:
                        text.setTextColor(Color.GREEN);
                        break;
                    case 2:
                        text.setTextColor(Color.RED);
                        break;
                    case 3:
                        text.setTextColor(Color.BLUE);
                        break;
                    case 4:
                        text.setTextColor(Color.BLACK);
                        break;
                }

                i++;
                if (i == 5) {
                    i = 1;
                }
            }
        });

    }
}