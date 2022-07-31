package com.project.navmvvmpractice.ui.home.todo

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import androidx.room.RoomDatabase
import com.project.navmvvmpractice.data.entites.Todo
import com.project.navmvvmpractice.room.dao.Database
import com.project.navmvvmpractice.util.DataStoreManager
import kotlinx.coroutines.delay

class TodoPaging(private val database: Database, private val dataStoreManager: DataStoreManager):PagingSource<Int, Todo>() {

    override fun getRefreshKey(state: PagingState<Int, Todo>): Int? {
        return state.anchorPosition?.let {
            val anchorPage = state.closestPageToPosition(it)
            anchorPage?.prevKey?.plus(1)?:anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Todo> {
        val page = params.key?:0
        return try{
            val id = dataStoreManager.getId()?: ""
            val data = database.todoDao().getTodoList(id,params.loadSize, page * params.loadSize)
            if(page != 0) delay(1000)
            LoadResult.Page(
                data = data,
                prevKey = if(page == 1) null else page-1,
                nextKey = if(data.isEmpty()) null else page + 1
            )
        }catch (e: Exception){
            Log.d("123123",e.message!!)
            LoadResult.Error(e)
        }
    }
}
