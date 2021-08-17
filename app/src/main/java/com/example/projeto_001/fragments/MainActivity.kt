package com.example.projeto_001.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.projeto_001.R
import com.example.projeto_001.fragments.fragments.LoginCorretoFragment
import com.example.projeto_001.fragments.model.Navigation
import com.example.projeto_001.fragments.model.Products

class MainActivity : AppCompatActivity(), Navigation {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)
        getSupportActionBar()?.setHomeButtonEnabled(true)
        getSupportActionBar()?.setTitle("Voltar")


        replaceFrag(LoginCorretoFragment(this))
    }


    fun replaceFrag(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.idContainer, fragment)
            .commitNow()
    }


    override fun navigateTo(fragment: Fragment) {
        val transition: FragmentTransaction = supportFragmentManager
            .beginTransaction()
            .replace(R.id.idContainer, fragment)
        transition.commitNow()
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }


}




