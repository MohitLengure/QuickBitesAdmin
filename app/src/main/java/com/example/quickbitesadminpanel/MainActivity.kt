package com.example.quickbitesadminpanel

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val getstarted=findViewById<Button>(R.id.get_started)


        /* fun onStart() {
             super.onStart()
             //check if user is already login
             val currentUser: FirebaseUser? = auth.currentUser
             if (currentUser != null) {
                 startActivity(Intent(this, HomePage::class.java))
                 finish()
             }
         }*/

        getstarted.setOnClickListener{
            val intent1= Intent(this, Signup::class.java)
            startActivity(intent1)
            Toast.makeText(this,"Button Clicked", Toast.LENGTH_SHORT).show()
        }
    }
}