package com.atakanmadanoglu.nasa_rover_vehicles.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atakanmadanoglu.nasa_rover_vehicles.api.RetrofitInstance
import com.atakanmadanoglu.nasa_rover_vehicles.model.PhotosResponse
import kotlinx.coroutines.launch

class CuriosityPhotosViewModel: ViewModel() {

    private val retrofit = RetrofitInstance()

    private val _photos = MutableLiveData<PhotosResponse>()
    val photos: LiveData<PhotosResponse> get() = _photos

    fun getPhotos() = viewModelScope.launch {
        _photos.value = retrofit.api.getCuriosityPhotos().body()
    }

    fun getFHAZPhotos() = viewModelScope.launch {
        _photos.value = retrofit.api.getSpecificCameraPhotosForCuriosity(camera = "fhaz").body()
    }
    fun getRHAZPhotos() = viewModelScope.launch {
        _photos.value = retrofit.api.getSpecificCameraPhotosForCuriosity(camera = "rhaz").body()
    }
    fun getMASTPhotos() = viewModelScope.launch {
        _photos.value = retrofit.api.getSpecificCameraPhotosForCuriosity(camera = "mast").body()
    }
    fun getCHEMCAMPhotos() = viewModelScope.launch {
        _photos.value = retrofit.api.getSpecificCameraPhotosForCuriosity(camera = "chemcam").body()
    }
    fun getNAVCAMPhotos() = viewModelScope.launch {
        _photos.value = retrofit.api.getSpecificCameraPhotosForCuriosity(camera = "navcam").body()
    }
    fun getMARDIPhotos() = viewModelScope.launch {
        _photos.value = retrofit.api.getSpecificCameraPhotosForCuriosity(camera = "mardi").body()
    }
    fun getMAHLIPhotos() = viewModelScope.launch {
        _photos.value = retrofit.api.getSpecificCameraPhotosForCuriosity(camera = "mahli").body()
    }

}