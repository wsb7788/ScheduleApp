package com.example.kotlinpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {        //물음표 - nullable
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

/*        sum(1,2f)

        println(describe(1))

        val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
        fruits
            .filter{it.startsWith("a")}
            .sortedBy { it }
            .map{it.toUpperCase()}
            .forEach{println(it)}*/

        btn.setOnClickListener{
            Toast.makeText(this,"asdf",Toast.LENGTH_SHORT).show()
        }
    }
    fun sum(a: Int, b: Float) {
        println("$a 와 $b 의 합은 ${a+b}")
    }

    fun parseInt(str: String):Int?{
        var maNum: Int? = null

        try{maNum = str.toInt()}
        catch(nfe : NumberFormatException){return null}
        return maNum
    }
    fun describe(obj: Any): String =
        when(obj){              //해당되는게 있으면 실행 후 나감
            1 -> "One"
            "Hello" -> "Greeting"
            is Long -> "Long"
            !is String -> "Not a String"
            else -> "Unknown"
        }
    fun clclick(v : View){
        text.text = "123"
    }

}