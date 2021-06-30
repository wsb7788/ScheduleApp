package com.example.kotlinpractice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_calenderview.*
import java.util.*

class CalenderViewActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calenderview)

        calendarView.setOnDateChangeListener{calendarView, year, month, day ->
           // println(year.toString()+"/"+month.toString()+"/"+day.toString())
        }
        val calendar = Calendar.getInstance()
        calendar.set(2020,5,30)
        calendarView.setDate(calendar.timeInMillis)
/*        println(calendar[Calendar.YEAR])
        println(calendar[Calendar.MONTH])
        println(calendar[Calendar.DAY_OF_MONTH])*/
    }
}