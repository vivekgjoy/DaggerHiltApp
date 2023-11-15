package com.mobil80.daggerhilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var cryptocurrencyList: RecyclerView

    private val viewModel:MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cryptocurrencyList = findViewById(R.id.cryptocurrency_list)
        cryptocurrencyList.layoutManager = LinearLayoutManager(this)

        observeCrypto()
    }

    private fun observeCrypto(){
        viewModel.cryptocurrency.observe(this){
            cryptocurrencyList.adapter = CryptocurrencyAdapter(it)
        }
    }
}