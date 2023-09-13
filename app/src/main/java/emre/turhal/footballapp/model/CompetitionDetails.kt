package emre.turhal.footballapp.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CompetitionDetails(

	@field:SerializedName("area")
	val area: Area? = null,

	@field:SerializedName("season")
	val season: Season? = null,

	@field:SerializedName("competition")
	val competition: CompetitionDetails? = null,

	@field:SerializedName("filters")
	val filters: Filters? = null,

	@field:SerializedName("standings")
	val standings: List<StandingsItem?>? = null,

	@field:SerializedName("code")
	val code: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("emblem")
	val emblem: String? = null
): Serializable

data class Area(

	@field:SerializedName("code")
	val code: String? = null,

	@field:SerializedName("flag")
	val flag: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
): Serializable

data class Filters(

	@field:SerializedName("season")
	val season: String? = null
): Serializable

data class TableItem(

	@field:SerializedName("goalsFor")
	val goalsFor: Int? = null,

	@field:SerializedName("form")
	val form: String? = null,

	@field:SerializedName("lost")
	val lost: Int? = null,

	@field:SerializedName("won")
	val won: Int? = null,

	@field:SerializedName("playedGames")
	val playedGames: Int? = null,

	@field:SerializedName("position")
	val position: Int? = null,

	@field:SerializedName("team")
	val team: Team? = null,

	@field:SerializedName("draw")
	val draw: Int? = null,

	@field:SerializedName("goalsAgainst")
	val goalsAgainst: Int? = null,

	@field:SerializedName("goalDifference")
	val goalDifference: Int? = null,

	@field:SerializedName("points")
	val points: Int? = null
): Serializable

data class Team(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("tla")
	val tla: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("shortName")
	val shortName: String? = null,

	@field:SerializedName("crest")
	val crest: String? = null
): Serializable

data class StandingsItem(

	@field:SerializedName("stage")
	val stage: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("table")
	val table: List<TableItem?>? = null,

	@field:SerializedName("group")
	val group: Any? = null
): Serializable

data class Season(

	@field:SerializedName("winner")
	val winner: Any? = null,

	@field:SerializedName("currentMatchday")
	val currentMatchday: Int? = null,

	@field:SerializedName("endDate")
	val endDate: String? = null,

	@field:SerializedName("stages")
	val stages: List<String?>? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("startDate")
	val startDate: String? = null
): Serializable
