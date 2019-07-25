package andrey.murzin.tribbble.presentation.auth.di

import andrey.murzin.tribbble.FlowRouter
import andrey.murzin.tribbble.presentation.auth.AuthViewModel
import andrey.murzin.tribbble.presentation.auth.view.AuthFlowFragment
import andrey.murzin.tribbble.presentation.base.navigation.BaseNavigator
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder


val authModule = module {

    scope(named(AuthFlowFragment.SCOPED_NAME)) {
        scoped { (activity: AppCompatActivity, fragmentManager: FragmentManager, containerId: Int) ->
            BaseNavigator(
                activity,
                fragmentManager,
                containerId
            )
        }
        scoped<Cicerone<FlowRouter>> { Cicerone.create(FlowRouter(get())) }
        scoped<FlowRouter> { get<Cicerone<FlowRouter>>().router }
        scoped<NavigatorHolder> { get<Cicerone<FlowRouter>>().navigatorHolder }
    }

    viewModel {
        AuthViewModel(getScope(AuthFlowFragment.SCOPED_NAME).get())
    }

}