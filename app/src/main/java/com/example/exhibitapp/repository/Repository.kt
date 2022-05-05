package com.example.exhibitapp.repository

import com.example.exhibitapp.exhibitapi.RestExhibitsLoader

class Repository {

    suspend fun getExhibit() = RestExhibitsLoader.api.getExhibitList()

}