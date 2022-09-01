package com.project.navmvvmpractice.ui.splash

import androidx.navigation.fragment.findNavController
import com.project.navmvvmpractice.base.BaseFragment
import com.project.navmvvmpractice.R
import com.project.navmvvmpractice.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : BaseFragment<FragmentSplashBinding>(R.layout.fragment_splash) {




    override fun initView() {
        findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToLoginNavigation())
    }


}