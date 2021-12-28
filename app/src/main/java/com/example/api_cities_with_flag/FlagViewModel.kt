package com.example.api_cities_with_flag

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api_cities_with_flag.network.FlagApi
import com.example.api_cities_with_flag.network.FlagPhoto
import kotlinx.coroutines.launch

class FlagViewModel:ViewModel() {
    private val _status = MutableLiveData<String>()
    val status: LiveData<String> = _status
    private val _photo = MutableLiveData<List<FlagPhoto>>()
    val photo:LiveData<List<FlagPhoto>> =_photo
    init {
        getFlagPhotos()
    }
    private fun getFlagPhotos(){
        viewModelScope.launch {
            try {
                _photo.value= FlagApi.retrofitService.getPhotos().data
                _status.value="aaaa"
            }catch (e:Exception){
                _status.value = "Failure: ${e.message}"

            }
        }
    }
}