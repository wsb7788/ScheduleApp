package com.example.kotlinpractice

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethod
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_java.*
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

        var pref = this.getPreferences(0)
        et_email.setText(pref.getString("이메일", ""))         //.text를 안 쓰는 이유 = 타입이 다르다고 뜸, 저장되어 있지 않으면 ""을 불러옴
        et_password.setText(pref.getString("비밀번호", ""))
        et_name.setText(pref.getString("이름", ""))
        et_age.setText(pref.getString("나이", ""))
    }

    fun Login(v: View){
        // 키보드 숨기기
        var imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(v.windowToken, 0)

        // 입력정보 비교
        if(et_email.text.toString() == "wsb0514@naver.com" && et_password.text.toString() =="1234" && et_name.text.toString() == "가나다" && et_age.text.toString() == "24"){
            Toast.makeText(this, "로그인 성공!!", Toast.LENGTH_SHORT).show()
//          startActivity(Intent(this, JavaActivity::class.java))       //같은동작 1
//          /*var intent = Intent(this, JavaActivity::class.java)                           //같은 동작 2
          /* intent.putExtra("이름", "고라니")
           startActivity(intent)*/
            setContentView(R.layout.activity_java)                                     //같은 동작 3
            tv_result.text = "반갑다 승빈아"
            var editor = this.getPreferences(0 ).edit()
            editor.putString("이메일", "wsb0514@naver.com").apply()
            editor.putString("비밀번호", "1234").apply()
            editor.putString("이름", "가나다").apply()
            editor.putString("나이", "24").apply()
        }

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