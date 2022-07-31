package com.project.navmvvmpractice.ui.home.todo

import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.navmvvmpractice.base.BaseFragment
import com.project.navmvvmpractice.R
import com.project.navmvvmpractice.databinding.FragmentTodoBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@AndroidEntryPoint
class TodoFragment : BaseFragment<FragmentTodoBinding>(R.layout.fragment_todo) {

    val viewModel: TodoViewModel by viewModels()

    private val pagingAdapter by lazy { TodoPagingAdapter() }


    override fun initView() {

        initRecycler()

    }

    private fun initRecycler(){
        binding.rcvTodo.apply {
            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
            adapter = pagingAdapter
        }

        lifecycleScope.launch{
            viewModel.list.collectLatest {
                pagingAdapter.submitData(lifecycle,it)
            }
        }

    }



}