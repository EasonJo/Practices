package com.hencoder.hencoderpracticedraw4.sample

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.hencoder.hencoderpracticedraw4.R

class Sample08MatrixScaleView : View {
    internal var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    internal var bitmap: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)
    internal var point1 = Point(200, 200)
    internal var point2 = Point(600, 200)
    internal var matrix = Matrix()

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val bitmapWidth = bitmap.width
        val bitmapHeight = bitmap.height

        canvas.save()
        matrix.reset()
        matrix.postScale(1.3f, 1.3f, (point1.x + bitmapWidth / 2).toFloat(), (point1.y + bitmapHeight / 2).toFloat())
        canvas.concat(matrix)
        canvas.drawBitmap(bitmap, point1.x.toFloat(), point1.y.toFloat(), paint)
        canvas.restore()

        canvas.save()
        matrix.reset()
        matrix.postScale(0.6f, 1.6f, (point2.x + bitmapWidth / 2).toFloat(), (point2.y + bitmapHeight / 2).toFloat())
        canvas.concat(matrix)
        canvas.drawBitmap(bitmap, point2.x.toFloat(), point2.y.toFloat(), paint)
        canvas.restore()
    }
}
