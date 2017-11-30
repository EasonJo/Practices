package com.hencoder.hencoderpracticedraw2.practice

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.hencoder.hencoderpracticedraw2.R

/**
 * 模拟光照的效果
 */
class Practice06LightingColorFilterView : View {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var bitmap: Bitmap? = null
    private var colorFilter1: ColorFilter = LightingColorFilter(0x00ffff, 0x000000)
    private var colorFilter2: ColorFilter = LightingColorFilter(0xffffff, 0x003000)

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        bitmap = BitmapFactory.decodeResource(resources, R.drawable.batman)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // 使用 Paint.setColorFilter() 来设置 LightingColorFilter

        paint.colorFilter = colorFilter1
        // 第一个 LightingColorFilter：去掉红色部分
        canvas.drawBitmap(bitmap!!, 0f, 0f, paint)

        // 第二个 LightingColorFilter：增强绿色部分
        paint.colorFilter = colorFilter2
        canvas.drawBitmap(bitmap!!, (bitmap!!.width + 100).toFloat(), 0f, paint)
    }
}
