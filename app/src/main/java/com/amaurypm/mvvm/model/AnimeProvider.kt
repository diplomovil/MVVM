package com.amaurypm.mvvm.model

/**
 * Creado por Amaury Perea Matsumura el 22/10/22
 */
class AnimeProvider {

    companion object{

        private val animes = ArrayList<AnimeModel>()

        init{
            for(i in 1..30){
                val animeTmp = AnimeModel(i.toLong(), "Título $i", "Tipo $i", "Fecha $i")
                animes.add(animeTmp)
            }
        }

        fun getAnime(): AnimeModel{
            val position = (0..29).random()
            return animes[position]
        }

    }

}