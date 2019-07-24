package andrey.murzin.tribbble.presentation.app

import andrey.murzin.tribbble.Screens
import ru.terrakok.cicerone.Router

class AppLauncher constructor(
    private val router: Router
) {

    fun coldStart() {
        router.newRootScreen(Screens.MainFlow)
    }
}