package andrey.murzin.pet.di

import andrey.murzin.pet.utils.schedulers.AppSchedulersProvider
import andrey.murzin.pet.utils.schedulers.ISchedulersProvider
import androidx.recyclerview.widget.LinearLayoutManager
import io.reactivex.disposables.CompositeDisposable
import org.koin.dsl.module
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router


val commonModule = module {
    single<Cicerone<Router>> { Cicerone.create() }
    single<Router> { get<Cicerone<Router>>().router }
    single<NavigatorHolder> { get<Cicerone<Router>>().navigatorHolder }
    single<ISchedulersProvider> { AppSchedulersProvider() }
    factory {  LinearLayoutManager(get()) }
    factory {  CompositeDisposable() }
}

val appModule = mutableListOf(
    commonModule,
    networkModule,
    repository,
    useCaseModule
).apply { addAll(viewModule) }

