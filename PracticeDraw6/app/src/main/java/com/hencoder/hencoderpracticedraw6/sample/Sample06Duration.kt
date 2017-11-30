package com.hencoder.hencoderpracticedraw6.sample

import android.content.Context
import android.util.AttributeSet
import android.widget.*
import com.hencoder.hencoderpracticedraw6.R
import com.hencoder.hencoderpracticedraw6.dpToPixel

class Sample06Duration : LinearLayout {
    private lateinit var durationSb: SeekBar
    private lateinit var durationValueTv: TextView
    private lateinit var animateBt: Button
    private lateinit var imageView: ImageView

    private var duration = 300
    private var translationState = 0

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        durationSb = findViewById(R.id.durationSb) as SeekBar
        durationValueTv = findViewById(R.id.durationValueTv) as TextView
        durationValueTv.text = context.getString(R.string.ms_with_value, duration)
        durationSb.max = 10
        durationSb.progress = 1
        durationSb.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                duration = progress * 300
                durationValueTv.text = context.getString(R.string.ms_with_value, duration)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {

            }
        })

        animateBt = findViewById(R.id.animateBt) as Button
        imageView = findViewById(R.id.imageView) as ImageView
        animateBt.setOnClickListener {
            when (translationState) {
                0 -> imageView.animate().translationX(dpToPixel(200f)).duration = duration.toLong()
                1 -> imageView.animate().translationX(0f).duration = duration.toLong()
            }
            if (translationState < 1) {
                translationState++
            } else {
                translationState = 0
            }
        }
    }
}
