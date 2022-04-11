package com.example.imageloader.data.repository

import com.example.imageloader.data.models.GetImageData
import com.example.imageloader.data.models.UploadImageData
import com.example.imageloader.data.network.Loader
import com.example.imageloader.domain.models.GetImage
import com.example.imageloader.domain.models.UploadedImage
import com.example.imageloader.domain.repository.ImageLoader

class ImageLoaderImpl(private val loader: Loader) : ImageLoader {

    override suspend fun imageUpload(getImage: GetImage): UploadedImage {
        val uploadImageData: UploadImageData =
            loader.imageUpload(mapToGetImageData(getImage = getImage))
        return UploadedImage(image = mapToUploadImage(uploadImageData = uploadImageData).image)
    }

    private fun mapToUploadImage(uploadImageData: UploadImageData): UploadedImage {
        return UploadedImage(uploadImageData.image)
    }

    private fun mapToGetImageData(getImage: GetImage): GetImageData {
        return GetImageData(getImage.imageUrl)
    }

}
