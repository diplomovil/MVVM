package com.amaurypm.mvvm.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.amaurypm.mvvm.R
import com.amaurypm.mvvm.databinding.ActivityMainBinding
import com.amaurypm.mvvm.model.AnimeModel
import com.amaurypm.mvvm.view.adapters.AnimesAdapter
import com.amaurypm.mvvm.viewmodel.AnimeViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var animes = ArrayList<AnimeModel>()

    private val animeViewModel: AnimeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rv.layoutManager = LinearLayoutManager(this)
        val adapter = AnimesAdapter(this, animes)
        binding.rv.adapter = adapter

        animeViewModel.animeModel.observe(this, Observer { anime->
            val animeTmp = AnimeModel(anime.id, anime.titulo, anime.tipo, anime.fecha)
            animes.add(animeTmp)
            //adapter.notifyDataSetChanged()
            adapter.notifyItemInserted(animes.size-1)

        })

        animeViewModel.name.observe(this, Observer { name ->

            Toast.makeText(this, "Hola $name", Toast.LENGTH_SHORT).show()

        })

        /*binding.btnAdd.setOnClickListener {
            animeViewModel.updateAnime()
        }*/

    }

    fun selectedAnime(anime: AnimeModel){

    }

    fun clickBoton(view: View){
        animeViewModel.updateAnime()
    }
}