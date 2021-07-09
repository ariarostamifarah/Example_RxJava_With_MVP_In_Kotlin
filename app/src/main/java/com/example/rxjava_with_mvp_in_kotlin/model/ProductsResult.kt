package com.example.rxjava_with_mvp_in_kotlin.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ProductsResult(
    @SerializedName("code")
    val code: Int,
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("meta")
    val meta: Meta
):Serializable