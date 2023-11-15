package com.mobil80.daggerhilt

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

// @HiltViewModel will make models to be
// created using Hilt's model factory
// @Inject annotation used to inject all
// dependencies to view model class
@HiltViewModel
class MainViewModel @Inject constructor(
    private val cryptocurrencyRepository: CryptocurrencyRepository
): ViewModel() {

    private val cryptocurrencyEmitter = MutableLiveData<List<CryptocurrencyData>>()
    val cryptocurrency: LiveData<List<CryptocurrencyData>> = cryptocurrencyEmitter

    init {
        loadCryptocurrency()
    }

    private fun loadCryptocurrency(){
        cryptocurrencyEmitter.value = cryptocurrencyRepository.getCryptoCurrency()
    }


}