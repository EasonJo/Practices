package com.hencoder.hencoderpracticedraw1.practice

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View

/**
 * 画直方图
 */
class Practice10HistogramView : View {

    private val pointY = 500 - 4
    private val pointX = 50
    private val rm_width = 100
    private val dx = 20
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val path = Path()

    private var rmss = mutableListOf<RectMode>()

    init {
        rmss.addAll(initRectMode())
    }

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)


    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) :
            super(context, attrs, defStyleAttr)


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        //综合练习
        //练习内容：使用各种 Canvas.drawXXX() 方法画直方图

        paint.style = Paint.Style.STROKE
        paint.color = Color.WHITE
        paint.strokeWidth = 5f
        path.moveTo(50f, 20f)
        path.lineTo(50f, 500f)
        path.rLineTo(900f, 0f)

        canvas.drawPath(path, paint)

        canvas.drawRectMode(rmss)

        //canvas.drawRect(RectMode(100, 200, "Eason").xsRect(0), paint)

    }


    private fun Canvas.drawRectMode(rms: List<RectMode>) {

        if (rms.isEmpty()) Log.i("eason", "rsm is empty")

        for (i in rms.indices) {
            val rm = rms[i]
            val rc = rm.xsRect(i)

            paint.color = Color.GREEN
            paint.style = Paint.Style.FILL
            drawRect(rc, paint)

            paint.color = Color.WHITE
            paint.textSize = 20f
            val textWidth = paint.measureText(rm.name)
            drawText(rm.name, rc.left.toFloat() + (rc.width() - textWidth) / 2, pointY.toFloat() + 30f, paint)
        }
    }


    private fun initRectMode(): List<RectMode> {

        val froyo = RectMode(rm_width, 10, "Froyo")
        val gb = RectMode(rm_width, 102, "GB")
        val ics = RectMode(rm_width, 442, "ICS")
        val jb = RectMode(rm_width, 130, "JB")
        val kitkat = RectMode(rm_width, 255, "KITCAT")
        val l = RectMode(rm_width, 120, "L")
        val m = RectMode(rm_width, 5523, "M")

        return listOf(froyo, gb, ics, jb, kitkat, l, m)
    }

    private inner class RectMode(val w: Int, val h: Int, val name: String) {

        fun xsRect(index: Int) = Rect(pointX + dx + index * (w + dx), pointY - h,
                pointX + (index + 1) * (dx + w), pointY)
    }
}
