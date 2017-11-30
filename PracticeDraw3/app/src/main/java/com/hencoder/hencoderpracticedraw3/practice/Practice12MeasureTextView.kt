package com.hencoder.hencoderpracticedraw3.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class Practice12MeasureTextView : View {
    private var paint1 = Paint(Paint.ANTI_ALIAS_FLAG)
    private var paint2 = Paint(Paint.ANTI_ALIAS_FLAG)
    private var text1 = "三个月内你胖了"
    private var text2 = "4.5"
    private var text3 = "公斤"
    private val measuredText1: Float
    private val measuredText2: Float

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        paint1.textSize = 60f
        paint2.textSize = 120f
        paint2.color = Color.parseColor("#E91E63")
        measuredText1 = paint1.measureText(text1)
        measuredText2 = paint2.measureText(text2)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // 使用 Paint.measureText 测量出文字宽度，让文字可以相邻绘制

        canvas.drawText(text1, 50f, 200f, paint1)
        canvas.drawText(text2, 50 + measuredText1, 200f, paint2)
        canvas.drawText(text3, 50 + measuredText1 + measuredText2, 200f, paint1)
    }
}
