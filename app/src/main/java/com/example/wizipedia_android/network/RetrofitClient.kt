package com.example.wizipedia_android.network

// Project
import com.example.wizipedia_android.BuildConfig

// Constants
import com.example.wizipedia_android.constants.BASE_API_URL
import com.example.wizipedia_android.constants.CONNECT_TIMEOUT
import com.example.wizipedia_android.constants.READ_TIMEOUT
import com.example.wizipedia_android.constants.WRITE_TIMEOUT

// Third-Party libraries
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Java standard library
import java.util.concurrent.TimeUnit

object RetrofitClient {
    private val okHttpClient =
        OkHttpClient
            .Builder()
            .apply {
                addInterceptor(HttpLoggingInterceptor().apply {
                    setLevel(
                        if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                        else HttpLoggingInterceptor.Level.NONE
                    )
                })
                connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            }
            .build()

    val api: Api =
        Retrofit
            .Builder()
            .apply {
                baseUrl(BASE_API_URL)
                client(okHttpClient)
                addConverterFactory(GsonConverterFactory.create())
            }
            .build()
            .create(Api::class.java)
}