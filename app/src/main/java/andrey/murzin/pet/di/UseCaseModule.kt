package andrey.murzin.pet.di

import andrey.murzin.pet.domain.usecase.movie.GetMovieUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetMovieUseCase(get()) }
}