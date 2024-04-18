package com.example.quickbitesadminpanel

import Model.AllMenu
import adapter.MenuItemAdapter
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickbitesadminpanel.databinding.ActivityAllItemActyBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class AllItemActy : AppCompatActivity() {

    private lateinit var databaseReference: DatabaseReference
    private lateinit var database: FirebaseDatabase
    private var menuItems:ArrayList<AllMenu> = ArrayList()


    private val binding: ActivityAllItemActyBinding by lazy {
        ActivityAllItemActyBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        databaseReference=FirebaseDatabase.getInstance().reference
        retrieveMenuItem()




        binding.backbutton1.setOnClickListener {
            val intent= Intent(this,AdminPage::class.java)
            startActivity(intent)
        }


    }

    private fun retrieveMenuItem() {
        database= FirebaseDatabase.getInstance()
        val foodRef:DatabaseReference=database.reference.child("menu")

        //fetch data from database
        foodRef.addListenerForSingleValueEvent(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                //clear Existing Data before populating
                menuItems.clear()

                //loop for through each food item

                for(foodSnapshot in snapshot.children){
                    val menuItem=foodSnapshot.getValue(AllMenu::class.java)
                    menuItem?.let{
                        menuItems.add(it)
                    }
                }
                setAdapter()
            }

            override fun onCancelled(error: DatabaseError) {
                Log.d("Database Error","Error: ${error.message}")
            }


        })
    }
    private fun setAdapter() {
        val adapter= MenuItemAdapter(this@AllItemActy,menuItems,databaseReference)
        binding.MenuRecylerView.layoutManager= LinearLayoutManager(this)
        binding.MenuRecylerView.adapter=adapter
    }
}