package com.project.navmvvmpractice.ui.home.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.project.navmvvmpractice.R
import com.project.navmvvmpractice.base.BaseActivity
import com.project.navmvvmpractice.data.remote.home.todo.AddTodoListener
import com.project.navmvvmpractice.databinding.ActivityAddTodoBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlin.system.exitProcess

@AndroidEntryPoint
class AddTodoActivity : BaseActivity<ActivityAddTodoBinding>(R.layout.activity_add_todo), AddTodoListener {

    val viewModel : AddTodoViewModel by viewModels()

    override fun initView() {
        binding.lifecycleOwner = this
        viewModel.addTodoListener = this
        binding.viewModel = viewModel

    }

    override fun onSuccess() {
        Toast.makeText(baseContext,"성공",Toast.LENGTH_SHORT).show()
        finish()
    }

    override fun onCancelClicked() {
        finish()
    }

    override fun onFailure(message: String) {
        Toast.makeText(baseContext,message,Toast.LENGTH_SHORT).show()
    }


}