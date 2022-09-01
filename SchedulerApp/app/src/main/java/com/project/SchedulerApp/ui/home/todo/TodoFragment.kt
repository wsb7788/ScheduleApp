package com.project.SchedulerApp.ui.home.todo

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.project.SchedulerApp.base.BaseFragment
import com.project.SchedulerApp.R
import com.project.SchedulerApp.data.remote.home.todo.TodoListener
import com.project.SchedulerApp.databinding.FragmentTodoBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@AndroidEntryPoint
class TodoFragment : BaseFragment<FragmentTodoBinding>(R.layout.fragment_todo), TodoListener {

    val viewModel: TodoViewModel by viewModels()


    private val pagingAdapter by lazy { TodoPagingAdapter() }


    override fun initView() {

        binding.lifecycleOwner = viewLifecycleOwner
        viewModel.todoListener = this

        initRecycler()



    }

    override fun onResume() {
        super.onResume()

        pagingAdapter.refresh()
    }

    private fun initRecycler(){
        binding.rcvTodo.apply {
            adapter = pagingAdapter
        }

        lifecycleScope.launch{
            viewModel.list.collectLatest {
                pagingAdapter.submitData(lifecycle,it)
            }
        }
        pagingAdapter.onClicked {
            viewModel.onItemClicked(it)
        }

    }

    override fun onFailure(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun onSuccess(message: String) {
        pagingAdapter.refresh()
    }


}