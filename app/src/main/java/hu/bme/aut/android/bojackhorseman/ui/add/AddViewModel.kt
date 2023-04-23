package hu.bme.aut.android.bojackhorseman.ui.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.bme.aut.android.bojackhorseman.interactor.CharactersInteractor
import hu.bme.aut.android.bojackhorseman.model.Character
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(private val charactersInteractor: CharactersInteractor) :
    ViewModel() {

    fun onCreate(character: Character) {
        viewModelScope.launch {
            charactersInteractor.createCharacter(character)
        }
    }
}