package emre.turhal.footballapp.ui.standings

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import emre.turhal.footballapp.ViewModel
import emre.turhal.footballapp.databinding.ActivityDetailsBinding
import emre.turhal.footballapp.model.CompetitionsItem

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding
    private lateinit var standingsAdapter : StandingsListAdapter
    private lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        configureRecyclerView()
        showCompetitionStandings()
    }


    private fun configureRecyclerView(){
        val recyclerView = binding.standings
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        standingsAdapter = StandingsListAdapter()
        recyclerView.adapter = standingsAdapter

    }


    private fun showCompetitionStandings(){
        val competition = intent.getSerializableExtra(COMPETITION) as CompetitionsItem
        viewModel = ViewModel()
        viewModel.getCompetitionDetails(competition.code!!)
        viewModel.competitionsDetailsLiveData.observe(this){
            standingsAdapter.submitList(it[0]?.table)
        }

    }
    companion object{
        const val COMPETITION = "COMPETITION"
    }

}