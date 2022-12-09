package com.example.galeria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    LinearLayout simpleGallery;
    ImageView ImageView;
    Button next;
    Button prev;
    Switch tlo;
    EditText kotid;
    int a=1;

    int[] images = {R.drawable.kot1, R.drawable.kot2, R.drawable.kot3, R.drawable.kot4,};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // simpleGallery=findViewById(R.id.simpleGallery2);
        ImageView = findViewById(R.id.ImageView);
        ImageView.setBackgroundResource(R.drawable.kot1);
        next=findViewById(R.id.next);
        kotid=findViewById(R.id.id_kot);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(a==1) {
                    ImageView.setBackgroundResource(R.drawable.kot2);
                    a=2;
                }
                else if(a==2) {
                    ImageView.setBackgroundResource(R.drawable.kot3);
                    a=3;
                }
                if(a==3) {
                    ImageView.setBackgroundResource(R.drawable.kot4);
                    a=4;
                }
                if(a==4) {
                    ImageView.setBackgroundResource(R.drawable.kot1);
                    a=1;
                }
            }
        });
        /*
        int id=Integer.parseInt(kotid.getText().toString());
        if(id==1)
        {
            ImageView.setBackgroundResource(R.drawable.kot1);
        }
        if(id==2)
        {
            ImageView.setBackgroundResource(R.drawable.kot2);
        }
        if(id==3)
        {
            ImageView.setBackgroundResource(R.drawable.kot3);
        }
        if(id==4)
        {
            ImageView.setBackgroundResource(R.drawable.kot4);
        }*/
        prev=findViewById(R.id.prev);
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(a==1) {
                    ImageView.setBackgroundResource(R.drawable.kot4);
                    a=4;
                }
                else if(a==2) {
                    ImageView.setBackgroundResource(R.drawable.kot1);
                    a=1;
                }
                if(a==3) {
                    ImageView.setBackgroundResource(R.drawable.kot2);
                    a=2;
                }
                if(a==4) {
                    ImageView.setBackgroundResource(R.drawable.kot3);
                    a=3;
                }
            }
        });
        tlo=findViewById(R.id.kolor_tla);
        ConstraintLayout bgElement = (ConstraintLayout) findViewById(R.id.abc);
        tlo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked==true)
                {
                    bgElement.setBackgroundColor(Color.rgb(17, 107, 191));
                }
                else
                {
                    bgElement.setBackgroundColor(Color.rgb(3, 110, 7));
                }
            }
        });
        for(int i: images){

            ImageView imageView=new ImageView(this);
            imageView.setImageResource(i);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(300,300));
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ImageView.setImageDrawable(((ImageView)v).getDrawable());

                }
            });
           // simpleGallery.addView(imageView);
        }
    }
}