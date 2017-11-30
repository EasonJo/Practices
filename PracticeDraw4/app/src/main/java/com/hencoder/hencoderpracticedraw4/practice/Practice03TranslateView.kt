package com.hencoder.hencoderpracticedraw4.practice

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.hencoder.hencoderpracticedraw4.R

/**
 * 在 canvas 移动的含义是移动画布.而不是移动画笔,也就是说,所有的移动效果其实是在 bitmap 已经画上去之后
 */
class Practice03TranslateView : View {
    private var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var bitmap: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)
    private var point1 = Point(200, 200)
    private var point2 = Point(600, 200)

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        with(canvas) {
            save()
            translate(-100f, -100f)
            drawBitmap(bitmap, point1.x.toFloat(), point1.y.toFloat(), paint)
            restore()


            save()
            translate(200f,0f)
            drawBitmap(bitmap, point2.x.toFloat(), point2.y.toFloat(), paint)
            restore()
        }
    }
}