package com.example.indicadoreschile.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.indicadoreschile.repository.Repository


class IndiceModelFactory (private val repository: Repository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return IndiceViewModel(repository) as T
    }
}



