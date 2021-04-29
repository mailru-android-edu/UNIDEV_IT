package com.unidev.ui.trainings

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.unidev.R

class TrainingAdapter(private val trainings: List<Training>) :
    RecyclerView.Adapter<TrainingAdapter.TrainingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrainingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.training_item, parent, false)
        return TrainingViewHolder(view)
    }

    override fun onBindViewHolder(holder: TrainingViewHolder, position: Int) {
        val training = trainings[position]
        holder.bind(training)
    }

    override fun getItemCount(): Int = trainings.size

    class TrainingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val tvDayOfWeek: TextView = itemView.findViewById(R.id.training_item__tv_dayofweek)
        private val tvDayOfMonth: TextView = itemView.findViewById(R.id.training_item__tv_dayofmonth)
        private val tvName: TextView = itemView.findViewById(R.id.training_item__tv_name)
        private val tvDifficulty: TextView = itemView.findViewById(R.id.training_item__tv_difficulty)
        private val tvDescription: TextView = itemView.findViewById(R.id.training_item__tv_time)
        private val ivPoster: ImageView = itemView.findViewById(R.id.training_item__iv_poster)

        init {
            itemView.setOnClickListener {
                Toast.makeText(
                    itemView.context,
                    "TODO",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        fun bind(training: Training) {
            with(training) {
                tvDayOfWeek.text = dayOfWeek
                tvDayOfMonth.text = dayOfMonth
                tvName.text = name
                tvDifficulty.text = "Сложность: $difficulty"
                tvDescription.text = "$time минут"
                ivPoster.setImageResource(picture)
            }
        }
    }
}
