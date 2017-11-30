package com.hencoder.hencoderpracticedraw4.practice

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.hencoder.hencoderpracticedraw4.R

/**
 * 使用 Camera 实现旋转
 */
class Practice11CameraRotateView : View {
    private var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var bitmap: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)
    private var point1 = Point(200, 100)
    private var point2 = Point(600, 200)
    private val camera = Camera()

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        with(camera) {
            save()
            rotateX(30f)//X轴旋转30°
            applyToCanvas(canvas)
            restore()
        }

        with(canvas) {
            save()
            drawBitmap(bitmap, point1.x.toFloat(), point1.y.toFloat(), paint)
            restore()
        }

        with(camera) {
            save()
            rotateY(30f) //Y轴旋转30°
            applyToCanvas(canvas)
            restore()
        }

        with(canvas) {
            save()
            drawBitmap(bitmap, point2.x.toFloat(), point2.y.toFloat(), paint)
            restore()
        }
    }
}
