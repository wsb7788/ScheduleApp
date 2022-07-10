package com.project.movieapp.utils

class Events<out T>(private val content:T) {

    var hasBeenHandeled = false

    fun getContentIfNotHandled():T?{
        return if(!hasBeenHandeled){
            hasBeenHandeled = true
            content
        } else{
            null
        }
    }

    fun peekContent():T = content
}