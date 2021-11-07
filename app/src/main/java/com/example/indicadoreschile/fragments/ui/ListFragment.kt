package com.example.indicadoreschile.fragments.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.indicadoreschile.adapter.IndiceListAdapter
import com.example.indicadoreschile.databinding.FragmentListBinding
import com.example.indicadoreschile.di.IndiceApplication
import com.example.indicadoreschile.viewmodel.IndiceModelFactory
import com.example.indicadoreschile.viewmodel.IndiceViewModel

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding

    private lateinit var app : IndiceApplication

    private val viewModel : IndiceViewModel by activityViewModels {
        IndiceModelFactory((app).appContainer.repository)
    }

    private lateinit var recyclerView : RecyclerView
    private lateinit var adapter: IndiceListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        app = requireActivity().application as IndiceApplication
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(layoutInflater, container, false)

        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
         adapter = IndiceListAdapter()

        recyclerView.adapter = adapter

        setAdapter(viewModel.eleccionIndicador.value!!)


        return binding.root
    }

    fun setAdapter(eleccion: Int){
        when(eleccion){
            1 -> {
                viewModel.listaDolar.observe(viewLifecycleOwner, {
                    adapter.eleccion = 1
                    adapter.submitList(it)
                })
            }

            2 ->{
                viewModel.listaEuro.observe(viewLifecycleOwner, {
                    adapter.eleccion = 2
                    adapter.submitList(it)
                })
            }

            3 ->{
                viewModel.listaUf.observe(viewLifecycleOwner, {
                    adapter.eleccion = 3
                    adapter.submitList(it)
                })
            }

            4 ->{
                viewModel.listaUtm.observe(viewLifecycleOwner, {
                    adapter.eleccion = 4
                    adapter.submitList(it)
                })
            }
        }
    }


}