package com.project.navmvvmpractice.ui.home.todo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.project.navmvvmpractice.data.entites.Todo
import com.project.navmvvmpractice.room.dao.Database
import com.project.navmvvmpractice.util.DataStoreManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject



@HiltViewModel
class TodoViewModel @Inject constructor(private val database: Database, private val dataStoreManager: DataStoreManager ): ViewModel() {

    val list = Pager(PagingConfig(10)){
        TodoPaging(database,dataStoreManager)
    }.flow.cachedIn(viewModelScope)






}