package com.example.janken;
import android.content.Context;
import android.view.View;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Janken extends AppCompatActivity{
    private  Button startButton;
    private  Button guuButton;
    private  Button tyokiButton;
    private  Button paaButton;
    private ImageView myImageView;
    private ImageDisplayHelper imageHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_main);

        startButton = findViewById(R.id.startButton);
        guuButton = findViewById(R.id.guu_button);
        tyokiButton = findViewById(R.id.tyoki_button);
        paaButton = findViewById(R.id.paa_button);

        myImageView = findViewById(R.id.dispImage);
        imageHelper = new ImageDisplayHelper();

        imageHelper.startLoop(myImageView);


        guuButton.setOnClickListener(view ->{
            imageHelper.stopLoop(0);
        });

        tyokiButton.setOnClickListener(view ->{
            imageHelper.stopLoop(1);
        });

        paaButton.setOnClickListener(view ->{
            imageHelper.stopLoop(2);
        });
    }
}
