package com.example.quickbites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val getstarted=findViewById<Button>(R.id.get_started)

        lateinit var auth: FirebaseAuth

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