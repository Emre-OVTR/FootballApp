package emre.turhal.footballapp.retrofit

import emre.turhal.footballapp.model.CompetitionDetails
import emre.turhal.footballapp.model.Competitions
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/v4/competitions/")
    suspend fun getCompetitions() : Response<Competitions>

    @GET("/v4/competitions/{id}/standings/")
    suspend fun getCompetitionDetails(@Path("id") competitionId: String) : Response<CompetitionDetails>
}