package com.example.onlineshop.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshop.R
import com.example.onlineshop.databinding.CategoryViewholderBinding
import com.example.onlineshop.models.CategoryModel

class CategoryAdapter() : ListAdapter<CategoryModel, CategoryAdapter.ViewHolder>(DiffUtil()) {

    var lastSelectedPosition = -1
    var selectedPosition = -1
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val binding =
            CategoryViewholderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = getItem(position)
        holder.bind(category)
        holder.itemView.setOnClickListener {
            if (selectedPosition == position) {
                lastSelectedPosition = selectedPosition
                selectedPosition = -1
                notifyItemChanged(lastSelectedPosition)
            } else {
                lastSelectedPosition = selectedPosition
                selectedPosition = position
                notifyItemChanged(lastSelectedPosition)
                notifyItemChanged(selectedPosition)
            }
        }

        if (selectedPosition == position) {
            holder.itemView.background = context.getDrawable(R.drawable.selected_category_bg)
            holder.binding.title.setTextColor(context.getColor(R.color.white))
            holder.binding.title.visibility = View.VISIBLE
        } else {
            holder.itemView.background = context.getDrawable(R.drawable.un_selected_category_bg)
            holder.binding.title.visibility = View.GONE
        }
    }

    class ViewHolder(val binding: CategoryViewholderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(categoryModel: CategoryModel) {
            binding.image.setImageResource(categoryModel.image)
            binding.title.text = categoryModel.title
        }

    }

    class DiffUtil : androidx.recyclerview.widget.DiffUtil.ItemCallback<CategoryModel>() {
        override fun areItemsTheSame(oldItem: CategoryModel, newItem: CategoryModel): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: CategoryModel, newItem: CategoryModel): Boolean {
            return oldItem == newItem
        }
    }
}
