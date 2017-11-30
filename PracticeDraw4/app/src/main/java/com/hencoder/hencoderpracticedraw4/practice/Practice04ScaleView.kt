package com.hencoder.hencoderpracticedraw4.practice

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.hencoder.hencoderpracticedraw4.R

class Practice04ScaleView : View {
    private var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var bitmap: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)
    private var point1 = Point(200, 200)
    private var point2 = Point(600, 200)

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.save()
        //沿着图片中间放大操作
        canvas.scale(1.3f, 1.3f, (point1.x + bitmap.width / 2).toFloat(), (point1.y + bitmap.height / 2).toFloat())
        canvas.drawBitmap(bitmap, point1.x.toFloat(), point1.y.toFloat(), paint)
        canvas.restore()

        canvas.save()
        //非等比例的缩放操作
        canvas.scale(0.6f, 1.6f, (point2.x + bitmap.width / 2).toFloat(), (point2.y + bitmap.height / 2).toFloat())
        canvas.drawBitmap(bitmap, point2.x.toFloat(), point2.y.toFloat(), paint)
        canvas.restore()
    }
}
