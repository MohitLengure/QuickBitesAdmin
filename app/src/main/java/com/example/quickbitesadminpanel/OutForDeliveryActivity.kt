package com.example.quickbitesadminpanel

import adapter.DeliveryAdapter
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickbitesadminpanel.databinding.ActivityAllItemActyBinding
import com.example.quickbitesadminpanel.databinding.ActivityOutForDeliveryBinding

class OutForDeliveryActivity : AppCompatActivity() {
    private val binding: ActivityOutForDeliveryBinding by lazy {
        ActivityOutForDeliveryBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val customerName= arrayListOf(
            "Mohit Lengure",
            "Prashant Meshran",
            "Pratik Vishwakarma",
        )
        val moneyStatus = arrayListOf(
            "Received",
            "NotReceived",
            "Pending",
        )
        val adapter=DeliveryAdapter(customerName,moneyStatus)
        binding.DeliveryRecyclerView.adapter=adapter
        binding.DeliveryRecyclerView.layoutManager=LinearLayoutManager(this)


        binding.backbutton1.setOnClickListener {
            val intent= Intent(this,AdminPage::class.java)
            startActivity(intent)
        }

    }
}