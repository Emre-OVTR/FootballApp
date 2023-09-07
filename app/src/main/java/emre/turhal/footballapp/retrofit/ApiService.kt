package emre.turhal.footballapp.retrofit

import retrofit2.http.GET

interface ApiService {

    @GET("/v4/competitions/")
    suspend fun getCompetitions() : retrofit2.Response<emre.turhal.footballapp.model.Response>
}