package com.example.rxjava_with_mvp_in_kotlin.di.module

import com.example.rxjava_with_mvp_in_kotlin.config.Config
import com.example.rxjava_with_mvp_in_kotlin.di.scope.ActivityScope
import com.example.rxjava_with_mvp_in_kotlin.remote.ApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by aria rostami farah on 7/4/21
 */

@Module
class RemoteModule {

    private val okHttpClient = OkHttpClient.Builder().addInterceptor { chain ->
        val request =
            chain.request().newBuilder().addHeader("Content-type", "application/json")
                .build()
        chain.proceed(request)
    }.connectTimeout(15, TimeUnit.SECONDS)
        .readTimeout(15, TimeUnit.SECONDS)
        .build()



    @Synchronized
    @ActivityScope
    @Provides
    fun provideRetrofit(): ApiService = Retrofit.Builder().baseUrl(Config.BaseUrl)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build()
        .create(ApiService::class.java)


}