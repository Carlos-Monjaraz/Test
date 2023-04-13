package com.carlosmonjaraz.devmon.test2.domain.repository

import com.carlosmonjaraz.devmon.test2.domain.model.Product

interface ProductsRepository {
    suspend fun getAllProducts() : List<Product>
}