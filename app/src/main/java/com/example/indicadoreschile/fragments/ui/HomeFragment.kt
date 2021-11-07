package com.example.indicadoreschile.fragments.ui


import android.app.Application

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.indicadoreschile.databinding.FragmentHomeBinding
import com.example.indicadoreschile.di.IndiceApplication
import com.example.indicadoreschile.utils.montoToCLP
import com.example.indicadoreschile.viewmodel.IndiceModelFactory
import com.example.indicadoreschile.viewmodel.IndiceViewModel


class HomeFragment : Fragment() {

    private lateinit var  binding: FragmentHomeBinding

    private lateinit var app: Application


    private val viewModel : IndiceViewModel by activityViewModels {
        IndiceModelFactory((app as IndiceApplication).appContainer.repository)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        app = requireActivity().application


    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)






        viewModel.dolarHoy.observe(viewLifecycleOwner,{
            binding.tvMontoDolar.text = montoToCLP(it.indicador[0].valor)
        })

        viewModel.euroHoy.observe(viewLifecycleOwner,{
            binding.tvMontoEuro.text = montoToCLP(it.indicador[0].valor)
        })


        viewModel.ufHoy.observe(viewLifecycleOwner, {
            binding.tvMontoUf.text = it.indicador[0].valor.toInt().toString()
            binding.tvMontoUf.text = montoToCLP(it.indicador[0].valor)
        })


        viewModel.utmHoy.observe(viewLifecycleOwner, {
            binding.tvMontoUtm.text = it.indicador[0].valor.toString()
        })



        return binding.root

    }


}