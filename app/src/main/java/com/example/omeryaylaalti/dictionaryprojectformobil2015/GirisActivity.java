package com.example.omeryaylaalti.dictionaryprojectformobil2015;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


public class GirisActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris);

        menuEkrani();

    }

    private void menuEkrani(){
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.animator);
        ImageView girisLogo= (ImageView) findViewById(R.id.girisLogoImageView);
        anim.reset();
        girisLogo.clearAnimation();
        girisLogo.startAnimation(anim);
        anim.setAnimationListener(new Animation.AnimationListener() {


            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent= new Intent(GirisActivity.this, MenuActivity.class);
                startActivity(intent);
                GirisActivity.this.finish();

            }


            @Override
            public void onAnimationRepeat(Animation animation) {}
            @Override
            public void onAnimationStart(Animation animation) {}

    });


}
}
