package com.mehmedmert.gameofthroneshouses.ui.houseDetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mehmedmert.gameofthroneshouses.databinding.ItemHeadline5TextBinding

class TextAdapter : ListAdapter<String, TextAdapter.TextViewHolder>(TextDiff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        val binding =
            ItemHeadline5TextBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TextViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        holder.binding.text.text = getItem(position)
    }

    object TextDiff : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return false
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return false
        }
    }

    inner class TextViewHolder(val binding: ItemHeadline5TextBinding) :
        RecyclerView.ViewHolder(binding.root)
}
