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
class HomeViewModel @Inject constructor(private val dataStoreManager: DataStoreManager):ViewModel() {

    var homeListener : HomeListener? = null
    var isExpended = MutableLiveData<Boolean>(false)


    fun onPlusClicked(){
        val value = isExpended.value
        isExpended.value = !value!!
    }
     fun onTodoClicked(){
         CoroutineScope(Dispatchers.Main).launch{
             try {

                 homeListener!!.onTodoClicked(dataStoreManager.getId())
             }catch (e:Exception){
                 homeListener!!.onTodoClicked(e.message!!)
             }
         }

    }
     fun onAlarmClicked(){
        homeListener!!.onAlarmClicked()
    }


}