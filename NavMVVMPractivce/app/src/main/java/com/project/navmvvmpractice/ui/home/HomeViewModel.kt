package com.project.navmvvmpractice.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.project.navmvvmpractice.data.remote.home.HomeListener
import com.project.navmvvmpractice.util.DataStoreManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
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