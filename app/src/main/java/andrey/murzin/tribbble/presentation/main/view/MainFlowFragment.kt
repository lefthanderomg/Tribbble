package andrey.murzin.tribbble.presentation.main.view

import andrey.murzin.tribbble.R
import andrey.murzin.tribbble.presentation.base.BaseFragment
import andrey.murzin.tribbble.presentation.base.navigation.BaseNavigator
import android.os.Bundle
import android.view.View
import org.koin.android.ext.android.inject
import org.koin.android.scope.currentScope
import org.koin.core.parameter.parametersOf
import ru.terrakok.cicerone.NavigatorHolder

class MainFlowFragment : BaseFragment() {

    override val layoutResource: Int = R.layout.fragment_main_flow

    private val navigatorHolder: NavigatorHolder by inject()

    private val navigator: BaseNavigator by currentScope.inject {
        parametersOf(this.activity, childFragmentManager, R.id.container)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

}