package com.jacksiro.prioritybot.ui.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jacksiro.prioritybot.R
import com.jacksiro.prioritybot.data.models.TodoModel
import com.jacksiro.prioritybot.databinding.ItemPriorityBinding
import java.text.SimpleDateFormat
import java.util.*

class TodoAdapter(val list: List<TodoModel>) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemId(position: Int): Long {
        return list[position].id
    }

    class TodoViewHolder(private val binding: ItemPriorityBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(todoModel: TodoModel) {
            //val colors = resources.getIntArray(R.array.random_color)
            //val randomColor = colors[Random().nextInt(colors.size)]
            //binding.viewColorTag.setBackgroundColor(randomColor)
            binding.txtShowTitle.text = todoModel.title
            binding.txtShowTask.text = todoModel.description
            binding.txtShowCategory.text = todoModel.category
            updateTime(todoModel.time)
            updateDate(todoModel.date)
        }

        private fun updateTime(time: Long) {
            //Mon, 5 Jan 2020
            val myformat = "h:mm a"
            val sdf = SimpleDateFormat(myformat)
            binding.txtShowTime.text = sdf.format(Date(time))

        }

        private fun updateDate(time: Long) {
            //Mon, 5 Jan 2020
            val myformat = "EEE, d MMM yyyy"
            val sdf = SimpleDateFormat(myformat)
            binding.txtShowDate.text = sdf.format(Date(time))

        }
    }

}

