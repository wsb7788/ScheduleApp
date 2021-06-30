package com.example.kotlinpractice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_fragment.*

class FragmentActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        frame_btn1.setOnClickListener { supportFragmentManager.beginTransaction().replace(R.id.frameLayout, OneFragment()).commit() }
        frame_btn2.setOnClickListener { supportFragmentManager.beginTransaction().replace(R.id.frameLayout, TwoFragment()).commit() }

    }

}

class OneFragment:Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.freg1, container, false)
}
class TwoFragment:Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.freg2, container, false)
}