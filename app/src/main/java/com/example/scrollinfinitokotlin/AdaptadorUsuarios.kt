package com.example.scrollinfinitokotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdaptadorUsuarios(
    val listaUsuarios: List<String>
): RecyclerView.Adapter<AdaptadorUsuarios.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_usuarios, parent, false)
        return ViewHolder(vista)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvUsuario.setText(listaUsuarios.get(position))
    }

    override fun getItemCount(): Int {
        return listaUsuarios.size
    }

    class ViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView) {

        val tvUsuario = itemView.findViewById<TextView>(R.id.tvUsuario)

    }
}