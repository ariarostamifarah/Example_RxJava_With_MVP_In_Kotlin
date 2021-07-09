package com.example.rxjava_with_mvp_in_kotlin.model


import com.google.gson.annotations.SerializedName

data class Pagination(
    @SerializedName("limit")
    val limit: Int,
    @SerializedName("page")
    val page: Int,
    @SerializedName("pages")
    val pages: Int,
    @SerializedName("total")
    val total: Int
)