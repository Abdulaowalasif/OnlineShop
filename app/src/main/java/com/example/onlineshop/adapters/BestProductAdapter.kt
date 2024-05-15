package com.example.onlineshop.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshop.activities.DetailsActivity

import com.example.onlineshop.databinding.BestProductBinding
import com.example.onlineshop.models.BestProductModel

class BestProductAdapter :
    ListAdapter<BestProductModel, BestProductAdapter.BestProductViewHolder>(DiffUtil()) {
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestProductViewHolder {
        context = parent.context
        val binding = BestProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BestProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BestProductViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra("image", item.image)
            intent.putExtra("price", item.price)
            intent.putExtra("title", item.title)
            intent.putExtra("rating", item.rating)
            context.startActivity(intent)
        }
    }

    class BestProductViewHolder(val binding: BestProductBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(bestProduct: BestProductModel) {
            binding.title.text = bestProduct.title
            binding.rating.text = bestProduct.rating
            binding.price.text = bestProduct.price
            binding.image.setImageResource(bestProduct.image)
        }
    }

    class DiffUtil : androidx.recyclerview.widget.DiffUtil.ItemCallback<BestProductModel>() {
        override fun areItemsTheSame(
            oldItem: BestProductModel,
            newItem: BestProductModel
        ): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(
            oldItem: BestProductModel,
            newItem: BestProductModel
        ): Boolean {
            return oldItem == newItem
        }

    }
}