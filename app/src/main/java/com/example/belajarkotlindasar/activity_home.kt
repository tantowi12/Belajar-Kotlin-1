package com.example.belajarkotlindasar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_home.*

class activity_home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        bottom_nav1.setOnNavigationItemSelectedListener(BottomNav)

        var fr = supportFragmentManager.beginTransaction()
        fr.add(R.id.fl_fragment1, HomeFragment())
        fr.commit()
    }

    private val BottomNav = BottomNavigationView.OnNavigationItemSelectedListener { i ->

        var selectedFr: Fragment = HomeFragment()

        when(i.itemId) {
            R.id.menu_home -> {
                selectedFr = HomeFragment()
            }
            R.id.menu_location -> {
                selectedFr = LocationFragment()
            }
            R.id.menu_account -> {
                selectedFr = AccountFragment()
            }
        }
        var fr = supportFragmentManager.beginTransaction()
        fr.replace(R.id.fl_fragment1, selectedFr)
        fr.commit()

        true
    }
}