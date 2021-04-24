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
import com.unidev.presentation.viewmodels.MotivationViewModel

class MotivationFragment : Fragment() {

    private lateinit var motivationViewModel: MotivationViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        motivationViewModel =
            ViewModelProvider(this).get(MotivationViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_motivation, container, false)
        val textView: TextView = root.findViewById(R.id.text_motivation)
        motivationViewModel.text.observe(
            viewLifecycleOwner,
            Observer {
                textView.text = it
            }
        )
        return root
    }
}
