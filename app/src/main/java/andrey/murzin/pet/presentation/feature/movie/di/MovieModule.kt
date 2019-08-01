package andrey.murzin.pet.presentation.feature.movie.di

import andrey.murzin.pet.presentation.feature.main.view.MainFlowFragment
import andrey.murzin.pet.presentation.feature.movie.MovieViewModel
import andrey.murzin.pet.presentation.feature.movie.adapter.MovieAdapter
import andrey.murzin.pet.presentation.feature.movie.view.MovieFragment
import andrey.murzin.pet.utils.glide.GlideRequests
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val movieModule = module {

    scope(named<MovieFragment>()) {

        scoped { (glide: GlideRequests) ->
            MovieAdapter(glide)
        }
    }

    viewModel {
        MovieViewModel(
            getScope(MainFlowFragment.SCOPE_NAME).get(),
            get()
        )
    }
}