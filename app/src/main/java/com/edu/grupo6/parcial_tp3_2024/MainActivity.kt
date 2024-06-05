package com.edu.grupo6.parcial_tp3_2024

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.edu.grupo6.parcial_tp3_2024.databinding.ActivityMainBinding
import com.edu.grupo6.parcial_tp3_2024.fragments.HomeFragment
import com.edu.grupo6.parcial_tp3_2024.fragments.OffersFragment
import com.edu.grupo6.parcial_tp3_2024.fragments.ProfileFragment
import com.edu.grupo6.parcial_tp3_2024.fragments.SearchFragment
import com.edu.grupo6.parcial_tp3_2024.fragments.SettingsFragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var toggle : ActionBarDrawerToggle
    private lateinit var binding: ActivityMainBinding
    private lateinit var stickyHeader: View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        stickyHeader = findViewById(R.id.sticky_header)

        replaceFragment(HomeFragment())

        val drawerLayout : DrawerLayout = findViewById(R.id.activity_main)
        val navView : NavigationView = findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.profile -> replaceFragment(ProfileFragment())
                R.id.notification -> Toast.makeText(applicationContext, "Notification", Toast.LENGTH_SHORT).show()
                R.id.get_help -> Toast.makeText(applicationContext, "Get Help", Toast.LENGTH_SHORT).show()
                R.id.calendar -> Toast.makeText(applicationContext, "Calendar", Toast.LENGTH_SHORT).show()
                R.id.settings -> replaceFragment(SettingsFragment())

                else -> { }
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){
                R.id.explore -> replaceFragment(HomeFragment())
                R.id.search -> replaceFragment(SearchFragment())
                R.id.offers -> replaceFragment(OffersFragment())
                R.id.profile -> replaceFragment(ProfileFragment())
            }
            true
        }

        val menuButton: ImageButton = findViewById(R.id.menuButton)
        menuButton.setOnClickListener {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                drawerLayout.openDrawer(GravityCompat.START)
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun replaceFragment(fragment: Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()

        if (fragment is ProfileFragment) {
            stickyHeader.visibility = View.GONE
        } else {
            stickyHeader.visibility = View.VISIBLE
        }
    }
}