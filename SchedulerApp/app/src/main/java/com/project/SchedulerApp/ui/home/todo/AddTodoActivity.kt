package com.project.SchedulerApp.ui.home.todo

import android.widget.Toast
import androidx.activity.viewModels
import com.project.SchedulerApp.R
import com.project.SchedulerApp.base.BaseActivity
import com.project.SchedulerApp.data.remote.home.todo.AddTodoListener
import com.project.SchedulerApp.databinding.ActivityAddTodoBinding
import dagger.hilt.android.AndroidEntryPoint

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