package andrey.murzin.pet.presentation.main

import andrey.murzin.pet.Screens
import andrey.murzin.pet.model.router.FlowRouter
import androidx.lifecycle.ViewModel
import timber.log.Timber

class MainViewModel(
    private val router: FlowRouter
) : ViewModel() {

    fun launchMovie() {
        router.navigateTo(Screens.MovieScreen)
    }

}