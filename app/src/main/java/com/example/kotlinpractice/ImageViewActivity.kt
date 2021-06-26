package com.example.kotlinpractice

import android.content.Intent
import android.graphics.Matrix
import android.os.Bundle
import android.os.PersistableBundle
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_imageview.*

class ImageViewActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imageview)
        title = "ImageViewActivity"
       /* iv_basic.scaleType = ImageView.ScaleType.MATRIX

        val matrix=  Matrix()
        matrix.postRotate(30f)
        iv_basic.imageMatrix = matrix*/
    }
 /*   fun LoadImage(v: View){
        startActivityForResult(Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI),0)          //이미지 클릭했을 때 갤러리에서 선택
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {           //선택한 사진을 이미지뷰에 설정
        super.onActivityResult(requestCode, resultCode, data)
        if(data != null) iv_basic.setImageURI(data?.data)
    }*/
    fun Click(v: View){
        iv_1.visibility=View.INVISIBLE
        iv_2.visibility=View.INVISIBLE
        iv_3.visibility=View.INVISIBLE

        when(v){
            btn1 -> iv_1.visibility = View.VISIBLE
            btn2 -> iv_2.visibility = View.VISIBLE
            btn3 -> iv_3.visibility = View.VISIBLE
        }
    }
}