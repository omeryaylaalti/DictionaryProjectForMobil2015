package com.example.omeryaylaalti.dictionaryprojectformobil2015;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class AramaActivity extends Activity {
    RadioButton english;
    RadioButton turkish;
    private Button kelimeBul;
    EditText kelime;
    Veritabani db;
    private TextView _textNoGoster, _textTurkceGoster, _textİngilizceGoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arama);

         english = (RadioButton) findViewById(R.id.english);
         turkish= (RadioButton) findViewById(R.id.turkish);

         kelimeBul= (Button) findViewById(R.id.kelime_bul);
         kelime = (EditText) findViewById(R.id.turkce);
        _textTurkceGoster = (TextView) findViewById(R.id.textViewTurkceGoster);
        _textİngilizceGoster = (TextView) findViewById(R.id.textViewIngilizceGoster);
        _textNoGoster = (TextView) findViewById(R.id.textViewNumaraGoster);

        kelimeBul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                kayıtlariGetir();
            }
        });

    }

    public void kayıtlariGetir(){
            String aranan = kelime.getText().toString();
            Kelimeler eldeEdilenIsim=db.getKelime(aranan);
             _textİngilizceGoster.setText(eldeEdilenIsim);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_arama, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
