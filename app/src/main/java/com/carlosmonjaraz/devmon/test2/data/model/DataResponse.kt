package com.carlosmonjaraz.devmon.test2.data.model

import com.google.gson.annotations.SerializedName

data class DataResponse(
    @SerializedName("products") val products: List<Product>
)

data class Product(
    @SerializedName("id") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("price") val price: String,
    @SerializedName("thumbnail") val image: String
)