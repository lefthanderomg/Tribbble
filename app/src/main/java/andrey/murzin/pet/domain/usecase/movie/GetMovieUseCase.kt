package andrey.murzin.pet.domain.usecase.movie

import andrey.murzin.pet.domain.entity.MovieEntity
import andrey.murzin.pet.domain.entity.type.MovieType
import andrey.murzin.pet.domain.repository.IMovieRepository
import andrey.murzin.pet.domain.usecase.base.SingleUseCase
import io.reactivex.Single

class GetMovieUseCase(
    private val movieRepository: IMovieRepository
) : SingleUseCase<GetMovieUseCase.Param, List<MovieEntity>>() {

    override fun build(parameters: Param): Single<List<MovieEntity>> =
        movieRepository.getMovie(parameters.type)

    class Param(
        val type: MovieType
    )
}