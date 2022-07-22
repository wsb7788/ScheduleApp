package com.project.navmvvmpractice.ui.login

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.project.navmvvmpractice.BaseFragment
import com.project.navmvvmpractice.R
import com.project.navmvvmpractice.data.remote.login.LoginListener
import com.project.navmvvmpractice.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.qualifiers.ApplicationContext

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>(R.layout.fragment_login), LoginListener {


    val viewModel: LoginViewModel by viewModels()




    override fun onLoginSuccess() {
        findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToHomeNavigation())
    }

    override fun onLoginFailure(message:String) {
        Toast.makeText(requireContext(),message,Toast.LENGTH_SHORT).show()
    }

    override fun onSignUpClicked() {
        findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToSignUpFragment())
    }

    override fun initView() {
        viewModel.loginListener = this
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }


}