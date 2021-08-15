package com.example.projeto_001.fragments.endpoint

import com.example.projeto_001.fragments.model.Products
import retrofit2.Call
import retrofit2.http.GET

interface InterfaceEndpoint {
    @GET("/api/v1/products.json")
    fun buscarProdutos() : Call<List<Products>>
}