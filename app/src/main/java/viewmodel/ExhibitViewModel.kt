package viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import models.Exhibit
import repository.Repository
import retrofit2.Response

class ExhibitViewModel(val repository: Repository): ViewModel() {

    val exhibitResponse: MutableLiveData<Response<Exhibit>> = MutableLiveData()

    fun getExhibit() = viewModelScope.launch {
        val response = repository.getExhibit()
        exhibitResponse.value = response
    }
}