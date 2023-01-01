package com.example.menuluveritabanlibasic

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

private val DB_NAME = "veriler"
private val DB_VERSION = 1
private val TABLO_NOT = "notlar"
private val ROW_ID = "id"
private val ROW_AD = "ad"
private val ROW_VN = "vize"
private val ROW_FN = "final"
private val ROW_BN = "basari"

class veritabani(context: Context?) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE IF NOT EXISTS $TABLO_NOT ($ROW_ID INTEGER PRIMARY KEY AUTOINCREMENT, $ROW_AD TEXT NOT NULL, $ROW_VN INTEGER NOT NULL, $ROW_FN INTEGER NOT NULL, $ROW_BN INTEGER NOT NULL)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLO_NOT")
        onCreate(db)
    }

    fun ekle(ad: String, vize: Int, final: Int, basari: Int){
        val db = this.writableDatabase
        val cv = ContentValues()

        cv.put(ROW_AD, ad)
        cv.put(ROW_VN, vize)
        cv.put(ROW_FN, final)
        cv.put(ROW_BN, basari)

        db.insert(TABLO_NOT, null, cv)

        db.close()
    }

    fun sil(kisiId: Int){
        val db = this.writableDatabase

        val konum = "$ROW_ID = $kisiId"

        db.delete(TABLO_NOT, konum, null)

        db.close()
    }

    fun guncelle(kisiId: Int, ad: String, vize: Int, final: Int, basari: Int){
        val db = this.writableDatabase
        val cv = ContentValues()

        cv.put(ROW_AD, ad)
        cv.put(ROW_VN, vize)
        cv.put(ROW_FN, final)
        cv.put(ROW_BN, basari)

        val konum = "$ROW_ID = $kisiId"

        db.update(TABLO_NOT, cv, konum, null)

        db.close()
    }

    fun listele(): ArrayList<String>{
        val db = this.readableDatabase
        val list = ArrayList<String>()
        val sutunlar = arrayOf(ROW_ID, ROW_AD, ROW_VN, ROW_FN, ROW_BN)

        val cursor = db.query(TABLO_NOT, sutunlar, null, null, null, null, null)

        while (cursor.moveToNext()){
            list.add(cursor.getInt(0).toString() + " - " + cursor.getString(1) + " - " + cursor.getInt(2).toString() + " - " + cursor.getInt(3).toString() + " - " + cursor.getInt(4).toString())
        }

        db.close()
        return list
    }

}