package com.hencoder.hencoderpracticedraw4.practice

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import com.hencoder.hencoderpracticedraw4.R

class Practice13CameraRotateHittingFaceView : View {
    private var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var bitmap: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)
    private var point = Point(200, 50)
    private var camera = Camera()
    private var mt = Matrix()
    private var degree: Int = 0
    private var animator = ObjectAnimator.ofInt(this, "degree", 0, 360)

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        val scaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.width * 2, bitmap.height * 2,
                true)
        bitmap.recycle()
        bitmap = scaledBitmap

        animator.duration = 5000
        animator.interpolator = LinearInterpolator()
        animator.repeatCount = ValueAnimator.INFINITE

        //屏幕像素密度 * 6,计算出 Z轴坐标.注意方向
        val newZ = -resources.displayMetrics.density * 6
        //沿着 Z 轴移动,
        camera.setLocation(0f, 0f, newZ)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        animator.start()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        animator.end()
    }

    fun setDegree(degree: Int) {
        this.degree = degree
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val centerX = point.x + bitmap.width / 2
        val centerY = point.y + bitmap.height / 2


        with(camera) {
            save()
            mt.reset()
            rotateX(degree.toFloat())
            getMatrix(mt)
            restore()
        }

        with(mt) {
            preTranslate((-centerX).toFloat(), (-centerY).toFloat())
            postTranslate(centerX.toFloat(), centerY.toFloat())
        }

        with(canvas) {
            save()
            concat(mt)
            drawBitmap(bitmap, point.x.toFloat(), point.y.toFloat(), paint)
            restore()
        }

    }
}