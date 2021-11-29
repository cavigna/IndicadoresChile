package com.example.indicadoreschile.fragments.ui


import android.app.Application

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.indicadoreschile.R
import com.example.indicadoreschile.databinding.FragmentHomeBinding
import com.example.indicadoreschile.app.IndiceApplication
import com.example.indicadoreschile.utils.montoToCLP
import com.example.indicadoreschile.utils.montoToCLP2
import com.example.indicadoreschile.utils.montoToUSD
import com.example.indicadoreschile.viewmodel.IndiceModelFactory
import com.example.indicadoreschile.viewmodel.IndiceViewModel


class HomeFragment : Fragment() {

    private lateinit var  binding: FragmentHomeBinding

    private lateinit var app: Application


    private val viewModel : IndiceViewModel by activityViewModels {
        IndiceModelFactory((app as IndiceApplication).repository)
    }
/*
    private val viewModel : IndiceViewModel by activityViewModels {
        IndiceModelFactory((app as IndiceApplication).appContainer.repository)
    }
 */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        app = requireActivity().application

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        ponerMontoCard()
        enrutador()


        //viewModel.ethereumApi()

        return binding.root

    }


    private fun ponerMontoCard(){

        viewModel.ufHoy.observe(viewLifecycleOwner,{
            // binding.tvMontoDolar.text = montoToCLP(it.valor)
            binding.tvMontoUf.text = montoToCLP2( it.valor)
        })

        viewModel.listadoDolar.observe(viewLifecycleOwner,{
           // binding.tvMontoDolar.text = montoToCLP(it.valor)
            binding.tvMontoDolar.text = montoToCLP2(it[0].valor)
        })

        viewModel.listadoEuro.observe(viewLifecycleOwner,{
            binding.tvMontoEuro.text = montoToCLP2(it[0].valor)
        })


        viewModel.listadoUTM.observe(viewLifecycleOwner, {
            binding.tvMontoUtm.text = montoToCLP2(it[0].valor)
        })

        viewModel.listadoBitcoin.observe(viewLifecycleOwner, {

            binding.tvMontoBitcoin.text = montoToUSD((it[0].valor) )
        })

        viewModel.ethereumHoy.observe(viewLifecycleOwner, {
            binding.tvMontoEth.text = montoToUSD(it.usd)
        })


    }

    private fun enrutador(){
        binding.cardViewdDolar.setOnClickListener {
            viewModel.eleccionIndicador.value = 1
            findNavController().navigate(R.id.action_homeFragment_to_listFragment)
        }

        binding.cardViewEuro.setOnClickListener {
            viewModel.eleccionIndicador.value = 2
            findNavController().navigate(R.id.action_homeFragment_to_listFragment)
        }



        binding.cardViewUf.setOnClickListener {
            viewModel.eleccionIndicador.value = 3
            findNavController().navigate(R.id.action_homeFragment_to_listFragment)
        }


        binding.cardViewUtm.setOnClickListener {
            viewModel.eleccionIndicador.value = 4
            findNavController().navigate(R.id.action_homeFragment_to_listFragment)
        }
    }


}

/*
    private fun ponerMontoCard(){
        viewModel.dolarHoy.observe(viewLifecycleOwner,{
            binding.tvMontoDolar.text = montoToCLP(it.valor)
        })

        viewModel.euroHoy.observe(viewLifecycleOwner,{
            binding.tvMontoEuro.text = montoToCLP(it.valor)
        })


        viewModel.ufHoy.observe(viewLifecycleOwner, {

            binding.tvMontoUf.text = montoToCLP(it.valor)
        })


        viewModel.utmHoy.observe(viewLifecycleOwner, {
            binding.tvMontoUtm.text = montoToCLP(it.valor)
        })

        viewModel.bitcoinHoy.observe(viewLifecycleOwner, {
            //binding.tvMontoBitcoin.text = montoToCLP((it.valor).toInt() * viewModel.dolarHoy.value!!.valor )
            binding.tvMontoBitcoin.text = montoToUSD((it.valor) )
        })

        viewModel.ethereumHoy.observe(viewLifecycleOwner, {
            binding.tvMontoEth.text = montoToUSD(it.usd)
        })


    }
 */