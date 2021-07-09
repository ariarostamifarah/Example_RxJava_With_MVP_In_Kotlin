package com.example.rxjava_with_mvp_in_kotlin.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Category(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
):Serializable