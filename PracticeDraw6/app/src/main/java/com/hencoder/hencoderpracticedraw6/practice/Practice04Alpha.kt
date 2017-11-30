package com.hencoder.hencoderpracticedraw6.practice

import android.content.Context
import android.util.AttributeSet
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import com.hencoder.hencoderpracticedraw6.R

class Practice04Alpha : RelativeLayout {
    private lateinit var animateBt: Button
    private lateinit var imageView: ImageView
    private var clickCount = 2
    private var clickIndex = 0

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        animateBt = findViewById(R.id.animateBt) as Button
        imageView = findViewById(R.id.imageView) as ImageView

        animateBt.setOnClickListener {
            // TODO 在这里处理点击事件，通过 View.animate().alpha() 来改变 View 的透明度

            when(clickIndex){
                0-> imageView.animate().alpha(0f)
                1-> imageView.animate().alpha(1f)
            }

            clickIndex++
            if (clickIndex == clickCount)
                clickIndex = 0
        }
    }
}