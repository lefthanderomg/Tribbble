package andrey.murzin.pet.presentation.model

import andrey.murzin.pet.BuildConfig

data class MovieViewEntity(
    val id: Long,
    val voteCount: Int,
    val video: Boolean,
    val voteAverage: Double,
    val title: String,
    val popularity: Double,
    val posterPath: String,
    val originalLanguage: String,
    val originalTitle: String,
    val backdropPath: String,
    val adult: Boolean,
    val overview: String,
    val releaseDate: String
) {

    fun getPosterImageW200() = BuildConfig.BASE_IMG_URL + "w200" + posterPath
}