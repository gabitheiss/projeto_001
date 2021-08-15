package com.example.projeto_001.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.projeto_001.R
import com.example.projeto_001.fragments.fragments.LoginCorretoFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       replaceFrag(LoginCorretoFragment())
    }


   fun replaceFrag(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.idContainer, fragment)
            .commitNow()
    }


}




