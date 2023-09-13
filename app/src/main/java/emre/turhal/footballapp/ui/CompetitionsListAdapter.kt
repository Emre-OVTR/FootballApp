package emre.turhal.footballapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import emre.turhal.footballapp.R
import emre.turhal.footballapp.model.CompetitionsItem

class CompetitionsListAdapter(private val clickListener : (competition : CompetitionsItem) -> Unit) : androidx.recyclerview.widget.ListAdapter<CompetitionsItem, CompetitionsListAdapter.CompetitionsViewHolder>(CompetitionsDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompetitionsViewHolder {
        return CompetitionsViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: CompetitionsViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, clickListener)
    }

    class CompetitionsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val competitionEmblem: ImageView = itemView.findViewById(R.id.emblem)
        fun bind(item: CompetitionsItem, clickListener: (competition: CompetitionsItem) -> Unit)= with(itemView) {
            Glide.with(context).load(item.emblem).into(competitionEmblem)
            itemView.setOnClickListener{
                clickListener(item)
            }
        }


        companion object {
            fun create(parent: ViewGroup): CompetitionsViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.competition_list_items, parent, false)
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