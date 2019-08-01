package andrey.murzin.pet.presentation.feature.app

import andrey.murzin.pet.Screens
import ru.terrakok.cicerone.Router

class AppLauncher constructor(
    private val router: Router
) {

    fun coldStart() {
        router.newRootScreen(Screens.MainFlow)
    }
}