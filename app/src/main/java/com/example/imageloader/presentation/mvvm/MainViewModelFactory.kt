package com.example.imageloader.presentation.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.imageloader.domain.usecase.GetImageUseCase

class MainViewModelFactory(val getImageUseCase: GetImageUseCase) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            getImageUseCase = getImageUseCase
        ) as T
    }
}