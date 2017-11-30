package com.hencoder.hencoderpracticedraw5.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.LinearLayout

open class Practice03OnDrawLayout : LinearLayout {
    internal var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    internal var pattern = Pattern()

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        // 在这里插入 setWillNotDraw(false) 以启用完整的绘制流程
        setWillNotDraw(false)
        //出于效率的考虑，ViewGroup 默认会绕过 draw() 方法，换而直接执行 dispatchDraw()，以此来简化绘制流程。所以如果你自定义了某个
        // ViewGroup 的子类（比如 LinearLayout）并且需要在它的除  dispatchDraw() 以外的任何一个绘制方法内绘制内容，你可能会需要调用
        // View.setWillNotDraw(false) 这行代码来切换到完整的绘制流程（是「可能」而不是「必须」的原因是，有些 ViewGroup 是已经调用过
        // setWillNotDraw(false) 了的，例如 ScrollView）。
    }



    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        pattern.draw(canvas)
    }

    internal inner class Pattern {
        private val PATTERN_RATIO = 5f / 6
        private var patternPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        private var spots: Array<Spot?> = arrayOfNulls(size = 4)

        init {
            patternPaint.color = Color.parseColor("#A0E91E63")
            spots[0] = Spot(0.24f, 0.3f, 0.026f)
            spots[1] = Spot(0.69f, 0.25f, 0.067f)
            spots[2] = Spot(0.32f, 0.6f, 0.067f)
            spots[3] = Spot(0.62f, 0.78f, 0.083f)
        }

        fun draw(canvas: Canvas) {
            val repitition = Math.ceil((width.toFloat() / height).toDouble()).toInt()

            for (i in 0 until spots.size * repitition) {
                val spot = spots[i % spots.size]
                canvas.drawCircle((i / spots.size).toFloat() * height.toFloat() * PATTERN_RATIO +
                        spot!!.relativeX * height, spot.relativeY * height,
                        spot.relativeSize * height, patternPaint)
            }
        }

        internal inner class Spot(val relativeX: Float, val relativeY: Float, val relativeSize: Float)
    }
}
