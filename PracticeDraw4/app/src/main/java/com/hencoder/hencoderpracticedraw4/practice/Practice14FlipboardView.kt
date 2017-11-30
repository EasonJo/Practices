package com.hencoder.hencoderpracticedraw4.practice

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import com.hencoder.hencoderpracticedraw4.R

/**
 * 翻页效果展示
 */
class Practice14FlipboardView : View {
    private var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var bitmap: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)
    private var camera = Camera()
    private var degree: Int = 0
    private var animator = ObjectAnimator.ofInt(this, "degree", 0, 180)
    private val mt = Matrix()
    private val x1 = 400f
    private val y1 = 100f

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {

        animator.duration = 2500
        animator.interpolator = LinearInterpolator()
        animator.repeatCount = ValueAnimator.INFINITE
        animator.repeatMode = ValueAnimator.REVERSE
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

        val centerX: Float = x1 + bitmap.width / 2
        val centerY: Float = y1 + bitmap.height / 2

        mt.reset()
        with(camera) {
            save()
            rotateX(degree.toFloat())
            getMatrix(mt)
            restore()
        }

        //绕着中心点旋转,这里主要是配合 Camera 做旋转效果
        with(mt) {
            preTranslate(-centerX, -centerY)
            postTranslate(centerX, centerY)
        }

        //绘制上半部分
        with(canvas) {
            save()
            //canvas.concat(mt)
            //直接截取 Canvas 的上半部分
            clipRect(x1, y1, x1 + bitmap.width, y1 + (bitmap.height / 2))
            drawBitmap(bitmap, x1, y1, paint)
            restore()
        }

        //绘制下半部分
        with(canvas) {
            save()
            concat(mt)//还是对 canvas 进行 camera 效果处理,所以其坐标点并不改变
            //截取 canvas 的下半部分.这里截取的 canvas 画布,而不是 bitmap
            clipRect(x1, centerY, x1 + bitmap.width, y1 + bitmap.height)
            drawBitmap(bitmap, x1, y1, paint)
            restore()
        }
    }
}
