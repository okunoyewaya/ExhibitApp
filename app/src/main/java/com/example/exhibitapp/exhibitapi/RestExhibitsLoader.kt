package com.example.exhibitapp.exhibitapi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RestExhibitsLoader {

    private const val BASE_URL = "https://my-json-server.typicode.com"

    val api: ExhibitsLoader by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ExhibitsLoader::class.java)
    }
}
