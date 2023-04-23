package hu.bme.aut.android.bojackhorseman.network

import hu.bme.aut.android.bojackhorseman.model.Character
import retrofit2.Response
import retrofit2.http.*


interface CharactersApi {
    @POST
    suspend fun create(character: Character): Response<Unit>

    @GET
    suspend fun findAll(): Response<List<Character>>

    @PUT
    suspend fun update(character: Character): Response<Unit>

    @DELETE("/{id}")
    suspend fun delete(@Path("id") id: Int): Response<Unit>
}