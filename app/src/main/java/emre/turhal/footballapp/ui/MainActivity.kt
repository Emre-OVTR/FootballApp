package emre.turhal.footballapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import emre.turhal.footballapp.ViewModel
import emre.turhal.footballapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: ViewModel
    private lateinit var adapter: CompetitionsListAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        configureRecyclerView()
        requestCompetitionList()

    }

    private fun requestCompetitionList(){
        viewModel = ViewModel()
        viewModel.getCompetitions()
        viewModel.competitionsLiveData.observe(this){
            if (it.size == 13){
                adapter.submitList(it)

                Log.e("jjjj","n'est pas vide ")
            } else {
                Toast.makeText(applicationContext, "Problème lors de la connexion au serveur", Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun configureRecyclerView(){
        val recyclerView = binding.standing
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val dividerItemDecoration = DividerItemDecoration(recyclerView.context, layoutManager.orientation)
        recyclerView.addItemDecoration(dividerItemDecoration)
        adapter = CompetitionsListAdapter()
        recyclerView.adapter = adapter
    }
}