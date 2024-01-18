package com.example.ecommerceconsept.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ecommerceconsept.R
import com.example.ecommerceconsept.ui.fragments.screenFragments.SelectCategoryFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_container, SelectCategoryFragment())
                .commit()
        }
    }
}