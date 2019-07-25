package andrey.murzin.pet.data.network

import io.reactivex.Completable
import retrofit2.http.GET

interface IMovieDbApi {

    @GET("movie/550")
    fun kekk() : Completable
}