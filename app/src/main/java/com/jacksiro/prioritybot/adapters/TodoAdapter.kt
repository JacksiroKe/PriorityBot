package com.jacksiro.prioritybot.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jacksiro.prioritybot.R
import com.jacksiro.prioritybot.data.models.TodoModel
import com.jacksiro.prioritybot.databinding.ItemPriorityBinding
import java.text.SimpleDateFormat
import java.util.*

class TodoAdapter(val list: List<TodoModel>) : ListAdapter<TodoModel, TodoAdapter.TodoViewHolder>(TodoDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(ItemPriorityBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class TodoViewHolder(private val binding: ItemPriorityBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(todoModel: TodoModel) {
            binding.txtShowTitle.text = todoModel.title
            binding.txtShowTask.text = todoModel.description
            binding.txtShowCategory.text = todoModel.category
        }
    }

    object TodoDiffUtil : DiffUtil.ItemCallback<TodoModel>() {
        override fun areItemsTheSame(oldItem: TodoModel, newItem: TodoModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: TodoModel, newItem: TodoModel): Boolean {
            return oldItem.title == newItem.title
        }

    }

}