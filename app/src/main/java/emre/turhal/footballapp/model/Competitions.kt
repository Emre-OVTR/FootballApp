package emre.turhal.footballapp.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Competitions(

	@field:SerializedName("count")
	val count: Int? = null,

	@field:SerializedName("competitions")
	val competitions: List<CompetitionsItem?>? = null,

	@field:SerializedName("filters")
	val filters: Filters? = null
): Serializable





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
): Serializable

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
): Serializable


