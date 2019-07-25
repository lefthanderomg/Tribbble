package andrey.murzin.pet.di

import andrey.murzin.pet.presentation.app.di.appActivityModule
import andrey.murzin.pet.presentation.auth.di.authModule
import andrey.murzin.pet.presentation.main.di.mainModule
import andrey.murzin.pet.presentation.movie.di.movieModule

val viewModule = mutableListOf(
    authModule,
    mainModule,
    movieModule,
    appActivityModule
)