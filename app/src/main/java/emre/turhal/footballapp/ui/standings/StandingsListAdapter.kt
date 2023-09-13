package emre.turhal.footballapp.ui.standings

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.request.ImageRequest
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
        val teamPosition: TextView = itemview.findViewById(R.id.team_position)
        val teamEmblem: ImageView = itemview.findViewById(R.id.team_emblem)
        val teamPoints: TextView = itemview.findViewById(R.id.team_point)

        fun ImageView.loadUrl(url: String) {

            val imageLoader = ImageLoader.Builder(this.context)
                .componentRegistry { add(SvgDecoder(this@loadUrl.context)) }
                .build()

            val request = ImageRequest.Builder(this.context)
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .data(url)
                .target(this)
                .build()

            imageLoader.enqueue(request)
        }
        fun bind(item: TableItem) = with(itemView) {
            teamPosition.text = item.position.toString()
            teamName.text = item.team?.name
          //  Glide.with(itemView).load(item.team?.crest).into(teamEmblem)
            teamEmblem.loadUrl(item.team?.crest!!)
            teamPoints.text = item.points.toString()
            Log.d("TAG", item.points.toString())
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