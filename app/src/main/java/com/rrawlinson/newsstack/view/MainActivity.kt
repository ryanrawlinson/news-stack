package com.rrawlinson.newsstack.view

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.rrawlinson.newsstack.R
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val host = supportFragmentManager.findFragmentById(R.id.host_nav_fragment) as NavHostFragment? ?: return

        setupBottomNavigation(host.navController)
    }

    private fun setupBottomNavigation(navController: NavController) {
        findViewById<BottomNavigationView>(R.id.bottom_navigation).let { bottomNavigationView ->
            NavigationUI.setupWithNavController(bottomNavigationView, navController)
        }
    }
}
