package com.unidev.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.unidev.R
import com.unidev.databinding.FragmentWorkoutBinding
import com.unidev.presentation.activities.MainActivity
import com.unidev.presentation.viewmodels.WorkoutViewModel

class WorkoutFragment : Fragment(), View.OnTouchListener {
    private var _binding: FragmentWorkoutBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<WorkoutViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWorkoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.setOnTouchListener { v, event -> false }

        val player = SimpleExoPlayer.Builder(requireContext()).build()
        binding.videoPlayer.player = player
        player.setMediaItem(MediaItem.fromUri(VIDEO_URL))
        player.prepare()

        binding.button.setOnClickListener {
            (requireActivity() as MainActivity).fabHide()
        }

        binding.button.setOnTouchListener(this)
    }

    override fun onStart() {
        super.onStart()
        (requireActivity() as MainActivity).fabSetIcon(R.drawable.ic_format_list_bulleted_square)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        Log.d("CustomButton", "onTouch()!")
        return false
    }

    companion object {
        const val VIDEO_URL =
            "http://10.0.2.2:8762/video/getVideo/5c6b5b5f0eae45bd9bd2a3afa1472020/video.m3u8"
    }
}