package com.example.rxjava_with_mvp_in_kotlin.model


import com.google.gson.annotations.SerializedName

data class Meta(
    @SerializedName("pagination")
    val pagination: Pagination
)