package com.example.projeto_001.fragments.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projeto_001.R
import com.example.projeto_001.fragments.MainActivity
import com.example.projeto_001.fragments.adapter.AdapterList
import com.example.projeto_001.fragments.endpoint.Retrofit
import com.example.projeto_001.fragments.model.Navigation
import com.example.projeto_001.fragments.model.Products
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ProductFragment(private val interfaceNavigate: Navigation) :
    Fragment(R.layout.fragment_product), Callback<List<Products>> {

    private lateinit var listOfProducts: Callback<List<Products>>
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AdapterList


    val call by lazy {
        val carregar = Retrofit.criarProdutos()
        carregar.buscarProdutos()
    }

    var parametroTipoLista: Int = 0

    override fun onAttach(context: Context) {
        super.onAttach(context)
        arguments?.getInt("lista")?.let {
            parametroTipoLista = it
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = AdapterList(mutableListOf()) { product ->
            interfaceNavigate.navigateTo(DetailsFragment(product))
        }

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        call.clone().enqueue(this)

    }

    override fun onResponse(call: Call<List<Products>>, response: Response<List<Products>>) {
        response.body()?.apply {
            adapter.refresh(this)
        }

    }

    override fun onFailure(call: Call<List<Products>>, t: Throwable) {

        println("falha")
    }


}


