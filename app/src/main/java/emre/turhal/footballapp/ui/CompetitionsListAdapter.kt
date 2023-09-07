package emre.turhal.footballapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import emre.turhal.footballapp.model.CompetitionsItem
import emre.turhal.footballapp.R

class CompetitionsListAdapter : androidx.recyclerview.widget.ListAdapter<CompetitionsItem, CompetitionsListAdapter.CompetitionsViewHolder>(CompetitionsDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompetitionsViewHolder {
        return CompetitionsViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: CompetitionsViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class CompetitionsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val competName: TextView = itemView.findViewById(R.id.name)
        fun bind(item: CompetitionsItem) {
            competName.text = item.name
        }


        companion object {
            fun create(parent: ViewGroup): CompetitionsViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.team_list_items, parent, false)
                return CompetitionsViewHolder(view)
            }
        }
    }
}

private class CompetitionsDiffCallback : DiffUtil.ItemCallback<CompetitionsItem>() {
    override fun areItemsTheSame(oldItem: CompetitionsItem, newItem: CompetitionsItem): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: CompetitionsItem, newItem: CompetitionsItem): Boolean {
        return oldItem == newItem
    }
}