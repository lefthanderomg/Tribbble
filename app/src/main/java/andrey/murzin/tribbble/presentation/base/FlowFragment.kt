package andrey.murzin.tribbble.presentation.base

import andrey.murzin.tribbble.presentation.base.navigation.BaseNavigator
import androidx.annotation.RestrictTo
import org.koin.core.scope.Scope
import ru.terrakok.cicerone.NavigatorHolder

abstract class FlowFragment : BaseFragment() {

    abstract override val layoutResource: Int

    abstract val navigatorHolder: NavigatorHolder

    abstract val navigator: BaseNavigator

    abstract fun getScope(): Scope

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

}