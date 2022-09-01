package com.project.SchedulerApp.ui.home.todo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.SchedulerApp.data.entites.Todo
import com.project.SchedulerApp.data.remote.home.todo.AddTodoListener
import com.project.SchedulerApp.room.dao.Database
import com.project.SchedulerApp.util.DataStoreManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddTodoViewModel @Inject constructor(private val database: Database, private val dataStoreManager: DataStoreManager):ViewModel() {

    var todo = MutableLiveData<String>("")
    var addTodoListener : AddTodoListener? = null

    fun onCancelClicked(){
        addTodoListener!!.onCancelClicked()
    }
    fun onConfirmClicked(){
        viewModelScope.launch {
            val todo = todo.value
            if(todo.isNullOrEmpty()){
                addTodoListener!!.onFailure("내용을 입력하세요.")
                return@launch
            }


            try {
                val id = dataStoreManager.getId()
                database.todoDao().insert(Todo(id = id,task = todo))
                addTodoListener!!.onSuccess()
            }catch (e:Exception){
                addTodoListener!!.onFailure(e.message!!)
            }
        }

    }

}