package com.example.quickbitesadminpanel

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.quickbitesadminpanel.databinding.ActivityAddItemBinding

class AddItemActivity : AppCompatActivity() {
    private val binding: ActivityAddItemBinding by lazy {
        ActivityAddItemBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
        binding.SelectImage.setOnClickListener{
            pickimage.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
        }


        binding.backbutton.setOnClickListener {
            val intent= Intent(this,AdminPage::class.java)
            startActivity(intent)
        }

    }
    private val pickimage= registerForActivityResult(ActivityResultContracts.PickVisualMedia())
    { uri ->
        if(uri != null)
        {
            binding.SelectedImage.setImageURI(uri)
        }
    }
}