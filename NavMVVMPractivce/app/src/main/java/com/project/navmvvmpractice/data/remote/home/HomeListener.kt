package com.project.navmvvmpractice.data.remote.home

interface HomeListener {
    abstract fun onPlusClicked()
    abstract fun onTodoClicked(message:String)
    abstract fun onAlarmClicked()
}