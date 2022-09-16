package com.example.exhibitapp.repository

import com.example.exhibitapp.exhibitapi.RestExhibitsLoader

// Response class used to separate the viewModel from the Api method calls (following MVVM pattern)
class Repository {

    suspend fun getExhibit() = RestExhibitsLoader.api.getExhibitList()

}