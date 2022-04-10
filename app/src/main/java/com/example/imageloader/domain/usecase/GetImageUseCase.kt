package com.example.imageloader.domain.usecase

import com.example.imageloader.domain.models.GetImage
import com.example.imageloader.domain.models.UploadedImage
import com.example.imageloader.domain.repository.ImageLoader

class GetImageUseCase(private val imageLoader: ImageLoader) {

    suspend fun execute(getImage: GetImage): UploadedImage {
        return imageLoader.imageUpload(getImage)
    }

}