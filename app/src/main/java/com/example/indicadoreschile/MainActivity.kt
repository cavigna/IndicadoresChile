package com.example.indicadoreschile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.indicadoreschile.databinding.ActivityMainBinding
import com.example.indicadoreschile.di.IndiceApplication
import com.example.indicadoreschile.viewmodel.IndiceModelFactory
import com.example.indicadoreschile.viewmodel.IndiceViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding



    private val viewModel: IndiceViewModel by viewModels{
        IndiceModelFactory((application as IndiceApplication).appContainer.repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}