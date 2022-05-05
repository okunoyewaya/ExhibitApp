package repository

import api.ExhibitsLoader
import api.RestExhibitsLoader

class Repository {

    suspend fun getExhibit() = RestExhibitsLoader.api.getExhibitList()

}