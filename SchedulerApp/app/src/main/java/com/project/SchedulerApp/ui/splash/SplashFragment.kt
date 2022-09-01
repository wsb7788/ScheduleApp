package com.project.SchedulerApp.ui.splash

import androidx.navigation.fragment.findNavController
import com.project.SchedulerApp.base.BaseFragment
import com.project.SchedulerApp.R
import com.project.SchedulerApp.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : BaseFragment<FragmentSplashBinding>(R.layout.fragment_splash) {




    override fun initView() {
        findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToLoginNavigation())
    }


}