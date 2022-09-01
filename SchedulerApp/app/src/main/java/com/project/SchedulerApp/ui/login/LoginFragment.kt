package com.project.SchedulerApp.ui.login

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.project.SchedulerApp.base.BaseFragment
import com.project.SchedulerApp.R
import com.project.SchedulerApp.data.remote.login.LoginListener
import com.project.SchedulerApp.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

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
        binding.lifecycleOwner = viewLifecycleOwner
    }


}