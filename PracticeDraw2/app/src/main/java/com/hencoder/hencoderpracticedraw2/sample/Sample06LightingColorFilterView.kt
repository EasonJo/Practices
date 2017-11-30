package com.hencoder.hencoderpracticedraw2.sample

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.hencoder.hencoderpracticedraw2.R

class Sample06LightingColorFilterView : View {
    internal var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    internal var bitmap: Bitmap
    internal var colorFilter1: ColorFilter = LightingColorFilter(0x00ffff, 0x000000)
    internal var colorFilter2: ColorFilter = LightingColorFilter(0xffffff, 0x003000)

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        bitmap = BitmapFactory.decodeResource(resources, R.drawable.batman)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        paint.colorFilter = colorFilter1
        canvas.drawBitmap(bitmap, 0f, 0f, paint)

        paint.colorFilter = colorFilter2
        canvas.drawBitmap(bitmap, (bitmap.width + 100).toFloat(), 0f, paint)
    }
}
