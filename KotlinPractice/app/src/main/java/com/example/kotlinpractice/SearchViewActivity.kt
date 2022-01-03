package com.example.kotlinpractice

import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_searchview.*

class SearchViewActivity:AppCompatActivity() {

    var MyList = arrayOf("apple", "banana", "abc")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_searchview)


        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                println(p0 + "완료")
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                if(p0 != ""){
                    val curList = MyList.filter { x -> x.toLowerCase().contains(p0?.toLowerCase().toString())}
                    for(i in curList) println(i)
                    println("---------")
                }
                return true
            }
        })
    }
}