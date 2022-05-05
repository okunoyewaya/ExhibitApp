package api

import models.Exhibit
import retrofit2.Response
import retrofit2.http.GET

interface ExhibitsLoader {


    @GET("/Reyst/exhibit_db/list")
    suspend fun getExhibitList(): Response<Exhibit>
}