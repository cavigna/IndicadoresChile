package com.example.indicadoreschile.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.example.indicadoreschile.R
import com.example.indicadoreschile.databinding.ItemRowBinding
import com.example.indicadoreschile.model.viejos.Indicador2
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

    fun unidorDatos(indicador2: Indicador2, eleccionInicador: Int){

        when(eleccionInicador){
            1 -> {
                binding.cardLayout.setBackgroundResource(R.color.dashboard_item1)
            }

            2 -> {
                binding.cardLayout.setBackgroundResource(R.color.dashboard_item2)
            }

            3 -> {
                binding.cardLayout.setBackgroundResource(R.color.dashboard_item3)
            }

            4 -> {
                binding.cardLayout.setBackgroundResource(R.color.dashboard_item4)
            }
        }


        binding.textView.text =  fechaApi(indicador2.fecha)
        binding.textView2.text = montoToCLP(indicador2.valor)


    }
}

/*
#E64000
#F6B000
 */

/*
        if(eleccionInicador ==2){
            //binding.cardRow.setCardBackgroundColor(Color.parseColor("#5351FC"))
            binding.cardRow.setBackgroundResource(R.color.dashboard_item2)
        }

        when(eleccionInicador){
            1 -> {
                binding.cardRow.setCardBackgroundColor(Color.parseColor("#01CD98"))
            }

            2 -> {
                binding.cardRow.setCardBackgroundColor(Color.parseColor("#5351FC"))
            }
        }
 */
