package com.example.indicadoreschile.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.indicadoreschile.model.ResIndicador
import com.example.indicadoreschile.repository.Repository
import kotlinx.coroutines.launch



class IndiceViewModel(private val repository: Repository): ViewModel() {

    private val _ufHoy: MutableLiveData<ResIndicador> = MutableLiveData()
    val ufHoy : LiveData<ResIndicador> = _ufHoy

    private val _utmHoy = MutableLiveData<ResIndicador>()
    val utmHoy :LiveData<ResIndicador> = _utmHoy


    private val _dolarHoy : MutableLiveData<ResIndicador> = MutableLiveData<ResIndicador>()
    val dolarHoy: LiveData<ResIndicador> = _dolarHoy

    private val _euroHoy = MutableLiveData<ResIndicador>()
    val euroHoy: LiveData<ResIndicador> = _euroHoy





    init{




        listadoIndicador("dolar", _dolarHoy)
        listadoIndicador("uf", _ufHoy)
        listadoIndicador("utm", _utmHoy)
        listadoIndicador("euro", _euroHoy)
    }







    fun listadoIndicador(indicador: String, mutable: MutableLiveData<ResIndicador>){
        viewModelScope.launch {
            mutable.postValue((repository.listadoIndicador(indicador)))
        }

    }

}




/*
    fun listadoUf(){
        viewModelScope.launch {
            data.postValue(repository.listadoUf())
        }
    }
 */

