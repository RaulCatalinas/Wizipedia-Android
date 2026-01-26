package com.example.wizipedia_android.types

import com.google.gson.annotations.SerializedName

class Movies : ArrayList<Movie>()

data class Movie(
    @SerializedName("box_office")
    val boxOffice: String,
    val budget: String,
    val cinematographers: List<String>,
    val directors: List<String>,
    val distributors: List<String>,
    val editors: List<String>,
    @SerializedName("music_composers")
    val musicComposers: List<String>,
    val poster: String,
    val producers: List<String>,
    val rating: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("running_time")
    val runningTime: String,
    val screenwriters: List<String>,
    val serial: String,
    val summary: String,
    val title: String,
    val trailer: String,
    val wiki: String
)



