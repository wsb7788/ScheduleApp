package com.example.kotlinpractice

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethod
import android.view.inputmethod.InputMethodManager
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
/*
        btn.setOnClickListener{
            Toast.makeText(this,"asdf",Toast.LENGTH_SHORT).show()
        }*/
        et_email.imeOptions = EditorInfo.IME_ACTION_DONE

        // 마지막 에딧텍스트 완료버튼은 Login 호출
        et_age.setOnEditorActionListener() { v, actionId, event ->
            if(actionId == EditorInfo.IME_ACTION_DONE){
                Login(v)
                true
            } else false
        }
    }

    fun Login(v: View){
        // 키보드 숨기기
        var imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(v.windowToken, 0)

        // 입력정보 비교
        if(et_email.text.toString() == "wsb0514@naver.com" && et_password.text.toString() =="1234" && et_name.text.toString() == "가나다" && et_age.text.toString() == "24")
            Toast.makeText(this, "로그인 성공!!", Toast.LENGTH_SHORT).show()
        else Toast.makeText(this, "로그인 실패 ㅠㅠ", Toast.LENGTH_SHORT).show()
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