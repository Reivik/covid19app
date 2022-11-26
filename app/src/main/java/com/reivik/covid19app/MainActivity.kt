package com.reivik.covid19app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.reivik.covid19app.databinding.ActivityMainBinding
import com.reivik.covid19app.utils.resCountriesApi
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.searchCountryNameBtn.setOnClickListener {
            val countryName = binding.countryNameEditText.text.toString()

            lifecycleScope.launch {
                val countries = resCountriesApi.getCountryByName(countryName)
                val country = countries[0]

                binding.countryCodeTextView.text = country.CountryCode
                binding.countryNameTextView.text = country.Country
                binding.deathTextView.text = country.Deaths.toString()
            }
        }
    }
}