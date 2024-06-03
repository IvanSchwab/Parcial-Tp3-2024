package com.edu.grupo6.parcial_tp3_2024

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.edu.grupo6.parcial_tp3_2024.databinding.ActivityMainBinding
import com.edu.grupo6.parcial_tp3_2024.fragments.HomeFragment
import com.edu.grupo6.parcial_tp3_2024.fragments.OffersFragment
import com.edu.grupo6.parcial_tp3_2024.fragments.ProfileFragment
import com.edu.grupo6.parcial_tp3_2024.fragments.SearchFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())

        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){
                R.id.explore -> replaceFragment(HomeFragment())
                R.id.search -> replaceFragment(SearchFragment())
                R.id.offers -> replaceFragment(OffersFragment())
                R.id.profile -> replaceFragment(ProfileFragment())

                else -> { }
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}