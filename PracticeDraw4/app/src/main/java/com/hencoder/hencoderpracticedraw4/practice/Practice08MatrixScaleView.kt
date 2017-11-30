package com.hencoder.hencoderpracticedraw4.practice

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.hencoder.hencoderpracticedraw4.R

/**
 * 使用 matrix 实现缩放
 */
class Practice08MatrixScaleView : View {
    internal var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    internal var bitmap: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)
    internal var point1 = Point(200, 200)
    internal var point2 = Point(600, 200)
    private val mt = Matrix()

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.save()
        mt.reset()
        mt.preScale(1.5f, 1.5f, (point1.x + bitmap.width / 2).toFloat(), (point1.y + bitmap.height / 2).toFloat())
        canvas.concat(mt)
        canvas.drawBitmap(bitmap, point1.x.toFloat(), point1.y.toFloat(), paint)
        canvas.restore()

        canvas.save()
        mt.reset()
        mt.preScale(0.6f, 1.6f, (point2.x + bitmap.width / 2).toFloat(), (point2.y + bitmap.height / 2).toFloat())
        canvas.concat(mt)
        canvas.drawBitmap(bitmap, point2.x.toFloat(), point2.y.toFloat(), paint)
        canvas.restore()
    }
}
