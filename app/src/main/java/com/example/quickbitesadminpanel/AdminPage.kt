package com.example.quickbitesadminpanel

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.quickbitesadminpanel.databinding.ActivityAdminPageBinding

class AdminPage : AppCompatActivity() {
    private val binding:ActivityAdminPageBinding by lazy {
        ActivityAdminPageBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.addMenu.setOnClickListener {
            val intent= Intent(this,Additem::class.java)
            startActivity(intent)
        }
        binding.allItemMenu.setOnClickListener {
            val intent= Intent(this,Allitemactivity::class.java)
            startActivity(intent)
        }
    }
}