package com.example.wizipedia_android.types

import com.google.gson.annotations.SerializedName

class Books : ArrayList<Book>()

data class Book(
    val author: String?,
    val cover: String,
    val dedication: String,
    val pages: String,
    @SerializedName("release_date")
    val releaseDate: String?,
    val serial: String,
    val summary: String,
    val title: String,
    val wiki: String
)


