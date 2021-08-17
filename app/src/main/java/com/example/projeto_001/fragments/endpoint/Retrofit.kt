package com.example.projeto_001.fragments.endpoint

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit {

     private val retrofit = Retrofit.Builder()
        .baseUrl("http://makeup-api.herokuapp.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    fun criarProdutos() :  InterfaceEndpoint {
        return retrofit.create(InterfaceEndpoint::class.java)
    }
}