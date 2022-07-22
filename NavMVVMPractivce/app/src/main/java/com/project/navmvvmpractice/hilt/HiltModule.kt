package com.project.navmvvmpractice.hilt

import android.content.Context
import androidx.room.Room
import com.project.navmvvmpractice.room.dao.Database
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

}