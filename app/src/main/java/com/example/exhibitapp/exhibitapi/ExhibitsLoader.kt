package com.example.exhibitapp.exhibitapi

import com.example.exhibitapp.models.Exhibit
import retrofit2.Response
import retrofit2.http.GET

interface ExhibitsLoader {

    // GET response to get Exhibit json list
    @GET("/Reyst/exhibit_db/list")
    suspend fun getExhibitList(): Response<Exhibit>
}