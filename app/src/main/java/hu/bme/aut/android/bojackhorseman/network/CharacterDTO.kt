package hu.bme.aut.android.bojackhorseman.network

import hu.bme.aut.android.bojackhorseman.model.Character

data class CharacterDTO(
    val id: Int,
    val name: String,
    val voiceActor: String,
    val species: String
)

fun Character.toDTO() = CharacterDTO(id, name, voiceActor, species)
fun CharacterDTO.toEntity() = Character(id, name, voiceActor, species)