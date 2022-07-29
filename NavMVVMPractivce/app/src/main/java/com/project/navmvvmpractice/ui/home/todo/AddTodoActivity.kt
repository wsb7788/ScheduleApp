package com.project.navmvvmpractice.ui.home.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.project.navmvvmpractice.R
import com.project.navmvvmpractice.base.BaseActivity
import com.project.navmvvmpractice.data.remote.home.todo.AddTodoListener
import com.project.navmvvmpractice.databinding.ActivityAddTodoBinding

class AddTodoActivity : BaseActivity<ActivityAddTodoBinding>(R.layout.activity_add_todo), AddTodoListener {


    override fun initView() {
    }

    override fun onSuccess() {
        return
    }

    override fun onCancelClicked() {
        return
    }


}