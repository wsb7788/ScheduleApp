package com.project.navmvvmpractice.data.remote.login

interface SignUpListener {
    abstract fun onCancelClicked()
    abstract fun onSuccess()
    abstract fun onFailure(text:String)

}