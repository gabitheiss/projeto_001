package com.example.projeto_001.fragments.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.projeto_001.R
import com.example.projeto_001.fragments.MainActivity

class LoginCorretoFragment : Fragment((R.layout.fragment_login_correto)) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.buttonLogin)?.apply {
            setOnClickListener {
                (requireActivity() as MainActivity).replaceFrag(ProductFragment())
            }
        }
    }


}