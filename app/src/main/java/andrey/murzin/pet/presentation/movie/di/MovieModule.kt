package andrey.murzin.pet.presentation.movie.di

import andrey.murzin.pet.presentation.main.view.MainFlowFragment
import andrey.murzin.pet.presentation.movie.MovieViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val movieModule = module {

    viewModel {
       MovieViewModel(
           getScope(MainFlowFragment.SCOPE_NAME).get()
       )
    }
}