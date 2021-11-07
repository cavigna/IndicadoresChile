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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        app = requireActivity().application as IndiceApplication
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(layoutInflater, container, false)

        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = IndiceListAdapter()

        recyclerView.adapter = adapter

        viewModel.listaDolar.observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })


        return binding.root
    }


}