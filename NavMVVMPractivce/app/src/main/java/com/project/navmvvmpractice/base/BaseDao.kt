package com.project.navmvvmpractice.base

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Transaction

@Dao
interface BaseDao<E: Any> {
    @Transaction
    @Insert
    suspend fun insert(vararg elements: E)

    @Transaction
    @Insert
    suspend fun insert(elements: List<E>)

    @Transaction
    @Insert
    suspend fun delete(vararg elements: E)

    @Transaction
    @Insert
    suspend fun delete(elements: List<E>)

    @Transaction
    @Insert
    suspend fun update(vararg elements: E)

    @Transaction
    @Insert
    suspend fun update(elements: List<E>)

}