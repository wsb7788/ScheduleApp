package com.example.kotlinpractice

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class DataStoreAndRemove:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vibrate)

        val pref = getSharedPreferences("pref", Context.MODE_PRIVATE)
        pref.edit().putString("키","값").apply()                  //저장
        val value = pref.getString("키","저장안됨")      //불러오기
        println(value)
        pref.edit().remove("키").apply()                         //제거
        pref.edit().clear().apply()                                 //전체제거거
    }
}
