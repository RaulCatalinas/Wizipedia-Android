package com.example.wizipedia_android.network

// Types
import com.example.wizipedia_android.types.Movies
import com.example.wizipedia_android.types.Spell
import com.example.wizipedia_android.types.Spells
import com.example.wizipedia_android.types.Book
import com.example.wizipedia_android.types.Books
import com.example.wizipedia_android.types.Characters
import com.example.wizipedia_android.types.Character
import com.example.wizipedia_android.types.Houses
import com.example.wizipedia_android.types.Movie

// Third-Party libraries
import retrofit2.http.GET
import retrofit2.http.Path


interface Api {
    @GET("characters")
    suspend fun getAllCharacters(): Characters

    @GET("characters/{character_name}")
    suspend fun getCharacter(@Path("character_name") characterName: String): Character

    @GET("houses")
    suspend fun getAllHouses(): Houses

    @GET("houses/{house_name}")
    suspend fun getCharactersForHouse(@Path("house_name") houseName: String): Characters

    @GET("spells")
    suspend fun getAllSpells(): Spells

    @GET("spells/{spell_name}")
    suspend fun getSpell(@Path("spell_name") spellName: String): Spell

    @GET("movies")
    suspend fun getAllMovies(): Movies

    @GET("movies/{movie_name}")
    suspend fun getMovie(@Path("movie_name") movieName: String): Movie

    @GET("books")
    suspend fun getAllBooks(): Books

    @GET("books/{book_name}")
    suspend fun getBook(@Path("book_name") bookName: String): Book
}