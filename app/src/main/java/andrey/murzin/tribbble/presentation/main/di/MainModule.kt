package andrey.murzin.tribbble.presentation.main.di

import andrey.murzin.tribbble.presentation.base.navigation.BaseNavigator
import andrey.murzin.tribbble.presentation.main.view.MainFlowFragment
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import org.koin.core.qualifier.named
import org.koin.dsl.module

val mainModule = module {
    scope(named<MainFlowFragment>()) {
        scoped { (activity: AppCompatActivity, fragmentManager: FragmentManager, containerId: Int) ->
            BaseNavigator(
                activity,
                fragmentManager,
                containerId
            )
        }
    }
}