package com.adenosinetp10.ex4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;

    Button insert, delete, view, viewAll, update;
    EditText name, rollNo, marks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insert = findViewById(R.id.btnInsert);
        delete = findViewById(R.id.btnDelete);
        view = findViewById(R.id.btnView);
        viewAll = findViewById(R.id.btnViewAll);
        update = findViewById(R.id.btnUpdate);

        name = findViewById(R.id.editTextTextPersonName);
        rollNo = findViewById(R.id.editTextNumber);
        marks = findViewById(R.id.editTextNumberSigned);


        db = openOrCreateDatabase("student_db", Context.MODE_PRIVATE, null);
        db.execSQL(
                "CREATE TABLE IF NOT EXISTS student(name VARCHAR, rollno VARCHAR, marks VARCHAR);"
        );


        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String roll_no, name_, marks_;
                roll_no = rollNo.getText().toString().trim();
                name_ = name.getText().toString().trim();
                marks_ = marks.getText().toString().trim();

                if (roll_no.length() == 0 || name_.length() == 0 || marks_.length() == 0) {
                    showMessage("Error","Field(s) cannot be empty!");
                }
                else {
                    db.execSQL(
                            "INSERT INTO student VALUES('"+name_+"', '"+roll_no+"', '"+marks_+"');"
                    );
                    showMessage("Success", "Record added!");
                }
            }
        });


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String roll_no = rollNo.getText().toString().trim();
                Cursor cursor = db.rawQuery(
                        "SELECT * FROM student WHERE rollno='"+roll_no+"';", null
                );
                if (roll_no.length() == 0) {
                    showMessage("Error","Roll No. cannot be empty!");
                }
                else if (cursor.getCount() == 0){
                    showMessage("Info", "No records found :(");
                }
                else {
                    cursor.moveToNext();
                    String result = "Name     : " + cursor.getString(0) + "\n" +
                                    "Roll No.  : " + cursor.getString(1) + "\n" +
                                    "Mark       : " + cursor.getString(2) + "\n\n";
                    showMessage("Result", result);
                }

                cursor.close();
            }
        });


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String roll_no, name_, marks_;
                roll_no = rollNo.getText().toString().trim();
                name_ = name.getText().toString().trim();
                marks_ = marks.getText().toString().trim();

                Cursor cursor = db.rawQuery(
                        "SELECT * FROM student WHERE rollno='"+roll_no+"';", null
                );

                if (roll_no.length() == 0) {
                    showMessage("Error","Roll No. cannot be empty!");
                }
                else if (cursor.getCount() == 0) {
                    showMessage("Info", "No records found :(");

                }
                else {
                    db.execSQL(
                            "UPDATE student SET name='"+name_+"', marks='"+marks_+"' WHERE rollno='"+roll_no+"';"
                    );
                    showMessage("Success", "Record Updated!");
                }

                cursor.close();
                clearText();
            }
        });


        viewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor = db.rawQuery(
                        "SELECT * FROM student;", null
                );
                if (cursor.getCount() == 0) {
                    showMessage("Result", "No record found :(");
                }
                StringBuilder builder = new StringBuilder();
                while (cursor.moveToNext()) {
                    builder.append("Name     : ").append(cursor.getString(0)).append("\n");
                    builder.append("Roll No.  : ").append(cursor.getString(1)).append("\n");
                    builder.append("Mark       : ").append(cursor.getString(2)).append("\n\n");
                }

                cursor.close();
                showMessage("Result(s)", builder.toString());
            }
        });


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String roll_no;
                roll_no = rollNo.getText().toString().trim();

                Cursor cursor = db.rawQuery(
                        "SELECT * FROM student WHERE rollno='"+roll_no+"';", null
                );

                if (roll_no.length() == 0) {
                    showMessage("Error","Roll No. cannot be empty!");
                }
                else if (cursor.getCount() == 0) {
                    showMessage("Info", "No records found :(");

                }
                else {
                    db.execSQL(
                            "DELETE FROM student WHERE rollno='"+roll_no+"';"
                    );
                    showMessage("Success", "Record Deleted!");
                }

                cursor.close();
            }
        });

    }


    private void showMessage(String title, String message) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }


    private void clearText() {
        name.setText("");
        rollNo.setText("");
        marks.setText("");
        name.requestFocus();
    }

}