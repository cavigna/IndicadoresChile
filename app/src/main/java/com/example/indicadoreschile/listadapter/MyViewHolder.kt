package com.example.indicadoreschile.listadapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.example.indicadoreschile.R
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

    fun unidorDatos(indicador: Indicador, eleccionInicador: Int){

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


        binding.textView.text =  fechaApi(indicador.fecha)
        binding.textView2.text = montoToCLP(indicador.valor)


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
