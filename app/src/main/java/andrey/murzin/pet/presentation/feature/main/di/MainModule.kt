package andrey.murzin.pet.presentation.feature.main.di

import andrey.murzin.pet.model.router.FlowRouter
import andrey.murzin.pet.presentation.base.navigation.BaseNavigator
import andrey.murzin.pet.presentation.feature.main.MainViewModel
import andrey.murzin.pet.presentation.feature.main.view.MainFlowFragment
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder

val mainModule = module {

    scope(named(MainFlowFragment.SCOPE_NAME)) {
        scoped { (activity: AppCompatActivity, fragmentManager: FragmentManager, containerId: Int) ->
            BaseNavigator(
                activity,
                fragmentManager,
                containerId
            )
        }
        scoped<Cicerone<FlowRouter>> {
            Cicerone.create(
                FlowRouter(
                    get()
                )
            )
        }
        scoped<FlowRouter> { get<Cicerone<FlowRouter>>().router }
        scoped<NavigatorHolder> { get<Cicerone<FlowRouter>>().navigatorHolder }

    }

    viewModel { MainViewModel(getScope(MainFlowFragment.SCOPE_NAME).get()) }
}