package com.project.navmvvmpractice.ui.login

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.project.navmvvmpractice.data.remote.login.LoginListener
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    lateinit var loginListener: LoginListener


    val id = MutableLiveData<String>("")


    fun onLoginClicked() {
        Log.d("123", id.value.toString())
        when (id.value) {
            "123" -> loginListener.onLoginSucess()
            else -> id.postValue("응아니야")
        }
    }

    fun onSignInClicked(v: View) {

    }


}