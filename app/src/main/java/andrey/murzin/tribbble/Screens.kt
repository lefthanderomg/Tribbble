package andrey.murzin.tribbble

import andrey.murzin.tribbble.presentation.auth.view.AuthFlowFragment
import andrey.murzin.tribbble.presentation.main.view.MainFlowFragment
import androidx.fragment.app.Fragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {

    object AuthFlow : SupportAppScreen() {
        override fun getFragment(): Fragment =
            AuthFlowFragment()
    }

    object MainFlow : SupportAppScreen() {
        override fun getFragment(): Fragment = MainFlowFragment()
    }
}