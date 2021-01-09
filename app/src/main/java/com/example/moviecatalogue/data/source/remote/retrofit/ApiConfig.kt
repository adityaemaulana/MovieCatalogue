package com.example.moviecatalogue.data.source.remote.retrofit

import com.example.moviecatalogue.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

class ApiConfig {
    companion object {
        private const val BASE_URL = "https://api.themoviedb.org/3/"

        fun getApiService(): ApiService {
            val loggingInterceptor =
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            val customInterceptor = Interceptor { chain ->
                val request = chain.request()
                val newUrl = request.url.newBuilder().addQueryParameter("api_key", BuildConfig.API_KEY).build()
                val newRequest = request.newBuilder().url(newUrl).build()

                chain.proceed(newRequest)
            }

            val client = OkHttpClient.Builder()
                .addInterceptor(customInterceptor)
                .addInterceptor(loggingInterceptor)
                .build()
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .client(client)
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }
}