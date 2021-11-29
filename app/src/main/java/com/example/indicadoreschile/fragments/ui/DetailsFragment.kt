package com.example.indicadoreschile.fragments.ui

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.indicadoreschile.R
import com.example.indicadoreschile.app.IndiceApplication
import com.example.indicadoreschile.databinding.FragmentDetailsBinding
import com.example.indicadoreschile.utils.textoAfecha
import com.example.indicadoreschile.viewmodel.IndiceModelFactory
import com.example.indicadoreschile.viewmodel.IndiceViewModel
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter


class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    private lateinit var app : Application
    private val viewModel by activityViewModels<IndiceViewModel> {
        IndiceModelFactory((app as IndiceApplication).repository)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        app = requireActivity().application
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(layoutInflater, container, false)

        val lineChart = binding.lineChart

        viewModel.listadoDolar.observe(viewLifecycleOwner, { listaDolar ->
            listaDolar.subList(0,5)

            val linevalues = mutableListOf<Entry>()
                listaDolar.forEach { linevalues.add(Entry(textoAfecha(it.fecha) as Float, it.valor.toFloat())) }




            val lineDataSet = LineDataSet(linevalues, "pepe")
            val lineData = LineData(lineDataSet)
            lineChart.data = lineData
            //val formatter = IndexAxisValueFormatter()
            lineChart.notifyDataSetChanged()
            lineChart.invalidate()
        })

        return binding.root



    }




}