package com.hencoder.hencoderpracticedraw1.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class Practice6DrawLineView : View {

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    private val paint = Paint()
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        //练习内容：使用 canvas.drawLine() 方法画直线
        paint.strokeWidth = 5f
        canvas.drawLine(0f, 0f, 50f, 50f, paint)





        val points = floatArrayOf(20f, 20f, 120f, 20f, 70f, 20f, 70f, 120f, 20f, 120f, 120f, 120f, 150f, 20f, 250f,
                20f, 150f, 20f, 150f, 120f, 250f, 20f, 250f, 120f, 150f, 120f, 250f, 120f)


        canvas.drawLines(points, paint)
    }
}
