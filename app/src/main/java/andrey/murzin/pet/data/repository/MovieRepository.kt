package andrey.murzin.pet.data.repository

import andrey.murzin.pet.data.network.IMovieDbApi
import andrey.murzin.pet.domain.entity.MovieEntity
import andrey.murzin.pet.domain.entity.type.MovieType
import andrey.murzin.pet.domain.repository.IMovieRepository
import andrey.murzin.pet.mapper.toEntity
import io.reactivex.Single

class MovieRepository(
    private val movieApi: IMovieDbApi
) : IMovieRepository {

    override fun getMovie(movieType: MovieType): Single<List<MovieEntity>> =
        when (movieType) {
            MovieType.TOP_RATED -> movieApi.getTopRatedMovie()
            MovieType.LATEST -> movieApi.getTopRatedMovie()
            MovieType.NOW_PLAYING -> movieApi.getTopRatedMovie()
            MovieType.POPULAR -> movieApi.getTopRatedMovie()
            MovieType.UPCOMING -> movieApi.getTopRatedMovie()
        }.map {
            it.result
        }.flattenAsObservable { it }
            .map { it.toEntity() }
            .toList()


}