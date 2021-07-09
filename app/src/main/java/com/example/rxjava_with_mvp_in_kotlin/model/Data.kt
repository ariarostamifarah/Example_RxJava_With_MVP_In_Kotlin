package com.example.rxjava_with_mvp_in_kotlin.model


import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Data(
    @SerializedName("categories")
    val categories: List<Category>,
    @SerializedName("description")
    val description: String,
    @SerializedName("discount_amount")
    val discountAmount: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: String,
    @SerializedName("status")
    val status: Boolean
):Serializable




object DiffData:DiffUtil.ItemCallback<Data>(){

    override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {

        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {

        return oldItem == newItem
    }


}