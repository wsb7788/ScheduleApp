package com.project.SchedulerApp.ui.home.todo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.project.SchedulerApp.data.entites.Todo
import com.project.SchedulerApp.data.remote.home.todo.TodoListener
import com.project.SchedulerApp.room.dao.Database
import com.project.SchedulerApp.util.DataStoreManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject



@HiltViewModel
class TodoViewModel @Inject constructor(private val database: Database, private val dataStoreManager: DataStoreManager ): ViewModel() {

    var todoListener: TodoListener? = null

    val list = Pager(PagingConfig(10)){
        TodoPaging(database,dataStoreManager)
    }.flow.cachedIn(viewModelScope)



    fun onItemClicked(data: Todo) {
        viewModelScope.launch{
            try {

                database.todoDao().update(Todo(data.index,data.id,data.task, !data.complete ))
                todoListener?.onSuccess("성공")

            }catch (e:Exception){
                todoListener?.onFailure(e.message!!)
            }
        }


    }






}