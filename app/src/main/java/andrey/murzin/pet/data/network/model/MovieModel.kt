package andrey.murzin.pet.data.network.model

import com.google.gson.annotations.SerializedName

data class MovieModel(
    @SerializedName("id")
    val id: Long?,
    @SerializedName("vote_count")
    val voteCount: Int?,
    @SerializedName("video")
    val video: Boolean?,
    @SerializedName("vote_average")
    val voteAverage: Double?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("popularity")
    val popularity: Double?,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("original_language")
    val originalLanguage: String?,
    @SerializedName("original_title")
    val originalTitle: String?,
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    @SerializedName("adult")
    val adult: Boolean?,
    @SerializedName("overview")
    val overview: String?,
    @SerializedName("release_date")
    val releaseDate: String?
)