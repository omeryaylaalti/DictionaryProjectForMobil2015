package com.example.omeryaylaalti.dictionaryprojectformobil2015;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class Veritabani extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "veritabani.db";
    private static final int DATABASE_VERSION = 1;
    private static final String KEY_ID = "id";
    private static final String KEY_TURKCE = "turkce";
    private static final String KEY_INGILIZCE = "ingilizce";
    private static final String TABLE_KELIMELER = "kelimeler";

    public Veritabani(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        String CREATE_KISILER_TABLE = "CREATE TABLE " + TABLE_KELIMELER + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_TURKCE + " TEXT,"
                + KEY_INGILIZCE + " TEXT"
                + ");" ;
        database.execSQL(CREATE_KISILER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_KELIMELER);
        onCreate(db);

    }

    // Yeni Kayıt Eklemek.
    void addKelimeler(Kelimeler kelimeler) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TURKCE, kelimeler.getTurkce());
        values.put(KEY_INGILIZCE, kelimeler.getIngilizce());

        // Ekleme işlemi...
        db.insert(TABLE_KELIMELER ,null, values);
        db.close(); // Açık olan database i kapat.
    }


    // Tüm Kaydı Getirmek.
    public List<Kelimeler> getAllKisiler() {
        List<Kelimeler> kelimelerList = new ArrayList<Kelimeler>();
        // Tüm Kisiler Tablosunu Getir.
        String selectQuery = "SELECT * FROM " + TABLE_KELIMELER;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Döngü Oluşturmak ve Sırasyıla Eklemek.
        if (cursor.moveToFirst()) {
            do {
                Kelimeler kelimeler = new Kelimeler();
                kelimeler.setID(Integer.parseInt(cursor.getString(0)));
                kelimeler.setTurkce(cursor.getString(1));
                kelimeler.setIngilizce(cursor.getString(2));

                // Kişileri listeye eklemek.
                kelimelerList.add(kelimeler);
            } while (cursor.moveToNext());
        }

        // return KisilerList
        return kelimelerList;
    }

    // Kelime Tablosundan istenilen kaydı getirme
    Kelimeler getKelime(String turkce) {

        String secilenSütun = "SELECT  * FROM " + TABLE_KELIMELER + " WHERE "
                + KEY_TURKCE + " =? " + turkce;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(secilenSütun, null);

        if (c.moveToFirst()) {
            do {
                Kelimeler kelimeler = new Kelimeler();
                kelimeler.setIngilizce(Integer.parseInt(c.getColumnIndex(KEY_INGILIZCE)));

            } while (c.moveToNext());
        }

    }



        /*
        String[] sutunlar = new String[] { KEY_ID, KEY_TURKCE, KEY_INGILIZCE };
        Cursor cursor = null;
        cursor.moveToNext();
        cursor =db.query(TABLE_KELIMELER, sutunlar, KEY_ID + "="
                + id, null, null, null, null);
        Cursor cursor = db.query(TABLE_KELIMELER, new String[] { KEY_ID,
                        KEY_TURKCE, KEY_INGILIZCE}, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        Kelimeler kelimeler = new Kelimeler(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));*/



    // Kelime Tablosunu Güncellemek(Update)
    public int updateKisiler(Kelimeler kelimeler) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TURKCE, kelimeler.getTurkce());
        values.put(KEY_INGILIZCE, kelimeler.getIngilizce());


        // updating row
        return db.update(TABLE_KELIMELER, values, KEY_ID + " = ?",
                new String[] { String.valueOf(kelimeler.getID()) });
    }

    // Kelime Tablosundan Tek Kayıt Silmek(Delete)
    public void deleteKisiler(Kelimeler kelimeler) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_KELIMELER, KEY_ID + " = ?",
                new String[] { String.valueOf(kelimeler.getID()) });
        db.close();
    }

    // Kelime Tablosunun Kayıt Sayısı
    public int getKisilersCount() {
        String countQuery = "SELECT  * FROM " + TABLE_KELIMELER;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }



}



