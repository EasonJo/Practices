package com.hencoder.hencoderpracticedraw6.practice

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.widget.Button
import android.widget.ImageView
import com.hencoder.hencoderpracticedraw6.R
import com.hencoder.hencoderpracticedraw6.dp2px

class Practice05MultiProperties : ConstraintLayout {
    private lateinit var animateBt: Button
    private lateinit var imageView: ImageView
    private var clickCount = 2
    private var clickIndex = 0

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        animateBt = findViewById(R.id.animateBt) as Button
        imageView = findViewById(R.id.imageView) as ImageView
        imageView.scaleX = 0f
        imageView.scaleY = 0f
        imageView.alpha = 0f
        animateBt.setOnClickListener {
            // TODO 在这里处理点击事件，同时对多个属性做动画

            when (clickIndex) {
                0 -> with(imageView.animate()) {
                    scaleX(1f)
                    scaleY(1f)
                    rotation(360f)
                    alpha(1f)
                    translationX(200f.dp2px())
                }
                1 -> with(imageView.animate()) {
                    scaleX(0f)
                    scaleY(0f)
                    rotation(0f)
                    alpha(0f)
                    translationX(0f.dp2px())
                }
            }

            clickIndex++
            if (clickIndex == clickCount)
                clickIndex = 0
        }
    }
}
