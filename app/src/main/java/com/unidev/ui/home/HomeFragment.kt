package com.unidev.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.unidev.R
import com.unidev.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeViewModel: HomeViewModel

    private lateinit var adapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_home, container, false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        binding.homeViewModel = homeViewModel
        binding.lifecycleOwner = this

        binding.fragmentHomeIbEdit.setOnClickListener {
            Toast.makeText(context, "Edit pressed!", Toast.LENGTH_SHORT).show()
        }

        // News
        adapter = NewsAdapter(homeViewModel.news)
        binding.fragmentHomeRvNews.adapter = adapter
        binding.fragmentHomeRvNews.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val pagerSnapHelper = PagerSnapHelper()
        pagerSnapHelper.attachToRecyclerView(binding.fragmentHomeRvNews)
    }
}
