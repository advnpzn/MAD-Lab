package com.adenosinetp10.ex2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String[] deptArraySpinner = new String[] {
                "MECH", "CSE", "IT", "ECE", "CIVIL"
        };

        Spinner spinner = findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_spinner_item,
                deptArraySpinner
        );

        spinner.setAdapter(adapter);


        Button submit = findViewById(R.id.submitButton);
        EditText name = findViewById(R.id.editTextTextPersonName);
        EditText regno = findViewById(R.id.editTextNumber);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nameStr = name.getText().toString();
                String regNoStr = regno.getText().toString();
                String item = spinner.getSelectedItem().toString();

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("name", nameStr);
                intent.putExtra("regno", regNoStr);
                intent.putExtra("dept", item);

                startActivity(intent);

            }
        });

    }
}