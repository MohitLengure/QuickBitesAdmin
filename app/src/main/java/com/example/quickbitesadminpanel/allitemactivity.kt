package com.example.quickbitesadminpanel


import Adapter.AdditemAdapter
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickbitesadminpanel.databinding.ActivityAllitemactivityBinding

class Allitemactivity: AppCompatActivity() {
    private val binding: ActivityAllitemactivityBinding by lazy {
        ActivityAllitemactivityBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_allitemactivity)
        val menuFoodName= listOf("Burger","Sandwich","Momo","Pizza","Roll")
        val menuItemPrice= listOf("99 ₹","101 ₹","89 ₹","99 ₹","89 ₹")
        val menuImage= listOf(
            R.drawable.burger,
            R.drawable.sandwich,
            R.drawable.momos,
            R.drawable.pizza,
            R.drawable.roll
        )
        val adapter= AdditemAdapter(ArrayList(menuFoodName),ArrayList(menuItemPrice),ArrayList(menuImage))
        binding.MenuRecylerView.layoutManager=LinearLayoutManager(this)
        binding.MenuRecylerView.adapter=adapter

        binding.backbutton1.setOnClickListener {
            val intent= Intent(this,AdminPage::class.java)
            startActivity(intent)
        }


    }
}