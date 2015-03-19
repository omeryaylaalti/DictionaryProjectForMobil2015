package com.example.omeryaylaalti.dictionaryprojectformobil2015;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class KayitActivity extends Activity {
    private EditText _editTextTurkce, _editTextIngilizce;
    private Button _buttonKaydet, _buttonKayitGetir;
    private TextView _textNoGoster, _textTurkceGoster, _textİngilizceGoster;
    private View.OnClickListener _buttonKaydetListener, _buttonKayitGetirListener;
    private Veritabani _db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yeni_kayit);

        _db = new Veritabani(this);
        setObjectsFromXML();

        // Kaydet butonu için onClickListener tanımlıyoruz.
        _buttonKaydetListener = new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // Aşağıda tanımlanan metodu çağırıyoruz.
                yeniKayitEkle();
            }
        };

        // Tanımladığımız onClickListener i kaydet butonuna set ediyoruz.
        _buttonKaydet.setOnClickListener(_buttonKaydetListener);

        // Kayıt getir butonu için onClickListener tanımlıyoruz.
        _buttonKayitGetirListener = new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // Aşağıda tanımlanan metodu çağırıyoruz.
                kayitlariGetir();
            }
        };

        // Tanımladığımız onClickListener i kayit getir butonuna set ediyoruz.
        _buttonKayitGetir.setOnClickListener(_buttonKayitGetirListener);

    }

    /**
     * XML de bulunan tüm objeleri tanımlıyoruz.
     * (onCreate metodunun içinde çok karışık olmaması
     * için bir metodun içine aldık)
     */
    public void setObjectsFromXML() {
        _editTextTurkce = (EditText) findViewById(R.id.editText_Turkce);
        _editTextIngilizce = (EditText) findViewById(R.id.editText_Ingilizce);
        _buttonKaydet = (Button) findViewById(R.id.button_Kaydet);
        _buttonKayitGetir = (Button) findViewById(R.id.button_Goster);
        _textTurkceGoster = (TextView) findViewById(R.id.textViewTurkceGoster);
        _textİngilizceGoster = (TextView) findViewById(R.id.textViewIngilizceGoster);
        _textNoGoster = (TextView) findViewById(R.id.textViewNumaraGoster);
    }
    /**
     * Yeni Kişi Eklemek.
     */
    public void yeniKayitEkle() {
        _db.addKelimeler(new Kelimeler(_editTextTurkce.getText().toString(),
                _editTextIngilizce.getText().toString()));
        Toast.makeText(this,"Ekleme Başarılı",Toast.LENGTH_SHORT).show();
    }

    /**
     * Tüm Kayıtları Getirmek.
     */
    public void kayitlariGetir() {
        _textNoGoster.setText("NO");
        _textTurkceGoster.setText("TÜRKÇE");
        _textİngilizceGoster.setText("İNGİLİZCE");

        List<Kelimeler> kelimelers = _db.getAllKisiler();

        for (Kelimeler k : kelimelers) {
            _textNoGoster.setText(_textNoGoster.getText().toString() + "\n" + k.getID());
            _textTurkceGoster.setText(_textTurkceGoster.getText().toString() + "\n" + k.getTurkce());
            _textİngilizceGoster.setText(_textİngilizceGoster.getText().toString() + "\n" + k.getIngilizce());

        }

    }
}
