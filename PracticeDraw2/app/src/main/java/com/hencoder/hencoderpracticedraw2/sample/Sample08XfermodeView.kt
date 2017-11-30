package com.hencoder.hencoderpracticedraw2.sample

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.hencoder.hencoderpracticedraw2.R

class Sample08XfermodeView : View {
    internal var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    internal var bitmap1: Bitmap
    internal var bitmap2: Bitmap
    internal var xfermode1: Xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC)
    internal var xfermode2: Xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_IN)
    internal var xfermode3: Xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_OUT)

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        bitmap1 = BitmapFactory.decodeResource(resources, R.drawable.batman)
        bitmap2 = BitmapFactory.decodeResource(resources, R.drawable.batman_logo)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val saved = canvas.saveLayer(null, null, Canvas.ALL_SAVE_FLAG)

        canvas.drawBitmap(bitmap1, 0f, 0f, paint)
        paint.xfermode = xfermode1
        canvas.drawBitmap(bitmap2, 0f, 0f, paint)
        paint.xfermode = null

        canvas.drawBitmap(bitmap1, (bitmap1.width + 100).toFloat(), 0f, paint)
        paint.xfermode = xfermode2
        canvas.drawBitmap(bitmap2, (bitmap1.width + 100).toFloat(), 0f, paint)
        paint.xfermode = null

        canvas.drawBitmap(bitmap1, 0f, (bitmap1.height + 20).toFloat(), paint)
        paint.xfermode = xfermode3
        canvas.drawBitmap(bitmap2, 0f, (bitmap1.height + 20).toFloat(), paint)
        paint.xfermode = null

        canvas.restoreToCount(saved)
    }
}
