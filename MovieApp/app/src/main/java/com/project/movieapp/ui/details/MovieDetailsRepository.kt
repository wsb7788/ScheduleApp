package com.project.movieapp.ui.details

import com.project.movieapp.data.moviedetails.MovieDetails
import com.project.movieapp.remote.MovieInterface
import com.project.movieapp.utils.Constans
import com.project.movieapp.utils.Status
import com.project.movieapp.utils.Result

class MovieDetailsRepository(private val movieInterface: MovieInterface) {



    suspend fun getMovieDetails(imdbId:String):Result<MovieDetails>{

        return try{

            val response = movieInterface.getMovieDetails(imdbId,Constans.API_KEY)

            if(response.isSuccessful){
                Result(Status.SUCCESS,response.body(),null)
            }else{
                Result(Status.ERROR, null, null)
            }
        }catch (e:Exception){
            Result(Status.ERROR, null, null)
        }






    }
}