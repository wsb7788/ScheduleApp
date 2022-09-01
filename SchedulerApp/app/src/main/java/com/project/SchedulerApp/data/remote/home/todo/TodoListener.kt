package com.project.SchedulerApp.data.remote.home.todo

interface TodoListener {
    abstract fun onFailure(message:String)
    abstract fun onSuccess(message:String)
}