package com.unidev.ui.diet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.unidev.R

class DietFragment : Fragment() {

    private lateinit var dietViewModel: DietViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        dietViewModel =
                ViewModelProvider(this).get(DietViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_diet, container, false)
        val textView: TextView = root.findViewById(R.id.text_diet)
        dietViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}