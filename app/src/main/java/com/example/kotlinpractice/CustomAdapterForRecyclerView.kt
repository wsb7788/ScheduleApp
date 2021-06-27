package com.example.kotlinpractice

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.custom_list.view.*

class Data(val profile: Int, val name: String)

class CustomViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    val profile = v.iv_custom
    val name = v.tv_custom
}

class CustomAdapterForRecyclerView(val context: Context) :
    RecyclerView.Adapter<CustomViewHolder>() {

    val DataList = arrayListOf(                             //데이터까지도 여기서 처리할 수 있음
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
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val cellForRow =
            LayoutInflater.from(context).inflate(R.layout.custom_list, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val curData = DataList[position]
        holder.profile.setImageResource(curData.profile)
        holder.name.text = curData.name

        holder.itemView.setOnClickListener {
            Toast.makeText(context, curData.name, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount() = DataList.size         //데이터 갯수

}