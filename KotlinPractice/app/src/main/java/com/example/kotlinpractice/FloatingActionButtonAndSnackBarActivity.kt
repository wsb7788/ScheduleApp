package com.example.kotlinpractice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_floatingactionbuttonandsnackbar.*

class FloatingActionButtonAndSnackBarActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_floatingactionbuttonandsnackbar)


        fab.setOnClickListener{view ->
            Snackbar.make(view, "스낵바!", Snackbar.LENGTH_LONG).setAction("클릭", {view -> println("ㅎㅇ")}).show()
        }
    }
}