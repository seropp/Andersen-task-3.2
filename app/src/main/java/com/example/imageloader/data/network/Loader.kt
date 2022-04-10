package com.example.imageloader.data.network

import com.example.imageloader.data.models.GetImageData
import com.example.imageloader.data.models.UploadImageData


interface Loader {
    suspend fun imageUpload(getImageData: GetImageData): UploadImageData
}