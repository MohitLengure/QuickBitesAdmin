package com.example.quickbites

import adapter.usermodel
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.quickbites.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class Signup : AppCompatActivity() {


    private lateinit var username: String
    private lateinit var email: String
    private lateinit var password: String
    private lateinit var password1: String
    private lateinit var phone: String
    private lateinit var auth: FirebaseAuth
    private lateinit var database:DatabaseReference


    private lateinit var binding:ActivitySignupBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //initialize firebase auth
        auth= FirebaseAuth.getInstance()
        database= Firebase.database.reference




        binding.signupButton.setOnClickListener{


            username=binding.signupName.text.toString().trim()
            email=binding.signupEmail.text.toString().trim()
            phone=binding.signupPhone.text.toString().trim()
            password=binding.Password.text.toString().trim()
            password1=binding.RetypePassword.text.toString().trim()




            //check if any field is black
            if(username.isEmpty()||email.isEmpty()||phone.isEmpty()||password.isEmpty()||password1.isEmpty())
            {
                Toast.makeText(this,"Please Fill All The Details", Toast.LENGTH_SHORT).show()
            }
            else
                if(password != password1)
                {
                    Toast.makeText(this,"Repeat Password is not match", Toast.LENGTH_SHORT).show()
                }
                else
                {
                    auth.createUserWithEmailAndPassword(email,password)
                        .addOnCompleteListener(this){ task ->
                            if(task.isSuccessful)
                            {
                                Toast.makeText(this,"Registration Successful", Toast.LENGTH_SHORT).show()
                                startActivity(Intent(this,LoginPage::class.java))
                                saveUserData()
                                finish()
                            }
                            else
                            {
                                Toast.makeText(this,"Registration Failed: ${task.exception?.message}",
                                    Toast.LENGTH_SHORT).show()
                            }

                        }
                }


        }
        binding.loginRedirectText.setOnClickListener{
            startActivity(Intent(this,LoginPage::class.java))
            finish()
            Toast.makeText(this,"Button Clicked", Toast.LENGTH_SHORT).show()
        }



    }
//save data into database
    private fun saveUserData() {
        username=binding.signupName.text.toString().trim()
        email=binding.signupEmail.text.toString().trim()
        phone=binding.signupPhone.text.toString().trim()
        password=binding.Password.text.toString().trim()
        val user=usermodel(username,email,phone,password)
        val userId = FirebaseAuth.getInstance().currentUser!!.uid
        database.child("user").child(userId).setValue(user)

    }
}