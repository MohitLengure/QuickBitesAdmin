package com.example.quickbitesadminpanel

import Model.AllMenu
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.quickbitesadminpanel.databinding.ActivityAddItemBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage

class AddItemActivity : AppCompatActivity() {


    //Food Item Details
    private lateinit var foodName:String
    private lateinit var foodPrice:String
    private lateinit var foodDescription:String
    private lateinit var foodIngredient:String
    private  var foodImageUri: Uri?= null


    //firebase
    private lateinit var auth:FirebaseAuth
    private lateinit var database:FirebaseDatabase


    private val binding: ActivityAddItemBinding by lazy {
        ActivityAddItemBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        //Initialize firebase
        auth=FirebaseAuth.getInstance()

        //Initialize firebase database instance
        database=FirebaseDatabase.getInstance()

        binding.AddItembutton.setOnClickListener {

            //Get data from Filed
            foodName=binding.FoodName.text.toString().trim()
            foodPrice=binding.foodPrice.text.toString().trim()
            foodDescription=binding.description.text.toString().trim()
            foodIngredient=binding.ingredint.text.toString().trim()

            if(!(foodName.isBlank()||foodPrice.isBlank()||foodDescription.isBlank()||foodIngredient.isBlank()))
            {
                uploadData()
                Toast.makeText(this,"Item Added Successfully",Toast.LENGTH_SHORT).show()
                finish()
            }
            else
            {
                Toast.makeText(this,"Fill All the Details",Toast.LENGTH_SHORT).show()
            }

        }
        binding.Selectedimage.setOnClickListener {
            pickImage.launch("image/*")
        }



        binding.backbutton.setOnClickListener {
            val intent= Intent(this,AdminPage::class.java)
            startActivity(intent)
        }

    }

    private fun uploadData() {
       //get a reference to the "menu" node in the database
        val menuRef:DatabaseReference=database.getReference("menu")
        //genrate a unique key for the new menu item
        val newItemKey=menuRef.push().key


        if(foodImageUri !=null){
            val storageRef= FirebaseStorage.getInstance().reference
            val imageRef=storageRef.child("menu_images/${newItemKey}.jpg")
            val uploadTask=imageRef.putFile(foodImageUri!!)

            uploadTask.addOnSuccessListener {
                imageRef.downloadUrl.addOnSuccessListener {
                    downloadUrl->

                    //Create a new menu Item
                    val newItem=AllMenu(
                        foodName=foodName,
                        foodPrice=foodPrice,
                        foodDescription=foodDescription,
                        foodIngredient=foodIngredient,
                        foodImage = downloadUrl.toString(),
                    )
                    newItemKey?.let{
                        key->
                        menuRef.child(key).setValue(newItem).addOnSuccessListener{
                            Toast.makeText(this,"Data Uploaded Successfully",Toast.LENGTH_SHORT).show()
                        }

                    }
                }

            }.addOnFailureListener{
                Toast.makeText(this,"Data Uploaded Failed",Toast.LENGTH_SHORT).show()
            }

        } else {
            Toast.makeText(this,"Please Select an Image",Toast.LENGTH_SHORT).show()
        }

    }

    private val pickImage= registerForActivityResult(ActivityResultContracts.GetContent())
    { uri ->
        if(uri != null)
        {
            binding.Selectedimage.setImageURI(uri)
            foodImageUri=uri
        }
    }

}