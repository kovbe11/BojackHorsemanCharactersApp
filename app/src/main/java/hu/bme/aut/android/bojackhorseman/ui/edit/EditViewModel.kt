package hu.bme.aut.android.bojackhorseman.ui.edit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.bme.aut.android.bojackhorseman.interactor.CharactersInteractor
import hu.bme.aut.android.bojackhorseman.model.Character
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditViewModel @Inject constructor(private val charactersInteractor: CharactersInteractor) :
    ViewModel() {

    fun onUpdate(character: Character) {
        viewModelScope.launch {
            charactersInteractor.updateCharacter(character)
        }
    }

    fun onDelete(character: Character) {
        viewModelScope.launch {
            charactersInteractor.deleteCharacter(character)
        }
    }
}