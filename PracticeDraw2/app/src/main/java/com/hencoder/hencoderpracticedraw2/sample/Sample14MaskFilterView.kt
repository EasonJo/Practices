package com.hencoder.hencoderpracticedraw2.sample

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.hencoder.hencoderpracticedraw2.R

class Sample14MaskFilterView : View {
    internal var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    internal var bitmap: Bitmap
    internal var maskFilter1: MaskFilter = BlurMaskFilter(50f, BlurMaskFilter.Blur.NORMAL)
    internal var maskFilter2: MaskFilter = BlurMaskFilter(50f, BlurMaskFilter.Blur.INNER)
    internal var maskFilter3: MaskFilter = BlurMaskFilter(50f, BlurMaskFilter.Blur.OUTER)
    internal var maskFilter4: MaskFilter = BlurMaskFilter(50f, BlurMaskFilter.Blur.SOLID)

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        setLayerType(View.LAYER_TYPE_SOFTWARE, null)
        bitmap = BitmapFactory.decodeResource(resources, R.drawable.what_the_fuck)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        paint.maskFilter = maskFilter1
        canvas.drawBitmap(bitmap, 100f, 50f, paint)

        paint.maskFilter = maskFilter2
        canvas.drawBitmap(bitmap, (bitmap.width + 200).toFloat(), 50f, paint)

        paint.maskFilter = maskFilter3
        canvas.drawBitmap(bitmap, 100f, (bitmap.height + 100).toFloat(), paint)

        paint.maskFilter = maskFilter4
        canvas.drawBitmap(bitmap, (bitmap.width + 200).toFloat(), (bitmap.height + 100).toFloat(), paint)
    }
}
