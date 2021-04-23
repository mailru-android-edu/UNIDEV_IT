package com.unidev.presentation.fragments.workout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.unidev.R
import com.unidev.presentation.viewmodels.WorkoutViewModel
import kotlinx.android.synthetic.main.fragment_workout.*

class WorkoutFragment : Fragment() {
    private val workoutViewModel by viewModels<WorkoutViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_workout, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val player = SimpleExoPlayer.Builder(requireContext()).build()
        videoPlayer.player = player
        player.setMediaItem(MediaItem.fromUri(VIDEO_URL))
        player.prepare()
    }

    companion object {
        const val VIDEO_URL =
            "http://10.0.2.2:8762/video/getVideo/5c6b5b5f0eae45bd9bd2a3afa1472020/video.m3u8"
    }
}