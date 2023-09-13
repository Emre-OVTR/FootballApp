package emre.turhal.footballapp.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import emre.turhal.footballapp.ViewModel
import emre.turhal.footballapp.databinding.ActivityMainBinding
import emre.turhal.footballapp.model.CompetitionsItem
import emre.turhal.footballapp.ui.standings.DetailsActivity

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
        val itemsList : MutableList<CompetitionsItem> = ArrayList()
        viewModel = ViewModel()
        viewModel.getCompetitions()
        viewModel.competitionsLiveData.observe(this){
            if (it.size == 13){
                for (i in it){
                    if (i != null) {
                        if (i.emblem?.endsWith(".png") == true){
                            itemsList.add(i)
                        }
                    }
                }
                adapter.submitList(itemsList)

                Log.e("jjjj","n'est pas vide ")
            } else {
                Toast.makeText(applicationContext, "Problème lors de la connexion au serveur", Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun configureRecyclerView(){
        val recyclerView = binding.competitions
        val layoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = layoutManager
        val dividerItemDecoration = DividerItemDecoration(recyclerView.context, layoutManager.orientation)
        recyclerView.addItemDecoration(dividerItemDecoration)
        adapter = CompetitionsListAdapter(this::onCompetitionClicked)
        recyclerView.adapter = adapter
    }

    private fun onCompetitionClicked(item: CompetitionsItem){

        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra(DetailsActivity.COMPETITION, item)
        startActivity(intent)
    }
}