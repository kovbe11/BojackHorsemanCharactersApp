package hu.bme.aut.android.bojackhorseman.ui.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.bme.aut.android.bojackhorseman.interactor.CharactersInteractor
import hu.bme.aut.android.bojackhorseman.model.Character
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(private val charactersInteractor: CharactersInteractor) :
    ViewModel() {
    val characters: MutableLiveData<List<Character>> by lazy {
        MutableLiveData<List<Character>>().also { loadCharacters() }
    }

    fun loadCharacters() = viewModelScope.launch {
        charactersInteractor.getCharacters().also { characters.postValue(it) }
    }

}


