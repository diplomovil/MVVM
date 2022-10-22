package com.amaurypm.mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.amaurypm.mvvm.model.AnimeModel
import com.amaurypm.mvvm.model.AnimeProvider

/**
 * Creado por Amaury Perea Matsumura el 22/10/22
 */
class AnimeViewModel: ViewModel() {

    var animeModel = MutableLiveData<AnimeModel>()
    var name = MutableLiveData<String>()
    var id = MutableLiveData<Int>()

    fun updateAnime(){
        val currentAnime = AnimeProvider.getAnime()
        animeModel.postValue(currentAnime)
        name.postValue("Amaury")
    }

}