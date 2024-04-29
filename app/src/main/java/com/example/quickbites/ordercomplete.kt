package com.example.quickbites

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.quickbites.databinding.ActivityOrdercompleteBinding


class ordercomplete : AppCompatActivity() {
    private val binding: ActivityOrdercompleteBinding by lazy {
        ActivityOrdercompleteBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Inflate the layout for this fragment

        binding.Gohome.setOnClickListener{
            startActivity(Intent(this,HomePage::class.java))
            finish()
        }


    }
    }
