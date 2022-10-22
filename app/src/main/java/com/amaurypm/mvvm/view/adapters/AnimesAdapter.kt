package com.amaurypm.mvvm.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amaurypm.mvvm.databinding.AnimesElementBinding
import com.amaurypm.mvvm.model.AnimeModel
import com.amaurypm.mvvm.view.activities.MainActivity

/**
 * Creado por Amaury Perea Matsumura el 22/10/22
 */
class AnimesAdapter(private val context: Context, val animes: ArrayList<AnimeModel>): RecyclerView.Adapter<AnimesAdapter.ViewHolder>(){

    private val layoutInflater = LayoutInflater.from(context)

    class ViewHolder(view: AnimesElementBinding): RecyclerView.ViewHolder(view.root){
        val tvTitle = view.tvTitulo
        val tvTipo = view.tvTipo
        val tvFecha = view.tvFecha
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = AnimesElementBinding.inflate(layoutInflater)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.tvTitle.text = animes[position].titulo
        holder.tvTipo.text = animes[position].tipo
        holder.tvFecha.text = animes[position].fecha

        //Para los clicks de cada elemento viewholder

        holder.itemView.setOnClickListener {
            //Manejar el click
            if(context is MainActivity) context.selectedAnime(animes[position])
        }

    }

    override fun getItemCount(): Int {
        return animes.size
    }

}
