package com.unidev.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.NumberPicker
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.PagerSnapHelper
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.unidev.R
import com.unidev.databinding.FragmentHomeBinding

const val MIN_HEIGHT = 70
const val MAX_HEIGHT = 240

const val MIN_WEIGHT = 20
const val MAX_WEIGHT = 240

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
            inflater,
            R.layout.fragment_home,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        binding.homeViewModel = homeViewModel
        binding.lifecycleOwner = this

        // Edit ImageButton
        binding.fragmentHomeIbEdit.setOnClickListener {
            showEditParametersDialog()
        }

        // News
        adapter = NewsAdapter(homeViewModel.news)
        binding.fragmentHomeRvNews.adapter = adapter
        val pagerSnapHelper = PagerSnapHelper()
        pagerSnapHelper.attachToRecyclerView(binding.fragmentHomeRvNews)
    }

    private fun showEditParametersDialog() {
        val dialogView = LayoutInflater.from(context)
            .inflate(R.layout.dialog_parameters_edit, null)

        val npHeight: NumberPicker = dialogView.findViewById(R.id.dialog_parameters_edit__np_height)
        val npWeight: NumberPicker = dialogView.findViewById(R.id.dialog_parameters_edit__np_weight)

        npHeight.minValue = MIN_HEIGHT
        npHeight.maxValue = MAX_HEIGHT
        npHeight.value = homeViewModel.height.value!!

        npWeight.minValue = MIN_WEIGHT
        npWeight.maxValue = MAX_WEIGHT
        npWeight.value = homeViewModel.weight.value!!

        val builder = MaterialAlertDialogBuilder(requireContext())
            .setView(dialogView)

        val alertDialog = builder.show()

        dialogView.findViewById<Button>(R.id.dialog_parameters_edit__btn_save).setOnClickListener {
            alertDialog.dismiss()
            homeViewModel.setParameters(npHeight.value, npWeight.value)
        }
    }
}
