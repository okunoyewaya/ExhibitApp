package com.example.exhibitapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.example.exhibitapp.models.Exhibit
import com.example.exhibitapp.repository.Repository
import retrofit2.Response

class ExhibitViewModel(val repository: Repository): ViewModel() {

    val exhibitResponse: MutableLiveData<Response<Exhibit>> = MutableLiveData()

    fun getExhibit() = viewModelScope.launch {
        val response = repository.getExhibit()
        exhibitResponse.value = response
    }
}