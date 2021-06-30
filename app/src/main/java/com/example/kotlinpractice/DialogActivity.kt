package com.example.kotlinpractice

import android.content.DialogInterface
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_vibrate.*

class DialogActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vibrate)

        vib_Btn.setOnClickListener {
            var ad = AlertDialog.Builder(this)
            ad.setIcon(R.mipmap.ic_launcher)
            ad.setTitle("제목")
            ad.setMessage("내용")
            ad.setView(EditText(this))
            ad.setPositiveButton("네", object: DialogInterface.OnClickListener{
                override fun onClick(p0: DialogInterface?, p1: Int){
                    println("네 클릭")
                    p0?.dismiss()
                }
            })

            ad.setNegativeButton("아니오", object: DialogInterface.OnClickListener{
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    println("클릭")
                    p0?.dismiss()
                }
            })
            ad.show()
        }
    }
}