package com.project.navmvvmpractice.ui.home.todo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.project.navmvvmpractice.room.dao.Database
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddTodoViewModel @Inject constructor(private val database: Database):ViewModel() {

    var todo = MutableLiveData<String>("")



    fun onCancelClicked(){

    }
    fun onConfirmClicked(){

    }

}