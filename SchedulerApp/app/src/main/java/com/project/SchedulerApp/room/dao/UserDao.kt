package com.project.SchedulerApp.room.dao

import androidx.room.Dao
import androidx.room.Query
import com.project.SchedulerApp.base.BaseDao
import com.project.SchedulerApp.data.entites.User

@Dao
interface UserDao : BaseDao<User> {

    @Query("SELECT * FROM User WHERE id = :id")
    suspend fun findId(id: String): User?
}