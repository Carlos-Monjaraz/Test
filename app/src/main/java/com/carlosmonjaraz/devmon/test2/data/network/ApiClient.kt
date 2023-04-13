package com.carlosmonjaraz.devmon.retrofit.data.network

import com.carlosmonjaraz.devmon.test2.data.model.DataResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiClient {

    @GET("/products")
    suspend fun getProducts(): Response<DataResponse>
}