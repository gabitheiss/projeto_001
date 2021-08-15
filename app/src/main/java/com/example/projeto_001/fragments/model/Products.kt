package com.example.projeto_001.fragments.model

import com.google.gson.annotations.SerializedName

data class Products(
    @SerializedName("name") val nome: String,
    @SerializedName("price") val preco: String,
    @SerializedName("price_sign") val caracter : String,
    @SerializedName("image_link") val imagem: String,
    @SerializedName("product_type") val tipo: String,
    @SerializedName("product_colors") val cor : Cor


)
