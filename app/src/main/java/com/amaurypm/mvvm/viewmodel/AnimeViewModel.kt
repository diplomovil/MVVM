package com.amaurypm.mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.amaurypm.mvvm.model.AnimeModel
import com.amaurypm.mvvm.model.AnimeProvider

/**
 * Creado por Amaury Perea Matsumura el 22/10/22
 */
class AnimeViewModel: ViewModel() {

    val animeModel = MutableLiveData<AnimeModel>()
    val name = MutableLiveData<String>()
    val id = MutableLiveData<Int>()

    fun updateAnime(){
        val currentAnime = AnimeProvider.getAnime()
        animeModel.postValue(currentAnime)
    }

}