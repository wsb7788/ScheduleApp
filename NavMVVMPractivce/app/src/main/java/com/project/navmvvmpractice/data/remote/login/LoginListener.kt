package com.project.navmvvmpractice.data.remote.login

import android.view.View

interface LoginListener {
    abstract fun onLoginSucess()
    abstract fun onLoginFailure()
}