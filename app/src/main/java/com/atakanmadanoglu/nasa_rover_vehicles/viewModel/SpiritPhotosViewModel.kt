package com.atakanmadanoglu.nasa_rover_vehicles.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atakanmadanoglu.nasa_rover_vehicles.api.RetrofitInstance
import com.atakanmadanoglu.nasa_rover_vehicles.model.PhotosResponse
import kotlinx.coroutines.launch

class SpiritPhotosViewModel: ViewModel() {

    private val retrofit = RetrofitInstance()

    private val _photos = MutableLiveData<PhotosResponse>()
    val photos: LiveData<PhotosResponse> get() = _photos

    fun getPhotos() = viewModelScope.launch {
        _photos.value = retrofit.api.getSpiritPhotos().body()
    }
    fun getFHAZPhotos() = viewModelScope.launch {
        _photos.value = retrofit.api.getSpecificCameraPhotosForSpirit(camera = "fhaz").body()
    }
    fun getRHAZPhotos() = viewModelScope.launch {
        _photos.value = retrofit.api.getSpecificCameraPhotosForSpirit(camera = "rhaz").body()
    }

    fun getNAVCAMPhotos() = viewModelScope.launch {
        _photos.value = retrofit.api.getSpecificCameraPhotosForSpirit(camera = "navcam").body()
    }
    fun getPANCAMPhotos() = viewModelScope.launch {
        _photos.value = retrofit.api.getSpecificCameraPhotosForSpirit(camera = "pancam").body()
    }

    fun getMINITESPhotos() = viewModelScope.launch {
        _photos.value = retrofit.api.getSpecificCameraPhotosForSpirit(camera = "minites").body()
    }

}