package com.example.projeto_001.fragments.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.projeto_001.R
import com.example.projeto_001.fragments.endpoint.Retrofit
import com.example.projeto_001.fragments.model.Products
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DetailsFragment(private val products: Products) : Fragment(R.layout.fragment_details) {

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)

            itemView.findViewById<TextView>(R.id.idName)?.apply {
                text = products.nome
            }
            itemView.findViewById<ImageView>(R.id.idImagem)?.apply {
                Glide.with(context)
                    .load(products.imagem)
                    .placeholder(R.drawable.ic_img_test_background)
                    .into(this)
            }
            itemView.findViewById<TextView>(R.id.idType)?.apply {
                text = products.tipo
            }
            itemView.findViewById<TextView>(R.id.idCor)?.apply {
                text = products.cor?.firstOrNull()?.productColor
            }
            itemView.findViewById<TextView>(R.id.idPreco)?.apply {
                text = "R$ ${products.preco}"
            }

    }

}


