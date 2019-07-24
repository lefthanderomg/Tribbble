package andrey.murzin.tribbble.presentation.app.di

import andrey.murzin.tribbble.presentation.app.AppActivity
import andrey.murzin.tribbble.presentation.app.AppLauncher
import andrey.murzin.tribbble.presentation.base.navigation.BaseNavigator
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appActivityModule = module {
    scope(named<AppActivity>()) {
        scoped { (activity: AppCompatActivity, fragmentManager: FragmentManager, containerId: Int) ->
            BaseNavigator(
                activity,
                fragmentManager,
                containerId
            )
        }
        scoped {
            AppLauncher(get())
        }
    }

}