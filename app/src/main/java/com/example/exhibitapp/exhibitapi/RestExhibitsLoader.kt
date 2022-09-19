package com.example.exhibitapp.exhibitapi

import com.example.exhibitapp.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RestExhibitsLoader {

    //Api instance used to handle HTTP calls
    val api: ExhibitsLoader by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ExhibitsLoader::class.java)
    }
}
