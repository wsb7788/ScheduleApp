package com.example.kotlinpractice

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_tablayout.*

class TabLayoutActivity:AppCompatActivity(){

    var viewList = ArrayList<View>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tablayout)

        viewList.add(layoutInflater.inflate(R.layout.fragment_home, null))
        viewList.add(layoutInflater.inflate(R.layout.fragment_favorite, null))
        viewList.add(layoutInflater.inflate(R.layout.fragment_profile, null))

/*        viewPager.adapter = pagerAdapter()

        tabLayout.setupWithViewPager(viewPager)*/



    }

/*    inner class pagerAdapter: pagerAdapter(){

    }*/
}