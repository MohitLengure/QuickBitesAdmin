package com.example.quickbites

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import adapter.CartAdapter
import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickbites.databinding.FragmentCartBinding


class Cart : Fragment() {
    private lateinit var binding:FragmentCartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentCartBinding.inflate(inflater,container,false)

        val cartFoodName= listOf("Burger","Sandwich","Momo","Roll")
        val cartItemPrice= listOf("99Rs","101Rs","89Rs","99Rs")
        val cartImage= listOf(
            R.drawable.burger,
            R.drawable.sandwich,
            R.drawable.momos,
            R.drawable.roll
        )
        val adapter=CartAdapter(ArrayList(cartFoodName),ArrayList(cartItemPrice),ArrayList(cartImage))
        binding.cardrecylerview.layoutManager=LinearLayoutManager(requireContext())
        binding.cardrecylerview.adapter=adapter

        binding.Processedbutton.setOnClickListener {
            val intent = Intent(requireContext(),PayOutActivity::class.java)
            startActivity(intent)
        }

        return binding.root
    }

    companion object {

    }
}
