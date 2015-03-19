package com.example.omeryaylaalti.dictionaryprojectformobil2015;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TableLayout;


public class MenuActivity extends Activity {
    ImageButton KayitButton;
    ImageButton AyarlarButton;
    ImageButton AramaButton;
    ImageButton HatirlaticiButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        KayitButton = (ImageButton) findViewById(R.id.kayitEkrani);
        AyarlarButton = (ImageButton) findViewById(R.id.ayarlarEkrani);
        AramaButton = (ImageButton) findViewById(R.id.BulEkrani);
        HatirlaticiButton = (ImageButton) findViewById(R.id.Hatirlatici);

        animasyonEkrani();

        KayitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, KayitActivity.class);
                startActivity(intent);
            }
        });

        AramaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, AramaActivity.class);
                startActivity(intent);
            }
        });

        HatirlaticiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, HatirlaticiActivity.class);
                startActivity(intent);

            }
        });


    }

    private void animasyonEkrani() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.animator);
        TableLayout tablo = (TableLayout) findViewById(R.id.tablo);
        anim.reset();
        tablo.clearAnimation();
        tablo.startAnimation(anim);
    }
}

