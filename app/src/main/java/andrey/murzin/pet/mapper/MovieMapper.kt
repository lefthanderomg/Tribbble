package andrey.murzin.pet.mapper

import andrey.murzin.pet.data.network.model.MovieModel
import andrey.murzin.pet.domain.entity.MovieEntity
import andrey.murzin.pet.presentation.model.MovieViewEntity

fun MovieModel.toEntity() =
    MovieEntity(
        id ?: -1,
        voteCount ?: -1,
        video ?: false,
        voteAverage ?: -1.0,
        title.orEmpty(),
        popularity ?: -1.0,
        posterPath.orEmpty(),
        originalLanguage.orEmpty(),
        originalTitle.orEmpty(),
        backdropPath.orEmpty(),
        adult ?: false,
        overview.orEmpty(),
        releaseDate.orEmpty()
    )

fun MovieEntity.toViewModel() =
    MovieViewEntity(
        id,
        voteCount,
        video,
        voteAverage,
        title,
        popularity,
        posterPath,
        originalLanguage,
        originalTitle,
        backdropPath,
        adult,
        overview,
        releaseDate
    )