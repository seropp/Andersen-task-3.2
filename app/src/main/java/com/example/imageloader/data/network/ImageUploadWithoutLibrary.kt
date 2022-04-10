package com.example.imageloader.data.network

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.example.imageloader.data.models.GetImageData
import com.example.imageloader.data.models.UploadImageData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.URL
import java.net.URLConnection


class ImageUploadWithoutLibrary : Loader {

    override suspend fun imageUpload(getImageData: GetImageData): UploadImageData =
        withContext(Dispatchers.IO) {

            val connection: URLConnection = URL(getImageData.imageUrl).openConnection()
            connection.connect()
            val inputStream = connection.getInputStream()

            val bitmap: Bitmap = BitmapFactory.decodeStream(inputStream)
            inputStream.close()
            return@withContext UploadImageData(bitmap)
        }
}

