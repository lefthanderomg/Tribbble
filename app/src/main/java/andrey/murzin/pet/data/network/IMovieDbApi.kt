package andrey.murzin.pet.data.network

import andrey.murzin.pet.data.network.model.MovieModel
import andrey.murzin.pet.data.network.model.PageModel
import io.reactivex.Single
import retrofit2.http.GET

interface IMovieDbApi {

    @GET("movie/top_rated")
    fun getTopRatedMovie(): Single<PageModel<MovieModel>>
}