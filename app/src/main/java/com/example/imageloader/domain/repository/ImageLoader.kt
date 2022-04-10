package com.example.imageloader.domain.repository

import com.example.imageloader.domain.models.GetImage
import com.example.imageloader.domain.models.UploadedImage

interface ImageLoader {

    suspend fun imageUpload(getImage: GetImage): UploadedImage

}