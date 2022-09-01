package com.project.SchedulerApp.room.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.project.SchedulerApp.data.entites.Todo
import com.project.SchedulerApp.data.entites.User


@Database(entities = [User::class, Todo::class], version = 6)

abstract class Database:RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun todoDao(): TodoDao
}