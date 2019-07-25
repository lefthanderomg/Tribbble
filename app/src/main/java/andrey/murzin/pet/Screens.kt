package andrey.murzin.pet

import andrey.murzin.pet.presentation.auth.view.AuthFlowFragment
import andrey.murzin.pet.presentation.main.view.MainFlowFragment
import andrey.murzin.pet.presentation.movie.view.MovieFragment
import androidx.fragment.app.Fragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {

    object MovieScreen : SupportAppScreen() {
        override fun getFragment(): Fragment = MovieFragment()
    }

    object AuthFlow : SupportAppScreen() {
        override fun getFragment(): Fragment =
            AuthFlowFragment()
    }

    object MainFlow : SupportAppScreen() {
        override fun getFragment(): Fragment = MainFlowFragment()
    }

}