package com.carlosmonjaraz.devmon.test2.domain.usecases

import com.carlosmonjaraz.devmon.test2.data.ProductRepositoryImpl
import com.carlosmonjaraz.devmon.test2.ui.home.model.Product
import javax.inject.Inject

class GetProducts @Inject constructor(
    private val productRepositoryImpl: ProductRepositoryImpl
) {

    suspend operator fun invoke() : List<Product> {
        return productRepositoryImpl.getAllProducts().map {
            Product(
                id = it.id,
                title = it.title,
                description = it.description,
                price = it.price,
                image = it.image
            )
        }
    }
}