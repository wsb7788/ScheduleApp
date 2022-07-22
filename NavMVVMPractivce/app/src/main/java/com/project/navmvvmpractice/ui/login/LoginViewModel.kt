package com.project.navmvvmpractice.ui.login

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.project.navmvvmpractice.data.entites.User
import com.project.navmvvmpractice.data.remote.login.LoginListener
import com.project.navmvvmpractice.data.remote.login.SignUpListener
import com.project.navmvvmpractice.room.dao.Database
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.coroutineContext

@HiltViewModel
class LoginViewModel @Inject constructor(private val userDatabase:Database) : ViewModel() {

    var loginListener: LoginListener? = null
    var signUpListener: SignUpListener? = null


    val id = MutableLiveData<String>("")


    fun onLoginClicked() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val id = id.value
                val result = userDatabase.userDao().findId(id!!)
                result.let {
                    loginListener!!.onLoginFailure("아이디 및 비밀번호가 일치하지 않습니다.")
                    return@launch
                }
                loginListener!!.onLoginSuccess()
            }
            catch (e: Exception){
                loginListener!!.onLoginFailure(e.message!!)
            }
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