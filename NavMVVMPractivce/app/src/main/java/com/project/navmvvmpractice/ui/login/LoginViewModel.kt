package com.project.navmvvmpractice.ui.login

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.project.navmvvmpractice.data.remote.login.LoginListener
import com.project.navmvvmpractice.data.remote.login.SignUpListener
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    var loginListener: LoginListener? = null
    var signUpListener: SignUpListener? = null


    val id = MutableLiveData<String>("")


    fun onLoginClicked() {
        when (id.value) {
            "123" -> loginListener!!.onLoginSuccess()
            else -> id.postValue("응아니야")
        }
    }

    fun onSignInClicked() {
        loginListener!!.onSignUpClicked()

    }

    fun onConfirmClicked(){

    }
    fun onCancelClicked(){
        signUpListener!!.onCancelClicked()
    }

}