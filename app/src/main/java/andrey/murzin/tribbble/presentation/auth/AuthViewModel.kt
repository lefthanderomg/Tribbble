package andrey.murzin.tribbble.presentation.auth

import andrey.murzin.tribbble.FlowRouter
import andrey.murzin.tribbble.Screens
import androidx.lifecycle.ViewModel

class AuthViewModel(
    private val flowRouter: FlowRouter
) : ViewModel() {

    fun navigateMainFlow() {
        flowRouter.startFlow(Screens.MainFlow)
    }


}