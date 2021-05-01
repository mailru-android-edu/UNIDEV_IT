package com.unidev.presentation

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent

class CustomButton(context: Context, attributeSet: AttributeSet?) :
    androidx.appcompat.widget.AppCompatButton(context, attributeSet) {

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.d("CustomButton", "onTouchEvent()")
        return true
    }
}