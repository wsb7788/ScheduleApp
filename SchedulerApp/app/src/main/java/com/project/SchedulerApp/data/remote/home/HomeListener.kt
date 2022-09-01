package com.project.SchedulerApp.data.remote.home

interface HomeListener {
    abstract fun onPlusClicked()
    abstract fun onTodoClicked()
    abstract fun onAlarmClicked()
}