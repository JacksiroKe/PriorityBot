package com.jacksiro.prioritybot.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jacksiro.prioritybot.R
import com.jacksiro.prioritybot.data.models.TodoModel
import com.jacksiro.prioritybot.databinding.ItemPriorityBinding
import java.text.SimpleDateFormat
import java.util.*

class SomeAdapter(val list: List<TodoModel>) : RecyclerView.Adapter<SomeAdapter.SomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SomeViewHolder {
        TODO()
        //return SomeViewHolder(LayoutInflater.from(parent.context.inflate(R.layout.item_priority, parent, false)))
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: SomeViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemId(position: Int): Long {
        return list[position].id
    }

    class SomeViewHolder(private val binding: ItemPriorityBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(TodoModel: TodoModel) {
            //val colors = resources.getIntArray(R.array.random_color)
            //val randomColor = colors[Random().nextInt(colors.size)]
            //binding.viewColorTag.setBackgroundColor(randomColor)
            binding.txtShowTitle.text = TodoModel.title
            binding.txtShowTask.text = TodoModel.description
            binding.txtShowCategory.text = TodoModel.category
            updateTime(TodoModel.time)
            updateDate(TodoModel.date)
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

