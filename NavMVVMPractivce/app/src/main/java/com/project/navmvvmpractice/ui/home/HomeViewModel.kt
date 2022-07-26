package com.project.navmvvmpractice.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.project.navmvvmpractice.data.remote.home.HomeListener
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor():ViewModel() {

    var homeListener : HomeListener? = null
    var isExpended = MutableLiveData<Boolean>(false)


    fun onPlusClicked(){
        val value = isExpended.value
        isExpended.value = !value!!
    }
     fun onTodoClicked(){
        homeListener!!.onTodoClicked()
    }
     fun onAlarmClicked(){
        homeListener!!.onAlarmClicked()
    }


}