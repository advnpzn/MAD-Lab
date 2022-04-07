package com.adenosinetp10.ex5;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button notifyButton = findViewById(R.id.button);
        EditText messageBox = findViewById(R.id.editTextTextPersonName);
        TextView title = findViewById(R.id.textView2);
        TextView msgtext = findViewById(R.id.textView);

        NotificationManager notiManager = getSystemService(NotificationManager.class);

        String CHANNEL_ID = "ex5_id";

        CharSequence name = getString(R.string.channel_name);
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel notiChannel = new NotificationChannel(CHANNEL_ID, name, importance);
            String description = getString(R.string.channel_description);
            notiChannel.setDescription(description);
            notiManager.createNotificationChannel(notiChannel);

        }


        notifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, CHANNEL_ID)
                        .setSmallIcon(R.mipmap.ic_launcher_round)
                        .setContentTitle("Notification")
                        .setContentText(messageBox.getText().toString())
                        .setStyle(new NotificationCompat.BigTextStyle()
                                .bigText(messageBox.getText().toString()))
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                notiManager.notify(new Random().nextInt(10), builder.build());

            }

        });

    }

}