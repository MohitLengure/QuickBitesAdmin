package adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickbites.databinding.BuyAgainItemBinding

class Buyagainadapter(private val  buyAgainFoodName: ArrayList<String>,
                      private val buyAgainFoodPrice: ArrayList<String>,
                      private val buyAgainFoodImage: ArrayList<Int>): RecyclerView.Adapter<Buyagainadapter.BuyAgainViewHolder>(){

    override fun onBindViewHolder(holder: BuyAgainViewHolder, position: Int) {
       holder.bind(buyAgainFoodName[position],buyAgainFoodPrice[position],buyAgainFoodImage[position])
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuyAgainViewHolder {
        val binding = BuyAgainItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return BuyAgainViewHolder(binding)
    }

    override fun getItemCount(): Int = buyAgainFoodName.size


    class BuyAgainViewHolder (private val binding: BuyAgainItemBinding) : RecyclerView.ViewHolder(binding.root)
    {
        fun bind(foodName: String, foodPrice: String, foodImage: Int) {
            binding.buyagainfoodname.text=foodName
            binding.buyagainfoodprice.text=foodPrice
            binding.buyagainfoodimage.setImageResource(foodImage)
        }

    }


}