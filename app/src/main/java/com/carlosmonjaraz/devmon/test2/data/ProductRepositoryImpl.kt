package com.carlosmonjaraz.devmon.test2.data

import com.carlosmonjaraz.devmon.retrofit.data.network.ApiClient
import com.carlosmonjaraz.devmon.test2.domain.model.Product
import com.carlosmonjaraz.devmon.test2.domain.repository.ProductsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val api : ApiClient
) : ProductsRepository {
    override suspend fun getAllProducts(): List<Product> {
        return withContext(Dispatchers.IO) {
            val response = api.getProducts()

            if (response.isSuccessful) {
                val list = response.body()!!.products.map {
                    Product(
                        id = it.id,
                        title = it.title,
                        description = it.description,
                        price = it.price,
                        image = it.image
                    )
                }
                list
            } else emptyList()
        }
    }
}