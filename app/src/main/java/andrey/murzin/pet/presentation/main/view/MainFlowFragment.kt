package andrey.murzin.pet.presentation.main.view

import andrey.murzin.pet.R
import andrey.murzin.pet.model.router.FlowRouter
import andrey.murzin.pet.presentation.base.FlowFragment
import andrey.murzin.pet.presentation.base.navigation.BaseNavigator
import andrey.murzin.pet.presentation.main.MainViewModel
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.fragment_main_flow.*
import org.koin.android.ext.android.getKoin
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.named
import org.koin.core.scope.Scope
import ru.terrakok.cicerone.NavigatorHolder
import timber.log.Timber

class MainFlowFragment : FlowFragment() {

    companion object {
        const val SCOPE_NAME = "mainScope"
    }

    override val navigatorHolder: NavigatorHolder = getScope().get()

    override val layoutResource: Int = R.layout.fragment_main_flow

    override val navigator: BaseNavigator by getScope().inject {
        parametersOf(this.activity, childFragmentManager, R.id.container)
    }

    private val viewModel: MainViewModel by viewModel()

    override fun getScope(): Scope = getKoin().getOrCreateScope(SCOPE_NAME, named(SCOPE_NAME))

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


}