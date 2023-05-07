package hu.bme.aut.android.bojackhorseman.network

import retrofit2.Response
import retrofit2.http.*


interface CharactersApi {
    @POST("characters")
    suspend fun create(@Body character: CharacterDTO): Response<Unit>

    @GET("characters")
    suspend fun findAll(): Response<List<CharacterDTO>>

    @PUT("characters")
    suspend fun update(@Body character: CharacterDTO): Response<Unit>

    @DELETE("characters/{id}")
    suspend fun delete(@Path("id") id: Int): Response<Unit>
}