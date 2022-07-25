package com.project.navmvvmpractice.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.project.navmvvmpractice.BaseFragment
import com.project.navmvvmpractice.R
import com.project.navmvvmpractice.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {



    override fun initView() {
        val asd = childFragmentManager.findFragmentById(R.id.fcv_home) as NavHostFragment
        NavigationUI.setupWithNavController(binding.navHome,asd.navController)

    }


}