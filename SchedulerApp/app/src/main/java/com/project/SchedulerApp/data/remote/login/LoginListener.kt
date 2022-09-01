package com.project.SchedulerApp.data.remote.login

interface LoginListener {
    abstract fun onLoginSuccess()

    abstract fun onLoginFailure(message: String)
    abstract fun onSignUpClicked()
}