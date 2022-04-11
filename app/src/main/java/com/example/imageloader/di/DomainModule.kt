package com.example.imageloader.di

import com.example.imageloader.domain.repository.ImageLoader
import com.example.imageloader.domain.usecase.GetImageUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideGetImageUseCase(imageLoader: ImageLoader): GetImageUseCase {
        return GetImageUseCase(imageLoader = imageLoader)
    }
}