package com.example.galeria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout simpleGallery;
    ImageView selectedImageView;
    int[] images = {R.drawable.kot1, R.drawable.kot2, R.drawable.kot3, R.drawable.kot4,};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simpleGallery=findViewById(R.id.simpleGallery2);
        selectedImageView = findViewById(R.id.selectedImageView);
        for(int i: images){
            ImageView imageView=new ImageView(this);
            imageView.setImageResource(i);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(300,300));
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectedImageView.setImageDrawable(((ImageView)v).getDrawable());

                }
            });
            simpleGallery.addView(imageView);
        }
    }
}