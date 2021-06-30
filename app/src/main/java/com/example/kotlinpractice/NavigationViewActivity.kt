package com.example.kotlinpractice

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_navigationview.*

class NavigationViewActivity:AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigationview)


        button.setOnClickListener{layout_drawer.openDrawer(GravityCompat.START)}
        naviView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.access -> println("엑세스 클릭")
            R.id.email -> println("이메일 클릭")
            R.id.send -> println("보내기 클릭")
        }
        layout_drawer.closeDrawers()
        return false
    }


    override fun onBackPressed() {
        if(layout_drawer.isDrawerOpen(GravityCompat.START)) layout_drawer.closeDrawers()
        else super.onBackPressed()
    }
}