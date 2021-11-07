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
            binding.tvMontoBitcoin.text = montoToCLP(it.valor)
        })

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



        return binding.root

    }


}