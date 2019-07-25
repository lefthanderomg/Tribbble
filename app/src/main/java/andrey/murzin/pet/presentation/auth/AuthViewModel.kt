package andrey.murzin.pet.presentation.auth

import andrey.murzin.pet.model.router.FlowRouter
import andrey.murzin.pet.Screens
import androidx.lifecycle.ViewModel

class AuthViewModel(
    private val flowRouter: FlowRouter
) : ViewModel() {

    fun navigateMainFlow() {
        flowRouter.startFlow(Screens.MainFlow)
    }


}