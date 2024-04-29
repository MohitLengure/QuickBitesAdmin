package com.example.quickbites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.quickbites.databinding.ActivityLoginPageBinding
import com.google.firebase.auth.FirebaseAuth

class LoginPage : AppCompatActivity() {
    private val binding: ActivityLoginPageBinding by lazy {
        ActivityLoginPageBinding.inflate(layoutInflater)
    }

    private lateinit var auth: FirebaseAuth




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //initialize
        auth= FirebaseAuth.getInstance()



        binding.LoginButton.setOnClickListener{

            val username=binding.loginUsername.text.toString()
            val password=binding.loginPassword.text.toString()

            if(username.isEmpty()||password.isEmpty())
            {
                Toast.makeText(this,"Please Fill All The Details", Toast.LENGTH_SHORT).show()
            }
            else
            {
                auth.signInWithEmailAndPassword(username,password)
                    .addOnCompleteListener {task->

                        if (task.isSuccessful){
                            Toast.makeText(this,"Login Successful", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this,HomePage::class.java))
                            finish()
                        }
                        else
                            if (task.isCanceled)
                            {
                                Toast.makeText(this,"Login Details Incorrect", Toast.LENGTH_SHORT).show()
                            }
                            else{
                                Toast.makeText(this,"Login Failed: ${task.exception?.message}",
                                    Toast.LENGTH_SHORT).show()
                            }
                    }
            }

        }
        binding.signupRedirectText.setOnClickListener{
            startActivity(Intent(this,Signup::class.java))
            finish()
        }


        binding.forgotPassword.setOnClickListener{
            startActivity(Intent(this,ForgotPassword::class.java))
            finish()
        }






    } }