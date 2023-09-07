package emre.turhal.footballapp.model

import com.google.gson.annotations.SerializedName

data class Response(

	@field:SerializedName("count")
	val count: Int? = null,

	@field:SerializedName("competitions")
	val competitions: List<CompetitionsItem?>? = null,

	@field:SerializedName("filters")
	val filters: Filters? = null
)

data class Filters(

	@field:SerializedName("client")
	val client: String? = null
)

data class Area(

	@field:SerializedName("code")
	val code: String? = null,

	@field:SerializedName("flag")
	val flag: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)

data class CurrentSeason(

	@field:SerializedName("winner")
	val winner: Any? = null,

	@field:SerializedName("currentMatchday")
	val currentMatchday: Int? = null,

	@field:SerializedName("endDate")
	val endDate: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("startDate")
	val startDate: String? = null
)

data class CompetitionsItem(

	@field:SerializedName("area")
	val area: Area? = null,

	@field:SerializedName("lastUpdated")
	val lastUpdated: String? = null,

	@field:SerializedName("code")
	val code: String? = null,

	@field:SerializedName("currentSeason")
	val currentSeason: CurrentSeason? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("numberOfAvailableSeasons")
	val numberOfAvailableSeasons: Int? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("emblem")
	val emblem: String? = null,

	@field:SerializedName("plan")
	val plan: String? = null
)

data class Winner(

	@field:SerializedName("venue")
	val venue: String? = null,

	@field:SerializedName("lastUpdated")
	val lastUpdated: String? = null,

	@field:SerializedName("website")
	val website: String? = null,

	@field:SerializedName("address")
	val address: String? = null,

	@field:SerializedName("clubColors")
	val clubColors: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("tla")
	val tla: String? = null,

	@field:SerializedName("founded")
	val founded: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("shortName")
	val shortName: String? = null,

	@field:SerializedName("crest")
	val crest: String? = null
)
