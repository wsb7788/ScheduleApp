package com.project.navmvvmpractice.room.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.project.navmvvmpractice.data.entites.User


@Database(entities = [User::class], version = 1)

abstract class Database:RoomDatabase() {
    abstract fun userDao(): UserDao
}