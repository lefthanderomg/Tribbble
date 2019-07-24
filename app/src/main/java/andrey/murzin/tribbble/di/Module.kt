package andrey.murzin.tribbble.di

import andrey.murzin.tribbble.presentation.app.di.appActivityModule
import andrey.murzin.tribbble.presentation.auth.di.authModule
import andrey.murzin.tribbble.presentation.main.di.mainModule
import org.koin.dsl.module
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

val commonModule = module {
    single<Cicerone<Router>> { Cicerone.create() }

    single<Router> { get<Cicerone<Router>>().router }

    single<NavigatorHolder> { get<Cicerone<Router>>().navigatorHolder }

}

val appModule = mutableListOf(
    commonModule,
    appActivityModule,
    authModule,
    mainModule
)