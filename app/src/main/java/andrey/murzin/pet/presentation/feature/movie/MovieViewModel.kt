package andrey.murzin.pet.presentation.feature.movie

import andrey.murzin.pet.domain.entity.type.MovieType
import andrey.murzin.pet.domain.usecase.movie.GetMovieUseCase
import andrey.murzin.pet.mapper.toViewModel
import andrey.murzin.pet.model.router.FlowRouter
import andrey.murzin.pet.presentation.base.BaseViewModel
import andrey.murzin.pet.presentation.model.MovieViewEntity
import androidx.lifecycle.MutableLiveData
import timber.log.Timber

class MovieViewModel(
    private val flowRouter: FlowRouter,
    private val getMovieUseCase: GetMovieUseCase
) : BaseViewModel() {

    val getObservableMovie: MutableLiveData<List<MovieViewEntity>> = MutableLiveData()

    fun getMovie() {
        getMovieUseCase.execute(
            GetMovieUseCase.Param(MovieType.TOP_RATED)
        ).flattenAsObservable {
            it
        }.map {
            it.toViewModel()
        }.toList().subscribeOn(
            schedulers.io()
        ).observeOn(
            schedulers.ui()
        ).subscribe({
            getObservableMovie.postValue(it)
        }, {
            Timber.d(it)
        }).connect()
    }

    fun onBackPressed() {
        flowRouter.exit()
    }
}