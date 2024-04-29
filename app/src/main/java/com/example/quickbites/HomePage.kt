package com.example.quickbites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.quickbites.databinding.ActivityHomePageBinding
import com.google.android.material.navigation.NavigationView

class HomePage : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var fragmentManager: FragmentManager
    private lateinit var binding: ActivityHomePageBinding
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding=ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val toggle=
            ActionBarDrawerToggle(this,binding.drawerLayout,binding.toolbar,R.string.nav_open,R.string.nav_close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        binding.navigationDrawer.setNavigationItemSelectedListener(this)


        binding.bottomNavigation.background=null
        binding.bottomNavigation.setOnItemSelectedListener{ item->
            when(item.itemId)
            {
                R.id.bottom_home ->openFragment(Home())
                R.id.bottom_order ->openFragment(Order())
                R.id.bottom_search ->openFragment(Search())
                R.id.bottom_offer->openFragment(Offer())
                R.id.bottom_cart->openFragment(Cart())
            }
            true
        }

        fragmentManager=supportFragmentManager
        openFragment(Home())



    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_profile1->openFragment(Profile())
            R.id.nav_logout-> Toast.makeText(this,"Logout Successfully", Toast.LENGTH_LONG).show()
            R.id.nav_Feedback-> Toast.makeText(this,"Feedback", Toast.LENGTH_LONG).show()
            R.id.nav_share-> Toast.makeText(this,"Share", Toast.LENGTH_LONG).show()
            R.id.nav_Contact_Us-> Toast.makeText(this,"Contact", Toast.LENGTH_LONG).show()

        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed()
    { if(binding.drawerLayout.isDrawerOpen(GravityCompat.START))
    {
        binding.drawerLayout.closeDrawer(GravityCompat.START)
    }
    else
    {
        super.onBackPressed()
    }

    }
    private fun openFragment(fragment:Fragment)
    {
        val fragmentTransaction: FragmentTransaction =fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container,fragment)
        fragmentTransaction.commit()
    }
}