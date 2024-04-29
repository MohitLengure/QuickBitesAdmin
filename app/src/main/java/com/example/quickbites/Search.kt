package com.example.quickbites

import adapter.MenuAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickbites.databinding.FragmentSearchBinding


class Search : Fragment() {

    private lateinit var binding:FragmentSearchBinding

    private lateinit var adapter: MenuAdapter


    private val OrignalMenuFoodName= listOf("Burger","Sandwich","Momo","Pizza","Roll","Pav Bhaji","Chloe bhature","Thali","Biryani","Hot Dog")

    private val OrignalMenuItemPrice= listOf("99 ₹","101 ₹","89 ₹","99 ₹","89 ₹","79 ₹","89 ₹","119 ₹","159 ₹","49 ₹")
    private val OrignalMenuImage= listOf(
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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private val filteredMenuFoodName = mutableListOf<String>()
    private val filteredMenuItemPrice = mutableListOf<String>()
    private val filteredMenuImage =  mutableListOf<Int>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentSearchBinding.inflate(inflater,container,false)

        adapter=MenuAdapter(filteredMenuFoodName,filteredMenuItemPrice,filteredMenuImage)
        binding.menuRecycleView.layoutManager=LinearLayoutManager(requireContext())
        binding.menuRecycleView.adapter=adapter


        //setup for search view
        setupSearchView()

        //show all menu item
        showAllmMenu()
        return binding.root
    }

    private fun showAllmMenu() {
        filteredMenuFoodName.clear()
        filteredMenuItemPrice.clear()
        filteredMenuImage.clear()

        filteredMenuFoodName.addAll(OrignalMenuFoodName)
        filteredMenuItemPrice.addAll(OrignalMenuItemPrice)
        filteredMenuImage.addAll(OrignalMenuImage)

        adapter.notifyDataSetChanged()
    }

    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object:SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {

                override fun onQueryTextSubmit(query: String): Boolean {
                    filterMenuItem(query)
                    return true
                }


            override fun onQueryTextChange(newText: String): Boolean {
                filterMenuItem(newText)
                return true
            }
        })

    }

    private fun filterMenuItem(query: String) {
        filteredMenuFoodName.clear()
        filteredMenuItemPrice.clear()
        filteredMenuImage.clear()

        OrignalMenuFoodName.forEachIndexed { index, foodName ->
            if(foodName.contains(query,ignoreCase = true)){
                filteredMenuFoodName.add(foodName)
                filteredMenuItemPrice.add(OrignalMenuItemPrice[index])
                filteredMenuImage.add(OrignalMenuImage[index])
            }
        }
        adapter.notifyDataSetChanged()

    }

    companion object {

    }
}