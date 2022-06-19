package com.mehmedmert.gameofthroneshouses.ui.houses

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mehmedmert.gameofthroneshouses.data.model.House
import com.mehmedmert.gameofthroneshouses.databinding.ItemHouseBinding
import javax.inject.Inject

class HousesAdapter @Inject constructor(
    private val viewModel: HousesViewModel
) : ListAdapter<House, HousesAdapter.HouseViewHolder>(HousesDiff) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HousesAdapter.HouseViewHolder {
        val itemView = ItemHouseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HouseViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HousesAdapter.HouseViewHolder, position: Int) {
        val house = getItem(position)
        holder.binding.apply {
            root.setOnClickListener {
                viewModel.onHouseClicked(getItem(holder.adapterPosition))
            }
            name.text = house.name
            region.text = house.region
            words.text = house.words
        }
    }

    object HousesDiff : DiffUtil.ItemCallback<House>() {
        override fun areItemsTheSame(oldItem: House, newItem: House): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: House, newItem: House): Boolean {
            return oldItem.name == newItem.name &&
                    oldItem.region == newItem.region &&
                    oldItem.words == newItem.words &&
                    oldItem.titles == newItem.titles &&
                    oldItem.seats == newItem.seats &&
                    oldItem.currentLord == oldItem.currentLord
        }
    }

    inner class HouseViewHolder(val binding: ItemHouseBinding) :
        RecyclerView.ViewHolder(binding.root)
}
