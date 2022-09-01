package com.project.SchedulerApp.hilt

import android.content.Context
import androidx.room.Room
import com.project.SchedulerApp.room.dao.Database
import com.project.SchedulerApp.util.DataStoreManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object HiltModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context : Context) =
        Room.databaseBuilder(
            context,
            Database::class.java,
            "user_db"
        ).fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideUserDao(appDatabase: Database) = appDatabase.userDao()

    @Provides
    fun provideTodoDao(appDatabase: Database) = appDatabase.todoDao()

    @Provides
    @Singleton
    fun provideDataStore(@ApplicationContext context: Context): DataStoreManager =
        DataStoreManager(context)


}