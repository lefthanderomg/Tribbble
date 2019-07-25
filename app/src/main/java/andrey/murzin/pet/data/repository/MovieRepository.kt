package andrey.murzin.pet.data.repository

import andrey.murzin.pet.data.network.IMovieDbApi
import andrey.murzin.pet.domain.repository.IMovieRepository

class MovieRepository(
    private val movieApi: IMovieDbApi
) : IMovieRepository