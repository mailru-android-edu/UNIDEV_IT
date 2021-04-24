package com.unidev.presentation.fragments

import androidx.fragment.app.Fragment
import com.unidev.presentation.activities.INavigator

abstract class AbstractFragment : Fragment() {
    fun navigator(): INavigator {
        var navigator = parentFragment as? INavigator

        if (navigator == null) {
            navigator = requireActivity() as? INavigator
        }

        return navigator!!
    }
}