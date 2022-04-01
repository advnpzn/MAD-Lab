package com.adenosinetp10.ex3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get Display Width and Height pixels at runtime
        int width = getResources().getDisplayMetrics().widthPixels;
        int height = getResources().getDisplayMetrics().heightPixels;


        // Create a bitmap
        Bitmap bm = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

        // Map the ImageView to the Bitmap
        ImageView image = findViewById(R.id.imageView);
        image.setBackground(new BitmapDrawable(this.getResources(), bm));

        // Create a canvas and map it to the bitmap
        Canvas canvas = new Canvas(bm);

        // Create paint object to get started with painting the shapes
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setTextSize(50);

        // To draw rectangle
        canvas.drawText("Rectangle", Math.round(width/2) + 110, 300, paint);
        canvas.drawRect(Math.round(width/2) + 50, 400, Math.round(width/2) + 400, 650, paint);

        // To draw circle
        canvas.drawText("Circle", 170, 300, paint);
        canvas.drawCircle(250, 550, 170, paint);

        //To draw Square
        canvas.drawText("Square", 170, Math.round(height/2) + 100, paint);
        canvas.drawRect(100, Math.round(height/2) + 200, 450
                , Math.round(height/2) + 550, paint);


        //To draw Line
        canvas.drawText("Line", Math.round(width/2) + 110, Math.round(height/2) + 100, paint);
        canvas.drawLine((width/2) + 50, (height/2) + 400, (width/2) + 400, (height/2) + 400, paint );


    }
}