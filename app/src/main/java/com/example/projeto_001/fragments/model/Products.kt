package com.example.projeto_001.fragments.model

import com.google.gson.annotations.SerializedName

data class Products(
    @SerializedName("name") val nome: String,
    @SerializedName("price") val preco: String,
    @SerializedName("image_link") val imagem: String,
    @SerializedName("product_type") val tipo: String,
    @SerializedName("product_colors") val cor : List<Colors?>?

)

data class Colors(
    @SerializedName("colour_name") val productColor : String?
)
