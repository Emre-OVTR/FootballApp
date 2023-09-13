package emre.turhal.footballapp.ui.standings

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import emre.turhal.footballapp.R
import emre.turhal.footballapp.model.TableItem

class StandingsListAdapter : androidx.recyclerview.widget.ListAdapter<TableItem, StandingsListAdapter.StandingsViewHolder>(TeamDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StandingsViewHolder {
        return StandingsViewHolder.create(parent)

    }

    override fun onBindViewHolder(holder: StandingsViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }


    class StandingsViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {

        val teamName: TextView = itemview.findViewById(R.id.team_name)

        fun bind(item: TableItem) = with(itemView) {

            teamName.text = item.team?.name
        }



    companion object {
        fun create(parent: ViewGroup): StandingsViewHolder {
            val view: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.standings_item, parent, false)
            return StandingsViewHolder(view)

        }
    }

}
}

class TeamDiffCallback : DiffUtil.ItemCallback<TableItem>() {
    override fun areItemsTheSame(oldItem: TableItem, newItem: TableItem): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: TableItem, newItem: TableItem): Boolean {
        return oldItem == newItem
    }


}