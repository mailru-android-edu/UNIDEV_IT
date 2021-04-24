package com.unidev.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.unidev.R
import com.unidev.presentation.viewmodels.TrainingsViewModel

class TrainingsFragment : Fragment() {

    private lateinit var trainingsViewModel: TrainingsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        trainingsViewModel =
            ViewModelProvider(this).get(TrainingsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_trainings, container, false)
        val textView: TextView = root.findViewById(R.id.text_trainings)
        trainingsViewModel.text.observe(
            viewLifecycleOwner,
            Observer {
                textView.text = it
            }
        )
        return root
    }
}
