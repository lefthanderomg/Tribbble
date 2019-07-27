package andrey.murzin.pet.presentation.base

import andrey.murzin.pet.R
import andrey.murzin.pet.presentation.base.navigation.BaseNavigator
import andrey.murzin.pet.presentation.main.view.MainFlowFragment
import androidx.annotation.LayoutRes
import org.koin.android.ext.android.inject
import org.koin.core.scope.Scope
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import timber.log.Timber

abstract class FlowFragment : BaseFragment() {

    abstract override val layoutResource: Int

    abstract val navigatorHolder: NavigatorHolder

    abstract val navigator: BaseNavigator

    companion object {
        private const val TAG = "FlowFragment"
    }

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

    override fun onDestroy() {
        super.onDestroy()
        if (needCloseScope()) {
            Timber.d("$TAG onDestroy close scope")
            getScope().close()
        } else {
            Timber.d("$TAG onDestroy not close scope")
        }
    }

    private fun needCloseScope(): Boolean =
        when {
            activity?.isChangingConfigurations == true -> false
            activity?.isFinishing == true -> true
            else -> isRemoving
        }

    override fun onBackPressed() {
        currentFragment?.onBackPressed() ?: router.exit()
    }

}