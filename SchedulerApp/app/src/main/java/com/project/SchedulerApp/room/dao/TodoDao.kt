package com.project.SchedulerApp.room.dao

import androidx.room.Dao
import androidx.room.Query
import com.project.SchedulerApp.base.BaseDao
import com.project.SchedulerApp.data.entites.Todo

@Dao
interface TodoDao:BaseDao<Todo> {

//limit = 출력할 행의 개수, offset = 출력을 시작할 행 번호
    @Query("SELECT * FROM Todo WHERE id = :id order by 'index' Limit :limit offset :offset")
    suspend fun getTodoList(id: String,limit:Int, offset:Int): List<Todo>

}