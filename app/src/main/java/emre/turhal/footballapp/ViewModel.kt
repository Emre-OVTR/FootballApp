package emre.turhal.footballapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import emre.turhal.footballapp.model.CompetitionsItem
import emre.turhal.footballapp.model.StandingsItem
import emre.turhal.footballapp.retrofit.ApiService
import emre.turhal.footballapp.retrofit.Retrofit
import kotlinx.coroutines.launch

class ViewModel : ViewModel() {

    private val service = Retrofit.getRetrofitInstance().create(ApiService::class.java)

    val competitionsLiveData: MutableLiveData<List<CompetitionsItem?>> = MutableLiveData()
    val competitionsDetailsLiveData: MutableLiveData<List<StandingsItem?>> = MutableLiveData()

    fun getCompetitions(){
        viewModelScope.launch {
            val response = service.getCompetitions()
            if (response.isSuccessful) {
                val apiResponse = response.body()
                val results = apiResponse?.competitions
                competitionsLiveData.postValue(results)
            }
        }
    }

    fun getCompetitionDetails(id:String){
        viewModelScope.launch {
            val response = service.getCompetitionDetails(id)
            if (response.isSuccessful){
                val apiResponse = response.body()
                val results = apiResponse?.standings
                competitionsDetailsLiveData.postValue(results)
            }
        }
    }
}