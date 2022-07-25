package com.project.navmvvmpractice.ui.home

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.*
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.project.navmvvmpractice.BaseFragment
import com.project.navmvvmpractice.R
import com.project.navmvvmpractice.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.view.*


@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {



    override fun initView() {
        initNav()
        initToolbar()
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






}