package com.example.kotlinpractice

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_listview.*

class ListViewActivity :AppCompatActivity(){
    var DataList = arrayListOf(
        Data(R.drawable.icecream, "0번"),        //사진 파일을 int 형태로 전달할것
        Data(R.drawable.icecream, "1번"),
        Data(R.drawable.icecream, "2번"),
        Data(R.drawable.icecream, "3번")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listview)

        listView.adapter = CustomAdapter(this, DataList)        //커스텀어뎁터임. CustomAdapter.kt랑 같이 보기
/*        val item = arrayOf("0번", "1번", "2번", "3번", "4번", "5번", "6번", "7번", "8번", "9번", "10번", "11번", "12번")       값 넣고 리스트 대입
        listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, item)*/

        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->                    //누르면 할 동작작
           val selectItem = parent.getItemAtPosition(position) as Data
            Toast.makeText(this, selectItem.name, Toast.LENGTH_SHORT).show()
        }
    }
}