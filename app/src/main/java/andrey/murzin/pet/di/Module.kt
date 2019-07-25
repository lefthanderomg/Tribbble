package andrey.murzin.pet.di

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
    networkModule,
    repository
).apply { addAll(viewModule) }

