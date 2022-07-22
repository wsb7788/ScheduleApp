package com.project.navmvvmpractice.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.project.navmvvmpractice.data.entites.User

@Dao
interface UserDao : BaseDao<User> {

    @Query("SELECT * FROM User WHERE id = :id")
    suspend fun findId(id: String): LiveData<MutableList<User>>


}