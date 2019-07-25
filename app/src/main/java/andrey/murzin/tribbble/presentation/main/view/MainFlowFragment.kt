package andrey.murzin.tribbble.presentation.main.view

import andrey.murzin.tribbble.R
import andrey.murzin.tribbble.presentation.base.FlowFragment
import andrey.murzin.tribbble.presentation.base.navigation.BaseNavigator
import org.koin.android.ext.android.getKoin
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.named
import org.koin.core.scope.Scope
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

class MainFlowFragment : FlowFragment() {

    companion object {
        const val SCOPE_NAME = "mainScope"
    }

    override val navigatorHolder: NavigatorHolder = getScope().get()

    override val layoutResource: Int = R.layout.fragment_main_flow

    override val navigator: BaseNavigator by getScope().inject {
        parametersOf(this.activity, childFragmentManager, 0)
    }

    override fun getScope(): Scope = getKoin().getOrCreateScope(SCOPE_NAME, named(SCOPE_NAME))

    private val router: Router by inject()

    override fun onDestroy() {
        super.onDestroy()
        getScope().close()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        router.exit()
    }

}