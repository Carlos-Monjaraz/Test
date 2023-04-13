package com.carlosmonjaraz.devmon.test2.ui.home.model

import com.carlosmonjaraz.devmon.test2.domain.model.Product
import java.io.Serializable

data class Product (
    val id : String,
    val title : String,
    val description : String,
    val price : String,
    val image: String
) : Serializable

fun Product.toUI() = Product(id, title, description, price, image)