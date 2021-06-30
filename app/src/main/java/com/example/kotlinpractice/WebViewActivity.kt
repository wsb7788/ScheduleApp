package com.example.kotlinpractice

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_webview.*

class WebViewActivity:AppCompatActivity() {

    var lastTimeBackPressed = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)

        webView.webViewClient = WebViewClient()                 //새로운 창을 방지하는 기능

        Load(googleBtn)

    }

    fun Load(v: View){
        when(v.id){
            R.id.googleBtn -> webView.loadUrl("https://www.google.com/")
            R.id.naverBtn -> webView.loadUrl("https://m.naver.com/")
        }
    }
    override fun onBackPressed() {
        if(webView.canGoBack()) webView.goBack()
        else
        {
            if(System.currentTimeMillis() - lastTimeBackPressed < 1500){
                finish()
                return
            }
            lastTimeBackPressed = System.currentTimeMillis()
            Toast.makeText(this, "'뒤로' 버튼을 한 번 더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show()
        }
     }


}