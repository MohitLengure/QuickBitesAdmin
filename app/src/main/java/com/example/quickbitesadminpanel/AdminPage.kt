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
           val intent1= Intent(this,AddItemActivity::class.java)
           startActivity(intent1)
        }
        binding.allItemMenu.setOnClickListener {
            val intent= Intent(this,AllItemActy::class.java)
            startActivity(intent)
        }
        binding.OrderDispatch.setOnClickListener {
            val intent= Intent(this,OutForDeliveryActivity::class.java)
            startActivity(intent)
        }

    }
}