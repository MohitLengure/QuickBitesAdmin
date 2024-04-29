package adapter

import android.icu.text.Transliterator.Position
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickbites.databinding.MenuitemBinding

class MenuAdapter(private val menuItemsName:MutableList<String>,private val menuItemPrice:MutableList<String>,private val MenuImage:MutableList<Int>): RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding=MenuitemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MenuViewHolder(binding)
    }



    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {

        holder.bind(position)
    }
    override fun getItemCount(): Int=menuItemsName.size
    inner class MenuViewHolder (private val binding: MenuitemBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(position: Int){
            binding.apply {
                menuFoodName.text=menuItemsName[position]
                menuprice.text=menuItemPrice[position]
                menuImage.setImageResource(MenuImage[position])
            }
        }

    }
}