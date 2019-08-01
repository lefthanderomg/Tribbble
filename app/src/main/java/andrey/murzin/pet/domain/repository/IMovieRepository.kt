package andrey.murzin.pet.domain.repository

import andrey.murzin.pet.domain.entity.MovieEntity
import andrey.murzin.pet.domain.entity.type.MovieType
import io.reactivex.Single

interface IMovieRepository {
    fun getMovie(movieType: MovieType): Single<List<MovieEntity>>
}