package com.example.indicadoreschile.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.indicadoreschile.model.Indicador

class IndiceListAdapter : ListAdapter<Indicador, MyViewHolder> (IndiceComparador()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentIndicador = getItem((position))

        holder.unidorDatos(currentIndicador)

    }
}

class IndiceComparador: DiffUtil.ItemCallback<Indicador>() {
    override fun areItemsTheSame(oldItem: Indicador, newItem: Indicador): Boolean {
        return oldItem ==  newItem
    }

    override fun areContentsTheSame(oldItem: Indicador, newItem: Indicador): Boolean {
        return oldItem.fecha == newItem.fecha
    }

}
