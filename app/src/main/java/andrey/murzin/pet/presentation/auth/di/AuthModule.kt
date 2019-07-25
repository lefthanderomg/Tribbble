package andrey.murzin.pet.presentation.auth.di

import andrey.murzin.pet.model.router.FlowRouter
import andrey.murzin.pet.presentation.auth.AuthViewModel
import andrey.murzin.pet.presentation.auth.view.AuthFlowFragment
import andrey.murzin.pet.presentation.base.navigation.BaseNavigator
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder


val authModule = module {

    scope(named(AuthFlowFragment.SCOPE_NAME)) {
        scoped { (activity: AppCompatActivity, fragmentManager: FragmentManager, containerId: Int) ->
            BaseNavigator(
                activity,
                fragmentManager,
                containerId
            )
        }
        scoped<Cicerone<FlowRouter>> { Cicerone.create(
            FlowRouter(
                get()
            )
        ) }
        scoped<FlowRouter> { get<Cicerone<FlowRouter>>().router }
        scoped<NavigatorHolder> { get<Cicerone<FlowRouter>>().navigatorHolder }
    }

    viewModel {
        AuthViewModel(getScope(AuthFlowFragment.SCOPE_NAME).get())
    }

}