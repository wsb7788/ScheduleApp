package com.project.navmvvmpractice.ui.home

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

        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }




}