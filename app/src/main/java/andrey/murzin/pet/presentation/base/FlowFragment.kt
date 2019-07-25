package andrey.murzin.pet.presentation.base

import andrey.murzin.pet.R
import andrey.murzin.pet.presentation.base.navigation.BaseNavigator
import org.koin.android.ext.android.inject
import org.koin.core.scope.Scope
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

abstract class FlowFragment : BaseFragment() {

    abstract override val layoutResource: Int

    abstract val navigatorHolder: NavigatorHolder

    abstract val navigator: BaseNavigator

    abstract fun getScope(): Scope

    private val router: Router by inject()

    private val currentFragment
        get() = childFragmentManager.findFragmentById(R.id.container) as? BaseFragment

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onBackPressed() {
        currentFragment?.onBackPressed() ?: router.exit()
    }

}