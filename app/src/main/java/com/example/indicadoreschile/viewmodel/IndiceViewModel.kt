package com.example.indicadoreschile.viewmodel


import android.annotation.SuppressLint
import android.os.Build
import androidx.lifecycle.*
import com.example.indicadoreschile.model.api.IndResponseUF
import com.example.indicadoreschile.model.db.UFEntity
import com.example.indicadoreschile.model.viejos.Ethereum
import com.example.indicadoreschile.model.viejos.Indicador2
import com.example.indicadoreschile.repository.Repository
import com.example.indicadoreschile.utils.formateameElValor
import com.example.indicadoreschile.utils.formateamelafecha
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch


class IndiceViewModel(private val repository: Repository) : ViewModel() {

    private val _ufHoy: MutableLiveData<Indicador2> = MutableLiveData()
    val ufHoy: LiveData<Indicador2> = _ufHoy

    private val _utmHoy = MutableLiveData<Indicador2>()
    val utmHoy: LiveData<Indicador2> = _utmHoy

    val _dolarHoy: MutableLiveData<Indicador2> = MutableLiveData<Indicador2>()
    val dolarHoy: LiveData<Indicador2> = _dolarHoy

    private val _euroHoy = MutableLiveData<Indicador2>()
    val euroHoy: LiveData<Indicador2> = _euroHoy

    private val _bitcoinHoy = MutableLiveData<Indicador2>()
    val bitcoinHoy: LiveData<Indicador2> = _bitcoinHoy

    private val _ethereumHoy = MutableLiveData<Ethereum>()
    val ethereumHoy: LiveData<Ethereum> = _ethereumHoy


    /* <======================================================>*/


    private val _listaUf = MutableLiveData<List<Indicador2>>()
    val listaUf: LiveData<List<Indicador2>> = _listaUf

    private val _listaUtm = MutableLiveData<List<Indicador2>>()
    val listaUtm: LiveData<List<Indicador2>> = _listaUtm

    private val _listaDolar = MutableLiveData<List<Indicador2>>()
    val listaDolar: LiveData<List<Indicador2>> = _listaDolar

    private val _listaEuro = MutableLiveData<List<Indicador2>>()
    val listaEuro: LiveData<List<Indicador2>> = _listaEuro

    private val _listaBitCoin = MutableLiveData<List<Indicador2>>()
    val listaBitcoin: LiveData<List<Indicador2>> = _listaBitCoin

    val eleccionIndicador = MutableLiveData<Int>()

    /* <======================================================>*/

    private var _listaIndicadoresAPI = MutableLiveData<IndResponseUF>()
    val listaIndicadoresApi: LiveData<IndResponseUF> = _listaIndicadoresAPI


    fun listadoIndicador(
        indicador: String,
        hoy: MutableLiveData<Indicador2>,
        listado: MutableLiveData<List<Indicador2>>
    ) {

        viewModelScope.launch {
            hoy.postValue((repository.listadoIndicador(indicador).indicador2[0]))
            listado.postValue((repository.listadoIndicador(indicador).indicador2))
        }

    }

    fun ethereumApi() {
        viewModelScope.launch {
            _ethereumHoy.postValue(repository.ethereum().ethereum)
        }
    }


    init {
        listadoIndicador("dolar", _dolarHoy, _listaDolar)
        listadoIndicador("euro", _euroHoy, _listaEuro)
        listadoIndicador("uf", _ufHoy, _listaUf)
        listadoIndicador("utm", _utmHoy, _listaUtm)
        listadoIndicador("bitcoin", _bitcoinHoy, _listaBitCoin)
        eleccionIndicador.postValue(0)

        ethereumApi()

        listarUFCMF()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            agregarUFADB()
        }


    }


    private fun listarUFCMF() {
        viewModelScope.launch {
            _listaIndicadoresAPI.postValue(repository.traerListadoUFAPI())
        }
    }


    @SuppressLint("NewApi")
    fun agregarUFADB() {
        val listadoUFDB = mutableListOf<UFEntity>()


        viewModelScope.launch(IO) {

            _listaIndicadoresAPI.value?.indicadorUFS?.forEach { indicador ->
                listadoUFDB.add(
                    UFEntity(
                        valor = (indicador.valor.toDouble()),
                        formateamelafecha(indicador.fecha)
                    )
                )
            }

            repository.agregarListadoUFDB(listadoUFDB)

            repository.agregarListadoUSDB()
        }


    }


    val ufHoyCMF = repository.ufHoy().asLiveData()

    val usdHoy = repository.ufHoy().asLiveData()


}

/*
     fun traerUFdeHoy(){
        viewModelScope.launch {
            _ufHoyCMF.postValue(repository.ufHoy().asLiveData().value)
        }
    }
 */

/*
        viewModelScope.launch {
            repository.traerListadoUSDAPI().indicadorUFS.forEach {
                listadoUSDB.add(
                    USDEntity(
                        formateameElValor(it.valor),
                        formateamelafecha(it.fecha)
                    )
                )

                repository.agregarListadoUSDB(listadoUSDB)
            }
        }
 */