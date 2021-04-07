package com.unidev.ui.blog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.unidev.R

class BlogFragment : Fragment() {

    private lateinit var blogViewModel: BlogViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        blogViewModel =
                ViewModelProvider(this).get(BlogViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_blog, container, false)
        val textView: TextView = root.findViewById(R.id.text_blog)
        blogViewModel.text.observe(
                viewLifecycleOwner,
                Observer {
                    textView.text = it
                }
        )
        return root
    }
}
