package com.example.wizipedia_android.network

// Android
import android.util.Log

// Types
import com.example.wizipedia_android.types.Book
import com.example.wizipedia_android.types.Books
import com.example.wizipedia_android.types.Character
import com.example.wizipedia_android.types.Characters
import com.example.wizipedia_android.types.Houses
import com.example.wizipedia_android.types.Movie
import com.example.wizipedia_android.types.Movies
import com.example.wizipedia_android.types.Spell
import com.example.wizipedia_android.types.Spells


object ApiManager {
    suspend fun getAllCharacters(): Characters? {
        return try {
            RetrofitClient.api.getAllCharacters()
        } catch (e: Exception) {
            Log.e("ApiManager", "Error fetching all characters: ${e.message}", e.cause)
            return null
        }
    }

    suspend fun getCharacter(characterName: String): Character? {
        return try {
            RetrofitClient.api.getCharacter(characterName)
        } catch (e: Exception) {
            Log.e("ApiManager", "Error fetching character: ${e.message}", e.cause)
            return null
        }
    }

    suspend fun getAllHouses(): Houses? {
        return try {
            RetrofitClient.api.getAllHouses()
        } catch (e: Exception) {
            Log.e("ApiManager", "Error fetching all houses: ${e.message}", e.cause)
            return null
        }
    }

    suspend fun getCharactersForHouse(houseName: String): Characters? {
        return try {
            RetrofitClient.api.getCharactersForHouse(houseName)
        } catch (e: Exception) {
            Log.e(
                "ApiManager",
                "Error fetching all characters for one house: ${e.message}",
                e.cause
            )
            return null
        }
    }

    suspend fun getAllSpells(): Spells? {
        return try {
            RetrofitClient.api.getAllSpells()
        } catch (e: Exception) {
            Log.e(
                "ApiManager",
                "Error fetching all spells: ${e.message}",
                e.cause
            )
            return null
        }
    }

    suspend fun getSpell(spellName: String): Spell? {
        return try {
            RetrofitClient.api.getSpell(spellName)
        } catch (e: Exception) {
            Log.e(
                "ApiManager",
                "Error fetching one spell: ${e.message}",
                e.cause
            )
            return null
        }
    }

    suspend fun getAllMovies(): Movies? {
        return try {
            RetrofitClient.api.getAllMovies()
        } catch (e: Exception) {
            Log.e(
                "ApiManager",
                "Error fetching all movies: ${e.message}",
                e.cause
            )
            return null
        }
    }

    suspend fun getMovie(movieName: String): Movie? {
        return try {
            RetrofitClient.api.getMovie(movieName)
        } catch (e: Exception) {
            Log.e(
                "ApiManager",
                "Error fetching one movie: ${e.message}",
                e.cause
            )
            return null
        }
    }

    suspend fun getAllBooks(): Books? {
        return try {
            RetrofitClient.api.getAllBooks()
        } catch (e: Exception) {
            Log.e(
                "ApiManager",
                "Error fetching all books: ${e.message}",
                e.cause
            )
            return null
        }
    }

    suspend fun getBook(bookName: String): Book? {
        return try {
            RetrofitClient.api.getBook(bookName)
        } catch (e: Exception) {
            Log.e(
                "ApiManager",
                "Error fetching one book: ${e.message}",
                e.cause
            )
            return null
        }
    }
}