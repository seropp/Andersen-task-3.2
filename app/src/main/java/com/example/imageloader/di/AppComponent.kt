package com.example.imageloader.di

import com.example.imageloader.presentation.MainActivity
import dagger.Component

@Component(modules = [PresentationModule::class, DomainModule::class, DataModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}
