package com.hencoder.hencoderpracticedraw1.practice

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View


/**
 * 练习画饼状图
 */
class Practice11PieChartView : View {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val rcf = RectF(100f, 100f, 600f, 600f)
    private val linePath = Path()

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        //综合练习
        //练习内容：使用各种 Canvas.drawXXX() 方法画饼图

        paint.style = Paint.Style.FILL
        paint.color = Color.YELLOW
        canvas.drawArc(rcf, 0f, -45f, true, paint)

        paint.color = Color.RED
        canvas.save()
        //rcf.offset(-15f, -25f)
        val x = 10f * Math.sin((135/2).toDouble())


        canvas.translate(-15f,-25f)
        canvas.drawArc(rcf, -45f, -135f, true, paint)
        canvas.restore()

        //rcf.offset(15f, 25f)

        paint.color = Color.BLUE
        canvas.drawArc(rcf, -180f, -100f, true, paint)

        paint.color = Color.LTGRAY
        canvas.drawArc(rcf, 2f, 10f, true, paint)

        paint.color = Color.GREEN
        canvas.drawArc(rcf, 12f, 20f, true, paint)

        paint.color = Color.CYAN
        canvas.drawArc(rcf, 35f, 40f, true, paint)

    }


    private fun Canvas.drawMode(mode: Modes) {
        paint.color = mode.color
        drawArc(rcf, mode.startAngle, mode.sweepAngle, true, paint)

    }


    /**
     * 封装扇形区域
     */
    private class Modes(val startAngle: Float, val sweepAngle: Float, val color: Int, val name: String) {
        internal val path = Path()


    }

}
