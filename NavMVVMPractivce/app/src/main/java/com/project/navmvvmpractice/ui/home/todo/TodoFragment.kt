package com.project.navmvvmpractice.ui.home.todo

import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.navmvvmpractice.base.BaseFragment
import com.project.navmvvmpractice.R
import com.project.navmvvmpractice.databinding.FragmentTodoBinding
import dagger.hilt.android.AndroidEntryPoint


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

        viewModel.list.observe(viewLifecycleOwner){
            pagingAdapter.submitData(lifecycle,it)
        }
    }



}