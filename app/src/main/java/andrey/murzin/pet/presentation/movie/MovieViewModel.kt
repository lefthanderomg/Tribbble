package andrey.murzin.pet.presentation.movie

import andrey.murzin.pet.model.router.FlowRouter
import androidx.lifecycle.ViewModel

class MovieViewModel(
    private val flowRouter: FlowRouter
) : ViewModel() {

    fun onBackPressed() {
        flowRouter.exit()
    }


}