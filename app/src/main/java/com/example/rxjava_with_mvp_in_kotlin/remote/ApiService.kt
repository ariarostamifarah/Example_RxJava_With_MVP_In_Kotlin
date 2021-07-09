package com.example.rxjava_with_mvp_in_kotlin.remote

import com.example.rxjava_with_mvp_in_kotlin.config.Config
import com.example.rxjava_with_mvp_in_kotlin.model.ProductsResult
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by aria rostami farah on 7/4/21
 */
interface ApiService {

    @GET(Config.PathProducts)
    fun getProducts():Single<ProductsResult>

    @GET(Config.PathProducts)
    fun getProducts(@Query("page") page:Long):Single<ProductsResult>


}