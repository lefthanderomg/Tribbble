package andrey.murzin.pet.di

import andrey.murzin.pet.data.repository.MovieRepository
import andrey.murzin.pet.domain.repository.IMovieRepository
import org.koin.dsl.module

val repository = module {
    single<IMovieRepository> {
        MovieRepository(
            get()
        )
    }
}