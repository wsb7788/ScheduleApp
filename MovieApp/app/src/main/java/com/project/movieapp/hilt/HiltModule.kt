package com.project.movieapp.hilt

import com.project.movieapp.remote.MovieInterface
import com.project.movieapp.ui.details.MovieDetailsRepository
import com.project.movieapp.utils.Constans
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@InstallIn(SingletonComponent::class)
@Module
object HiltModule {


    @Provides
    fun provideRetrofitInterface():MovieInterface{
        return Retrofit.Builder().baseUrl(Constans.BASE_URL).addConverterFactory(
            GsonConverterFactory.create()
        ).build().create(MovieInterface::class.java)

    }

    @Provides
    fun provideRepository(movieInterface: MovieInterface):MovieDetailsRepository{
        return MovieDetailsRepository(movieInterface)
    }


}

