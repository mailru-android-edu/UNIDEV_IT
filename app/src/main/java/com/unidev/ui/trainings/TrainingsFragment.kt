package com.unidev.ui.trainings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.unidev.R

class TrainingsFragment : Fragment() {

    private val trainings = generateTrainingList().toMutableList()

    var adapter: TrainingAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_trainings, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvTrainingList: RecyclerView = view.findViewById(R.id.rv_training_list)
        adapter = TrainingAdapter(trainings)
        rvTrainingList.adapter = adapter
        rvTrainingList.layoutManager = LinearLayoutManager(activity)
    }

    private fun generateTrainingList(): List<Training> {
        return listOf(
            Training(
                "Понедельник",
                "26 апреля",
                "Силовая тренировка",
                "Высокая",
                "45",
                R.drawable.ic_down_button_fire
            ),
            Training(
                "Вторник",
                "27 апреля",
                "Силовая тренировка",
                "Низкая",
                "20",
                R.drawable.ic_launcher_background
            ),
            Training(
                "Среда",
                "28 апреля",
                "Силовая тренировка",
                "Низкая",
                "15",
                R.drawable.ic_launcher_foreground
            ),
            Training(
                "Четверг",
                "29 апреля",
                "Силовая тренировка",
                "Средняя",
                "40",
                R.drawable.ic_menu_adv
            ),
            Training(
                "Пятница",
                "30 апреля",
                "Силовая тренировка",
                "Средняя",
                "20",
                R.drawable.ic_menu_blog
            ),
            Training(
                "Суббота",
                "1 мая",
                "Силовая тренировка",
                "Высокая",
                "25",
                R.drawable.ic_menu_camera
            ),
            Training(
                "Воскресенье",
                "2 мая",
                "Силовая тренировка",
                "Низкая",
                "35",
                R.drawable.ic_menu_diet
            )
        )
    }
}
