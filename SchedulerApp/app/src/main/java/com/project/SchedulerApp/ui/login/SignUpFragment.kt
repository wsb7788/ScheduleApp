package com.project.SchedulerApp.ui.login

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.project.SchedulerApp.base.BaseFragment
import com.project.SchedulerApp.R
import com.project.SchedulerApp.data.remote.login.SignUpListener
import com.project.SchedulerApp.databinding.FragmentSignUpBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpFragment : BaseFragment<FragmentSignUpBinding>(R.layout.fragment_sign_up), SignUpListener {


    val viewModel : LoginViewModel by viewModels()

    override fun initView() {
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        viewModel.signUpListener = this


    }

    override fun onCancelClicked() {
        findNavController().popBackStack()
    }

    override fun onSuccess() {
        findNavController().popBackStack()
    }

    override fun onFailure(text: String) {
        Toast.makeText(requireContext(),text, Toast.LENGTH_SHORT).show()

    }



}