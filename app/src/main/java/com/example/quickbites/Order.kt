package com.example.quickbites

import adapter.Buyagainadapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickbites.databinding.FragmentOrderBinding


class Order : Fragment() {
    private lateinit var binding: FragmentOrderBinding
    private lateinit var buyAgainadapter: Buyagainadapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOrderBinding.inflate(layoutInflater,container,false)
        setupRecyclerView()
        return binding.root
    }
    private fun setupRecyclerView(){
        val buyAgainFoodName = arrayListOf("Food 2","Food 2","Food 3")
        val buyAgainFoodPrice = arrayListOf("159 ₹","99 ₹"," 149 ₹")
        val buyAgainFoodImage = arrayListOf(R.drawable.thali,R.drawable.pavbhaji,R.drawable.cholebhatore)
        buyAgainadapter= Buyagainadapter(buyAgainFoodName,buyAgainFoodPrice,buyAgainFoodImage)
        binding.buyagainrecycleview.adapter=buyAgainadapter
        binding.buyagainrecycleview.layoutManager=LinearLayoutManager(requireContext())
    }

    companion object
    {

    }

}
