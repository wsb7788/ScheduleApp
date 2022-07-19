package com.project.navmvvmpractice.data.remote.login

import android.view.View

interface LoginListener {
    abstract fun onLoginSuccess()
    abstract fun onLoginFailure()
    abstract fun onSignUpClicked()
}