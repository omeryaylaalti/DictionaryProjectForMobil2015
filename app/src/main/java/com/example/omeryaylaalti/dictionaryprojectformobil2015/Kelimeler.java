package com.example.omeryaylaalti.dictionaryprojectformobil2015;


public class Kelimeler {

    // Private değişkenler
    int _id;
    String turkce_kelime;
    String ingilizce_kelime;


    // Varsayılan Yapılandırıcı Metod
    public Kelimeler(){

    }
    // Yapılandırıcı Metod
    public Kelimeler(int id, String turkce_kelime, String ingilizce_kelime){
        this._id = id;
        this.turkce_kelime = turkce_kelime;
        this.ingilizce_kelime = ingilizce_kelime;

    }

    // Yapılandırıcı Metod
    public Kelimeler(String turkce_kelime, String ingilizce_kelime){
        this.turkce_kelime = turkce_kelime;
        this.ingilizce_kelime = ingilizce_kelime;

    }

    // ID yi belirle.
    public void setID(int id){
        this._id = id;
    }
    // ID yi getir.
    public int getID(){
        return this._id;
    }

    // Turkce kelimeyi belirle.
    public void setTurkce(String turkce_kelime){
        this.turkce_kelime = turkce_kelime;
    }
    // Turkce kelime getir.
    public String getTurkce(){
        return this.turkce_kelime;
    }

    // İngilizce kelime belirle.
    public void setIngilizce(String ingilizce_kelime){
        this.ingilizce_kelime = ingilizce_kelime;
    }
    // İngilzce kelime getir.
    public String getIngilizce(){
        return this.ingilizce_kelime;
    }


}