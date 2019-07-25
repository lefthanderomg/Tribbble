package andrey.murzin.pet.presentation.app.di

import andrey.murzin.pet.presentation.app.AppActivity
import andrey.murzin.pet.presentation.app.AppLauncher
import andrey.murzin.pet.presentation.base.navigation.BaseNavigator
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