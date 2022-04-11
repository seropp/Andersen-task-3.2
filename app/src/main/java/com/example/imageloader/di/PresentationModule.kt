package com.example.imageloader.di

import com.example.imageloader.domain.usecase.GetImageUseCase
import com.example.imageloader.presentation.mvvm.MainViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class PresentationModule {

    @Provides
    fun provideViewModelFactory(
        getImageUseCase: GetImageUseCase
    ): MainViewModelFactory {
        return MainViewModelFactory(
            getImageUseCase = getImageUseCase
        )
    }
}