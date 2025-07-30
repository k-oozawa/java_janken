package com.example.janken;

import android.widget.ImageView;

public class ImageDisplayHelper {
    int[] imageIds = { R.drawable.guu, R.drawable.tyoki, R.drawable.paa };

    int kati_imageId = R.drawable.kati;
    int make_imageId = R.drawable.make;
    int currentIndex = 0;

    boolean isRunning = true;
    public void showImage(ImageView imageView, int drawableResId) {
        // 画像をImageViewに設定
        imageView.setImageResource(drawableResId);
        // 画像を表示する(ViSIBLE INVISIBLEが表示しない)
        imageView.setVisibility(ImageView.VISIBLE);
    }
    public void showImage2(ImageView imageView){
        // 画像をImageViewに設定
        imageView.setImageResource(imageIds[(currentIndex + 1) % imageIds.length]);
        // 画像を表示する(ViSIBLE INVISIBLEが表示しない)
        imageView.setVisibility(ImageView.VISIBLE);
        currentIndex++;
    }
    public void startLoop(ImageView imageView){
        isRunning = true;
        // Threadを使う
        new Thread(() -> {
            while (isRunning)
            {
                // メインスレッドでのUI操作は禁止なので例外になる
                // imageView.setImageResource(...) はここではできない
                // → MainActivityから画像表示だけを呼ぶようにする
                imageView.post(() ->
                {
                    showImage2(imageView);
                });
                try
                {
                    Thread.sleep(100); // 0.5秒ごとに進めたい
                } catch (InterruptedException e)
                {
                    break;
                }
            }
        }).start();
    }
    public void stopLoop(int button_type){
        isRunning = false;

        int sazae_san;
        sazae_san = currentIndex % imageIds.length;

        if (button_type == sazae_san){
            //あいこ
        }
        else if (button_type > sazae_san){
            //負け
        }
        else{
            //勝ち
        }
    }
}
