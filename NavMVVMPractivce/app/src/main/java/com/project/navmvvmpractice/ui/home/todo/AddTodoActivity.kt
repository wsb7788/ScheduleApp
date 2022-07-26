package com.project.navmvvmpractice.ui.home.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.project.navmvvmpractice.R
import com.project.navmvvmpractice.base.BaseActivity
import com.project.navmvvmpractice.databinding.ActivityAddTodoBinding

class AddTodoActivity : BaseActivity<ActivityAddTodoBinding>(R.layout.activity_add_todo) {
    override fun initView() {
        Toast.makeText(this,"하이",Toast.LENGTH_SHORT).show()
    }

}