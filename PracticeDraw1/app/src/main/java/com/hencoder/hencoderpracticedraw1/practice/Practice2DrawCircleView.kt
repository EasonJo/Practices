package com.hencoder.hencoderpracticedraw1.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class Practice2DrawCircleView : View {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        //        练习内容：使用 canvas.drawCircle() 方法画圆
        //        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆
        //实心圆
        paint.color = Color.BLACK
        paint.style = Paint.Style.FILL
        canvas.drawCircle(100f, 100f, 50f, paint)

        //空心圆
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 2f
        canvas.drawCircle(210f, 100f, 50f, paint)

        //蓝色实心圆
        paint.color = Color.BLUE
        paint.style = Paint.Style.FILL
        canvas.drawCircle(350f, 100f, 50f, paint)


        //线宽为20的空心圆
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 20f
        paint.color = Color.BLACK
        canvas.drawCircle(200f, 250f, 50f, paint)
    }
}
