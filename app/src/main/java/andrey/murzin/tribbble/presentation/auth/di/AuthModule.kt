package andrey.murzin.tribbble.presentation.auth.di

import andrey.murzin.tribbble.presentation.auth.AuthViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val authModule = module {
    viewModel {
        AuthViewModel()
    }
}