package com.hencoder.hencoderpracticedraw1.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class Practice5DrawOvalView : View {

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    private val paint = Paint()
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        //        练习内容：使用 canvas.drawOval() 方法画椭圆


        //val rf = RectF(10f, 10f, 220f, 220f)
        //canvas.drawOval(rf, paint)
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 10f
        canvas.drawOval(10f,20f,400f,200f,paint)
    }
}
