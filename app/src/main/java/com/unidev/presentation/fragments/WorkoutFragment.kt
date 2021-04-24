package com.unidev.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.unidev.databinding.FragmentWorkoutBinding
import com.unidev.presentation.viewmodels.WorkoutViewModel

class WorkoutFragment : Fragment() {
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

        val player = SimpleExoPlayer.Builder(requireContext()).build()
        binding.videoPlayer.player = player
        player.setMediaItem(MediaItem.fromUri(VIDEO_URL))
        player.prepare()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val VIDEO_URL =
            "http://10.0.2.2:8762/video/getVideo/5c6b5b5f0eae45bd9bd2a3afa1472020/video.m3u8"
    }
}