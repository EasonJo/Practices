package com.hencoder.hencoderpracticedraw6.practice

import android.content.Context
import android.util.AttributeSet
import android.widget.*
import com.hencoder.hencoderpracticedraw6.R
import com.hencoder.hencoderpracticedraw6.dp2px

class Practice06Duration : LinearLayout {
    private lateinit var durationSb: SeekBar
    private lateinit var durationValueTv: TextView
    private lateinit var animateBt: Button
    private lateinit var imageView: ImageView

    private var duration = 300
    private var clickCount = 2
    private var clickIndex = 0


    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

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
            // TODO 在这里处理点击事件，执行动画。记得使用 `setDuration(duration)` 来设置动画的时长。

            when (clickIndex) {
                0 -> with(imageView.animate()) {
                    duration = this@Practice06Duration.duration.toLong()
                    translationX(200f.dp2px())
                }
                1 -> with(imageView.animate()) {
                    duration = this@Practice06Duration.duration.toLong()
                    translationX(0f)
                }
            }

            clickIndex++
            if (clickIndex == clickCount)
                clickIndex = 0
        }
    }
}
