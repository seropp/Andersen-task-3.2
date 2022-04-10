package com.example.imageloader.di

import com.example.imageloader.data.network.ImageUploadWithoutLibrary
import com.example.imageloader.data.network.Loader
import com.example.imageloader.data.repository.ImageLoaderImpl
import com.example.imageloader.domain.repository.ImageLoader
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideImageUpload(): Loader {
        return ImageUploadWithoutLibrary()
    }

    @Provides
    fun provideImageLoader(loader: Loader): ImageLoader {
        return ImageLoaderImpl(loader = loader)
    }

}