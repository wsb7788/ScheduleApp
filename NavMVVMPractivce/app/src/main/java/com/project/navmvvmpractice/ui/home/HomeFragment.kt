package com.project.navmvvmpractice.ui.home

import android.content.Context
import android.content.Intent
import android.view.*
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.project.navmvvmpractice.base.BaseFragment
import com.project.navmvvmpractice.R
import com.project.navmvvmpractice.data.remote.home.HomeListener
import com.project.navmvvmpractice.databinding.FragmentHomeBinding
import com.project.navmvvmpractice.ui.home.todo.AddTodoActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home), HomeListener {

    val viewModel : HomeViewModel by viewModels()

    override fun initView() {
        viewModel.homeListener = this
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        initNav()
        initToolbar()
        observePlus()

    }

    private fun observePlus() {
        viewModel.isExpended.observe(this){
            if(it){
                binding.fabPlus.animate().rotation(45f).setDuration(300).start()
                binding.fabTodo.visibility = VISIBLE
                binding.fabAlarm.visibility = VISIBLE
            }else{
                binding.fabPlus.animate().rotation(0f).setDuration(300).start()
                binding.fabTodo.visibility = GONE
                binding.fabAlarm.visibility = GONE
            }
        }
    }

    private fun initNav() {
        val asd = childFragmentManager.findFragmentById(R.id.fcv_home) as NavHostFragment
        NavigationUI.setupWithNavController(binding.navHome,asd.navController)

    }

    private fun initToolbar() {
        binding.tbHome.setNavigationIcon(R.drawable.ic_menu_icon)
        binding.tbHome.setNavigationOnClickListener{
            binding.dlHome.openDrawer(binding.navHome)
        }
        binding.tbHome.setPadding(0,getStatusBarHeight(requireContext()), 0, 0)
        val param = binding.fcvHome.layoutParams as ViewGroup.MarginLayoutParams
        param.setMargins(0,0,0,getNaviBarHeight(requireContext()))
        binding.fcvHome.layoutParams = param


    }
    private fun getStatusBarHeight(context: Context): Int {
        val resourceId = context.resources.getIdentifier("status_bar_height", "dimen", "android")

        return if (resourceId > 0) {
            context.resources.getDimensionPixelSize(resourceId)
        } else {
            0
        }
    }

    private fun getNaviBarHeight(context: Context): Int {
        val resourceId: Int = context.resources.getIdentifier("navigation_bar_height", "dimen", "android")
        return if (resourceId > 0) {
            context.resources.getDimensionPixelSize(resourceId)
        } else {
            0
        }
    }

    override fun onPlusClicked() {

    }

    override fun onTodoClicked(message:String) {
        Toast.makeText(requireContext(),message,Toast.LENGTH_SHORT).show()
        val intent = Intent(requireContext(),AddTodoActivity::class.java)
        startActivity(intent)
    }

    override fun onAlarmClicked() {

    }


}