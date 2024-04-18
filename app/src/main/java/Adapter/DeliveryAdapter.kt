package adapter

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickbitesadminpanel.databinding.DeliveryitemBinding

class DeliveryAdapter(private val CustomerNames:ArrayList<String>,private val MoneyStatus:ArrayList<String>):RecyclerView.Adapter<DeliveryAdapter.DeliveryViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeliveryViewHolder {
        val binding=DeliveryitemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DeliveryViewHolder(binding)
    }



    override fun onBindViewHolder(holder: DeliveryViewHolder, position: Int) {
        holder.bind(position)
    }
    override fun getItemCount(): Int =CustomerNames.size
    inner class DeliveryViewHolder (private val binding:DeliveryitemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(position: Int) {
            binding.apply {
                CustomerName.text=CustomerNames[position]
                NotRecevied.text=MoneyStatus[position]
                val colorMap=mapOf(
                    "Received" to Color.GREEN,"NotReceived" to Color.RED,"Pending" to Color.GRAY
                )
                NotRecevied.setTextColor(colorMap[MoneyStatus[position]]?:Color.BLACK)
                statuscolor.backgroundTintList=
                    ColorStateList.valueOf(colorMap[MoneyStatus[position]]?:Color.BLACK)
            }

        }

    }
}