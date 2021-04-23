package com.unidev.presentation.fragments.adv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.unidev.R

class AdvFragment : Fragment() {

    private lateinit var advViewModel: AdvViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        advViewModel =
            ViewModelProvider(this).get(AdvViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_adv, container, false)
        val textView: TextView = root.findViewById(R.id.text_adv)
        advViewModel.text.observe(
            viewLifecycleOwner,
            Observer {
                textView.text = it
            }
        )
        return root
    }
}
