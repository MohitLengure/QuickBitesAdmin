package com.example.quickbites


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.quickbites.databinding.ActivityPayOutBinding

class PayOutActivity : AppCompatActivity() {
    lateinit var binding : ActivityPayOutBinding
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityPayOutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backhome.setOnClickListener {
            startActivity(Intent(this,HomePage::class.java))
            finish()
        }

        binding.placemyorder.setOnClickListener {
            startActivity(Intent(this,ordercomplete::class.java))
            finish()
        }
        /*binding.placemyorder.setOnClickListener {
            val bottomSheetDialog = CongBottomSheet()
            bottomSheetDialog.run {
                show(supportFragmentManager,"test")
            }*/
        }


    }





