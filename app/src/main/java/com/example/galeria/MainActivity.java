package com.example.galeria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    /********************************************************
     nazwa : next

     parametry wejściowe: a - liczba, która jest przypisana do danego zdjęcia
     wartość zwracana: wartość liczby a i zdjęcie kota od 1-4
     opis funkcji: gdy button next zostanie kliknięty funkcja sprawdzi wartość a i wyświeśli
     następne zdjęcie z odpowiednim numerem potem zwiększając liczbe a o 1, ale gdy liczba a
     wyniesie więcej niż cztery, funkcja zmieni wartość liczba a na 1.

     nazwa: prev

     parametry wejściowe: a - liczba, która jest przypisana do danego zdjęcia
     wartość zwracana: wartość liczby a i zdjęcie kota od 1-4
     opis funkcji: gdy button prev zostanie kliknięty funkcja sprawdzi wartość a i wyświeśli
     poprzednie zdjęcie z odpowiednim numerem potem zmniejszy liczbe a o 1, ale gdy liczba a
     wyniesie mniej niż 1, funkcja zmieni wartość liczba a na 4.

     nazwa: kotid

     parametry wejściowe: liczby wpisane z klawiatury
     wartość zwracana: zdjęcia kota od 1-4
     opis funkcji: po wpisani liczby od 1 do 4 wyświetli się obraz o odpowiednim
     przypisanym numerze, a inne liczby będzie ignorował wyświetlając poprzedni obraz

     nazwa:tlo

     parametry wejściowe: nie zaznaczony przycisk switch
     wartość zwracana: kolor tła zielony lub niebieski
     opis funkcji: Nie zaznaczony przycisk switch sprawia że kolor tła aplikacji jest zielony,
     ale po zaznaczeniu zmienia na kolor niebieski. Proces ten jest można cofnąć
     klikając przycisk switch i kolor ponownie będzie zielony.

      autor: Pesel
     ****************************************************/
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
        ImageView = findViewById(R.id.ImageView);
        ImageView.setBackgroundResource(R.drawable.kot1);
        next=findViewById(R.id.next);
        kotid=findViewById(R.id.id_kot);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(a==1) {
                    ImageView.setBackgroundResource(R.drawable.kot2);

                }
                else if(a==2) {
                    ImageView.setBackgroundResource(R.drawable.kot3);

                }
                if(a==3) {
                    ImageView.setBackgroundResource(R.drawable.kot4);

                }
                if(a==4) {
                    ImageView.setBackgroundResource(R.drawable.kot1);

                }
                a++;
                if(a>4)
                {
                    a=a-4;
                }
            }
        });
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int id=Integer.parseInt(kotid.getText().toString());
                if(id==1)
                {
                    ImageView.setBackgroundResource(R.drawable.kot1);
                }
                else if(id==2)
                {
                    ImageView.setBackgroundResource(R.drawable.kot2);
                }
                else if(id==3)
                {
                    ImageView.setBackgroundResource(R.drawable.kot3);
                }
                else if(id==4)
                {
                    ImageView.setBackgroundResource(R.drawable.kot4);
                }
                else{

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
        kotid.addTextChangedListener(textWatcher);
        prev=findViewById(R.id.prev);
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(a==1) {
                    ImageView.setBackgroundResource(R.drawable.kot4);
                }
                else if(a==2) {
                    ImageView.setBackgroundResource(R.drawable.kot1);
                }
                if(a==3) {
                    ImageView.setBackgroundResource(R.drawable.kot2);
                }
                if(a==4) {
                    ImageView.setBackgroundResource(R.drawable.kot3);
                }
                a--;
                if(a<1)
                {
                    a=a+4;
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
    }
}