package com.example.quickbites

import adapter.CartAdapter
import adapter.MenuAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickbites.databinding.FragmentMenuBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class MenuBottomSheetFragment : BottomSheetDialogFragment() {

    private lateinit var binding:FragmentMenuBottomSheetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentMenuBottomSheetBinding.inflate(inflater,container,false)

        binding.buttonBack.setOnClickListener {
            dismiss()
        }

        val MenuFoodName= listOf("Burger","Sandwich","Momo","Pizza","Roll","Pav Bhaji","Chloe bhature","Thali","Biryani","Hot Dog")
        val MenuItemPrice= listOf("99 ₹","101 ₹","89 ₹","99 ₹","89 ₹","79 ₹","89 ₹","119 ₹","159 ₹","49 ₹")
        val MenuImage= listOf(
            R.drawable.burger,
            R.drawable.sandwich,
            R.drawable.momos,
            R.drawable.pizza,
            R.drawable.roll,
            R.drawable.pavbhaji,
            R.drawable.cholebhatore,
            R.drawable.thali,
            R.drawable.biryani,
            R.drawable.hotdogs,
        )
        val adapter= MenuAdapter(
            ArrayList(MenuFoodName),
            ArrayList(MenuItemPrice),
            ArrayList(MenuImage))
        binding.menuRecycleView.layoutManager= LinearLayoutManager(requireContext())
        binding.menuRecycleView.adapter=adapter
        return binding.root
    }


    companion object {

    }
}