package com.mobil80.daggerhilt

interface CryptocurrencyRepository {

    fun getCryptoCurrency(): List<CryptocurrencyData>
}