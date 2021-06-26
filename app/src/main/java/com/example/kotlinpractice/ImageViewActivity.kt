package com.example.kotlinpractice

import android.graphics.Matrix
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_imageview.*

class ImageViewActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_imageview)
        title = "ImageViewActivity"
       /* iv_basic.scaleType = ImageView.ScaleType.MATRIX

        val matrix=  Matrix()
        matrix.postRotate(30f)
        iv_basic.imageMatrix = matrix*/
    }
}