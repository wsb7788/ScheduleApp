package com.project.navmvvmpractice.room.dao

import androidx.room.Dao
import com.project.navmvvmpractice.base.BaseDao
import com.project.navmvvmpractice.data.entites.Todo

@Dao
interface TodoDao:BaseDao<Todo> {


}