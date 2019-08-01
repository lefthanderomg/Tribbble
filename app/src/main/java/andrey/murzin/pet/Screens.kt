package andrey.murzin.pet

import andrey.murzin.pet.presentation.feature.auth.view.AuthFlowFragment
import andrey.murzin.pet.presentation.feature.main.view.MainFlowFragment
import andrey.murzin.pet.presentation.feature.movie.view.MovieFragment
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