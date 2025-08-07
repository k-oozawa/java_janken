package com.example.janken;

import android.widget.ImageView;

public class ImageDisplayHelper {
    int[] imageIds = { R.drawable.guu, R.drawable.tyoki, R.drawable.paa };

    int kati_imageId = R.drawable.kati;
    int make_imageId = R.drawable.make;
    int aiko_imageId = R.drawable.aiko;
    int currentIndex = 0;

    boolean isRunning = true;
    public void showImage(ImageView imageView, int drawableResId) {
        // 画像をImageViewに設定
        imageView.setImageResource(drawableResId);
        // 画像を表示する(ViSIBLE INVISIBLEが表示しない)
        imageView.setVisibility(ImageView.VISIBLE);
    }
    public void showImage2(ImageView imageView){
        currentIndex++;
        // 画像をImageViewに設定
        imageView.setImageResource(imageIds[currentIndex % imageIds.length]);
        // 画像を表示する(ViSIBLE INVISIBLEが表示しない)
        imageView.setVisibility(ImageView.VISIBLE);
    }
    public void startLoop(ImageView imageView, ImageView imageView2){
        imageView2.setVisibility(ImageView.INVISIBLE);
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
                    Thread.sleep(500); // 0.5秒ごとに進めたい
                } catch (InterruptedException e)
                {
                    break;
                }
            }
        }).start();
    }
    public void stopLoop(ImageView imageView2, int button_type){
        imageView2.setVisibility(ImageView.VISIBLE);
        isRunning = false;

        int sazae_san;
        sazae_san = currentIndex % imageIds.length;

        if (button_type == sazae_san){
            //あいこ
            imageView2.setImageResource(aiko_imageId);
        }
        else if (button_type - 1 == sazae_san || (button_type == 0 && sazae_san == 2)){
            //負け
            imageView2.setImageResource(make_imageId);
        }
        else if (button_type + 1 == sazae_san || (button_type == 2 && sazae_san == 0)){
            //勝ち
            imageView2.setImageResource(kati_imageId);
        }
        else{
            //ありえない
        }
    }
}
