package andrey.murzin.pet.di

import andrey.murzin.pet.presentation.feature.app.di.appActivityModule
import andrey.murzin.pet.presentation.feature.auth.di.authModule
import andrey.murzin.pet.presentation.feature.main.di.mainModule
import andrey.murzin.pet.presentation.feature.movie.di.movieModule

val viewModule = mutableListOf(
    authModule,
    mainModule,
    movieModule,
    appActivityModule
)