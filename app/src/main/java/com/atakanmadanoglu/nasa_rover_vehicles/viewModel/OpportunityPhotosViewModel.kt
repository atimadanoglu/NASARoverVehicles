package com.atakanmadanoglu.nasa_rover_vehicles.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atakanmadanoglu.nasa_rover_vehicles.api.RetrofitInstance
import com.atakanmadanoglu.nasa_rover_vehicles.model.PhotosResponse
import kotlinx.coroutines.launch

class OpportunityPhotosViewModel: ViewModel() {

    private val retrofit = RetrofitInstance()

    private val _photos = MutableLiveData<PhotosResponse>()
    val photos: LiveData<PhotosResponse> get() = _photos

    fun getPhotos() = viewModelScope.launch {
        _photos.value = retrofit.api.getOpportunityPhotos().body()
    }
    fun getFHAZPhotos() = viewModelScope.launch {
        _photos.value = retrofit.api.getSpecificCameraPhotosForOpportunity(camera = "fhaz").body()
    }
    fun getRHAZPhotos() = viewModelScope.launch {
        _photos.value = retrofit.api.getSpecificCameraPhotosForOpportunity(camera = "rhaz").body()
    }

    fun getNAVCAMPhotos() = viewModelScope.launch {
        _photos.value = retrofit.api.getSpecificCameraPhotosForOpportunity(camera = "navcam").body()
    }
    fun getPANCAMPhotos() = viewModelScope.launch {
        _photos.value = retrofit.api.getSpecificCameraPhotosForOpportunity(camera = "pancam").body()
    }

    fun getMINITESPhotos() = viewModelScope.launch {
        _photos.value = retrofit.api.getSpecificCameraPhotosForOpportunity(camera = "minites").body()
    }

}