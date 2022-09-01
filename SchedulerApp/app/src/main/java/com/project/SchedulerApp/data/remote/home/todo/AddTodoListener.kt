package com.project.SchedulerApp.data.remote.home.todo

interface AddTodoListener {
    abstract fun onSuccess()
    abstract fun onCancelClicked()
    abstract fun onFailure(message:String)
}