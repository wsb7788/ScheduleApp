package com.example.kotlinpractice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recyclerview.*

class RecyclerViewActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview)


        val DataList = arrayListOf(
            Data(R.drawable.example_resize, "0번"),
            Data(R.drawable.example_resize, "1번"),
            Data(R.drawable.example_resize, "2번"),
            Data(R.drawable.example_resize, "3번"),
            Data(R.drawable.example_resize, "4번"),
            Data(R.drawable.example_resize, "5번"),
            Data(R.drawable.example_resize, "6번"),
            Data(R.drawable.example_resize, "7번"),
            Data(R.drawable.example_resize, "8번"),
            Data(R.drawable.example_resize, "9번"),
            Data(R.drawable.example_resize, "10번"),
            Data(R.drawable.example_resize, "11번")
        )
        recyclerView.layoutManager = LinearLayoutManager(this)          //스크롤 뷰 안에 리니어 레이아웃을 더해준 것과 같이 스크롤이 되게 함
        recyclerView.adapter = CustomAdapterForRecyclerView(DataList,this)


    }
}