package andrey.murzin.pet.presentation.main

import andrey.murzin.pet.Screens
import andrey.murzin.pet.model.router.FlowRouter
import androidx.lifecycle.ViewModel

class MainViewModel(
    private val router: FlowRouter
) : ViewModel() {

    fun launchMovie() {
        router.newRootScreen(Screens.MovieScreen)
    }

}