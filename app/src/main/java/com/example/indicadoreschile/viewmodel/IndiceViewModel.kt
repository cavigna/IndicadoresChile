package com.example.indicadoreschile.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.indicadoreschile.model.Indicador
import com.example.indicadoreschile.model.ResIndicador
import com.example.indicadoreschile.repository.Repository
import kotlinx.coroutines.launch



class IndiceViewModel(private val repository: Repository): ViewModel() {

    private val _ufHoy: MutableLiveData<Indicador> = MutableLiveData()
    val ufHoy : LiveData<Indicador> = _ufHoy

    private val _utmHoy = MutableLiveData<Indicador>()
    val utmHoy :LiveData<Indicador> = _utmHoy

    private val _dolarHoy : MutableLiveData<Indicador> = MutableLiveData<Indicador>()
    val dolarHoy: LiveData<Indicador> = _dolarHoy

    private val _euroHoy = MutableLiveData<Indicador>()
    val euroHoy: LiveData<Indicador> = _euroHoy

    private val _bitcoinHoy = MutableLiveData<Indicador>()
    val bitcoinHoy: LiveData<Indicador> = _bitcoinHoy

    /* <======================================================>*/



    private val _listaUf = MutableLiveData<List<Indicador>>()
    val listaUf : LiveData<List<Indicador>> = _listaUf

    private val _listaUtm = MutableLiveData<List<Indicador>>()
    val listaUtm : LiveData<List<Indicador>> = _listaUtm

    private val _listaDolar = MutableLiveData<List<Indicador>>()
    val listaDolar : LiveData<List<Indicador>> = _listaDolar

    private val _listaEuro = MutableLiveData<List<Indicador>>()
    val listaEuro : LiveData<List<Indicador>> = _listaEuro

    private val _listaBitCoin = MutableLiveData<List<Indicador>>()
    val listaBitcoin : LiveData<List<Indicador>> = _listaBitCoin

    val eleccionIndicador = MutableLiveData<Int>()




    init{
        listadoIndicador("dolar", _dolarHoy, _listaDolar)
        listadoIndicador("euro", _euroHoy, _listaEuro)
        listadoIndicador("uf", _ufHoy, _listaUf)
        listadoIndicador("utm", _utmHoy, _listaUtm)
        listadoIndicador("bitcoin", _bitcoinHoy, _listaBitCoin)
        eleccionIndicador.postValue(0)

    }


    fun listadoIndicador(indicador: String, hoy: MutableLiveData<Indicador>, listado:MutableLiveData<List<Indicador>>){
        viewModelScope.launch {
            hoy.postValue((repository.listadoIndicador(indicador).indicador[0]))
            listado.postValue((repository.listadoIndicador(indicador).indicador))
        }

    }

}

/*
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
 */


/*
    fun listadoUf(){
        viewModelScope.launch {
            data.postValue(repository.listadoUf())
        }
    }
 */

