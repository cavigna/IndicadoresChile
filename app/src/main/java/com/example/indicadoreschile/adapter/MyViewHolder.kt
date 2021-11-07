package com.example.indicadoreschile.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import androidx.recyclerview.widget.RecyclerView
import com.example.indicadoreschile.databinding.ItemRowBinding
import com.example.indicadoreschile.model.Indicador
import com.example.indicadoreschile.utils.fechaApi
import com.example.indicadoreschile.utils.montoToCLP

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val binding: ItemRowBinding = ItemRowBinding.bind(itemView)


    companion object {
        fun create(parent: ViewGroup): MyViewHolder{
            val layoutInflaterB =LayoutInflater.from(parent.context)
            val binding =ItemRowBinding.inflate(layoutInflaterB, parent, false)

            return MyViewHolder(binding.root)

        }
    }

    fun unidorDatos(indicador: Indicador){
        binding.textView.text =  fechaApi(indicador.fecha)
        binding.textView2.text = montoToCLP(indicador.valor)
    }
}
