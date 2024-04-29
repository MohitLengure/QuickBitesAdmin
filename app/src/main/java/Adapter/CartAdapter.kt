package adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickbites.databinding.CartitemBinding

class CartAdapter (
    private val CartItems:MutableList<String>,
    private val CartItemPrice:MutableList<String>,
    private val CartImage:MutableList<Int>): RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    private val itemQuatities = IntArray(CartItems.size) { 1 }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = CartitemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(binding)
    }


    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = CartItems.size

    inner class CartViewHolder(private val binding: CartitemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                val quantity = itemQuatities[position]
                cartfoodname.text = CartItems[position]
                cartitemprice.text = CartItemPrice[position]
                cartimage.setImageResource(CartImage[position])
                cartItemquantity.text = quantity.toString()

                minusbutton.setOnClickListener {
                    deceaseQuantity(position)
                }
                plusbutton.setOnClickListener {
                    increaseQuantity(position)
                }
                deleteButton.setOnClickListener {
                    val itemPosition = adapterPosition
                    if(itemPosition != RecyclerView.NO_POSITION)
                    {
                        deleteItem(itemPosition)
                    }
                }

            }

        }
        private fun deceaseQuantity(position: Int) {
            if (itemQuatities[position] > 1) {
                itemQuatities[position]--
                binding.cartItemquantity.text = itemQuatities[position].toString()
            }
        }
            private fun increaseQuantity(position: Int) {
                if (itemQuatities[position] < 10) {
                    itemQuatities[position]++
                    binding.cartItemquantity.text = itemQuatities[position].toString()
                }
            }
                private fun deleteItem(position: Int) {
                    CartItems.removeAt(position)
                    CartImage.removeAt(position)
                    CartItemPrice.removeAt(position)
                    notifyItemRangeChanged(position, CartItems.size)
                }
            }


        }

