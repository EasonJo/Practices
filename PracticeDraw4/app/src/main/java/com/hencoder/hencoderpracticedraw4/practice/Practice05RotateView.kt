package com.hencoder.hencoderpracticedraw4.practice

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.hencoder.hencoderpracticedraw4.R

/**
 * canvas 的旋转操作
 */
class Practice05RotateView : View {
    private var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var bitmap: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)
    private var point1 = Point(200, 200)
    private var point2 = Point(600, 200)

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val w: Float = (bitmap.width / 2).toFloat()
        val h: Float = (bitmap.height / 2).toFloat()

        with(canvas) {
            save()
            rotate(180f, point1.x + w, point1.y + h)
            drawBitmap(bitmap, point1.x.toFloat(), point1.y.toFloat(), paint)
            restore()

            save()
            rotate(45f, point2.x + w, point2.y + h)
            drawBitmap(bitmap, point2.x.toFloat(), point2.y.toFloat(), paint)
            restore()
        }
    }
}