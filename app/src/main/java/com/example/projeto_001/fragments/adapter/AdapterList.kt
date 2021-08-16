package com.example.projeto_001.fragments.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.projeto_001.R
import com.example.projeto_001.fragments.model.Products

class AdapterList(var listOfProducts: MutableList<Products>) :
    RecyclerView.Adapter<ItensProductsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItensProductsViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.itens_products, parent, false)
        return ItensProductsViewHolder(view)
    }


    override fun onBindViewHolder(holder: ItensProductsViewHolder, position: Int) {
        listOfProducts[position].apply {
            holder.bind(this)
        }
    }

    override fun getItemCount(): Int {
        return listOfProducts.size
    }

    fun refresh(products: List<Products>) {
        listOfProducts = mutableListOf()
        listOfProducts.addAll(products)
        notifyDataSetChanged()
    }

}

class ItensProductsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(products: Products) {
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

        itemView.findViewById<TextView>(R.id.idCor)?.apply{
            text = products.cor?.firstOrNull()?.productColor
        }

        itemView.findViewById<TextView>(R.id.idPreco)?.apply {
            text = "R$ ${products.preco}"
        }
    }
}


