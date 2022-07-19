package com.project.navmvvmpractice.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.project.navmvvmpractice.BaseFragment
import com.project.navmvvmpractice.R
import com.project.navmvvmpractice.data.remote.login.SignUpListener
import com.project.navmvvmpractice.databinding.FragmentSignUpBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpFragment : BaseFragment<FragmentSignUpBinding>(R.layout.fragment_sign_up), SignUpListener {


    val viewModel : LoginViewModel by viewModels()

    override fun initView() {
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        viewModel.signUpListener = this
    }

    override fun onCancelClicked() {
        findNavController().popBackStack()
    }

    override fun onSuccess() {

    }

    override fun onFailure(text: String) {

    }



}