package andrey.murzin.pet.presentation.auth.view


import andrey.murzin.pet.R
import andrey.murzin.pet.presentation.auth.AuthViewModel
import andrey.murzin.pet.presentation.base.FlowFragment
import andrey.murzin.pet.presentation.base.navigation.BaseNavigator
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.fragment_flow_auth.*
import org.koin.android.ext.android.getKoin
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.named
import ru.terrakok.cicerone.NavigatorHolder

class AuthFlowFragment : FlowFragment() {

    companion object {
        const val SCOPE_NAME = "authScope"
    }

    override val navigatorHolder: NavigatorHolder = getScope().get()

    override val layoutResource: Int = R.layout.fragment_flow_auth

    override val navigator: BaseNavigator by getScope().inject {
        parametersOf(this.activity, childFragmentManager, 0)
    }

    override fun getScope()= getKoin().getOrCreateScope(SCOPE_NAME, named(SCOPE_NAME))

    private val authViewModel: AuthViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvTest.setOnClickListener {
            authViewModel.navigateMainFlow()
        }
    }
}