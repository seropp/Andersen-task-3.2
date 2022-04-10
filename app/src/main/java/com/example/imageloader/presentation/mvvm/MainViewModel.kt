package com.example.imageloader.presentation.mvvm

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.imageloader.domain.models.GetImage
import com.example.imageloader.domain.usecase.GetImageUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainViewModel(
    private val getImageUseCase: GetImageUseCase
) : ViewModel() {

    private val liveData = MutableLiveData<Bitmap?>()

    fun getLiveData(): LiveData<Bitmap?> {
        return liveData
    }

    fun loadBitmap(url: String) {
        CoroutineScope(Dispatchers.IO).launch(Dispatchers.Main) {
            try {
                liveData.value = getImageUseCase.execute(getImage = GetImage(imageUrl = url)).image
            } catch (e: Exception){
                liveData.value = null
            }
        }
    }
}