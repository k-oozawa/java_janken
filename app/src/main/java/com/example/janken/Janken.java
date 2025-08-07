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
    private ImageView myImageView2;

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
        myImageView2 = findViewById(R.id.hantei);
        imageHelper = new ImageDisplayHelper();

        imageHelper.startLoop(myImageView, myImageView2);


        guuButton.setOnClickListener(view ->{
            imageHelper.stopLoop(myImageView2,0);
            tyokiButton.setVisibility(ImageView.INVISIBLE);
            paaButton.setVisibility(ImageView.INVISIBLE);
            startButton.setVisibility(ImageView.VISIBLE);
        });

        tyokiButton.setOnClickListener(view ->{
            imageHelper.stopLoop(myImageView2,1);
            guuButton.setVisibility(ImageView.INVISIBLE);
            paaButton.setVisibility(ImageView.INVISIBLE);
            startButton.setVisibility(ImageView.VISIBLE);
        });

        paaButton.setOnClickListener(view ->{
            imageHelper.stopLoop(myImageView2,2);
            guuButton.setVisibility(ImageView.INVISIBLE);
            tyokiButton.setVisibility(ImageView.INVISIBLE);
            startButton.setVisibility(ImageView.VISIBLE);
        });

        startButton.setOnClickListener(view ->{
            guuButton.setVisibility(ImageView.VISIBLE);
            tyokiButton.setVisibility(ImageView.VISIBLE);
            paaButton.setVisibility(ImageView.VISIBLE);
            startButton.setVisibility(ImageView.INVISIBLE);
            imageHelper.startLoop(myImageView, myImageView2);
        });
    }
}
