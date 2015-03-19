package com.example.omeryaylaalti.dictionaryprojectformobil2015;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.widget.Toast;

import java.util.List;


public class MyBroadcastReceiver extends BroadcastReceiver{
    Veritabani db;

    @Override
    public void onReceive(Context context, Intent intent) {


        List<Kelimeler> istenenElemen=db.getAllKisiler();
        Kelimeler ilk_eleman= istenenElemen.get(0);
        String getWord = ilk_eleman.getTurkce();

        Toast.makeText(context,"Kelimemiz:" + getWord,
                Toast.LENGTH_SHORT).show();

        Vibrator vibrator= (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(1000);
    }
}
