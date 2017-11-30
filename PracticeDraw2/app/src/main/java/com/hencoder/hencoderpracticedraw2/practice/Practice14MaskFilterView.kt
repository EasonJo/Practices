package com.hencoder.hencoderpracticedraw2.practice

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.hencoder.hencoderpracticedraw2.R

/**
 * 在绘制层上方附加效果.shadowlayer是在绘制层下方附加效果
 */
class Practice14MaskFilterView : View {
    private var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var bitmap: Bitmap
    private val normal = BlurMaskFilter(50f, BlurMaskFilter.Blur.NORMAL)
    private val inner = BlurMaskFilter(50f, BlurMaskFilter.Blur.INNER)
    private val outer = BlurMaskFilter(50f, BlurMaskFilter.Blur.OUTER)
    private val solid = BlurMaskFilter(50f, BlurMaskFilter.Blur.SOLID)

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        setLayerType(View.LAYER_TYPE_SOFTWARE, null)
        bitmap = BitmapFactory.decodeResource(resources, R.drawable.what_the_fuck)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // 用 Paint.setMaskFilter 来设置不同的 BlurMaskFilter

        // 第一个：NORMAL
        paint.maskFilter = normal
        canvas.drawBitmap(bitmap, 100f, 50f, paint)

        // 第二个：INNER
        paint.maskFilter = inner
        canvas.drawBitmap(bitmap, (bitmap.width + 200).toFloat(), 50f, paint)

        // 第三个：OUTER
        paint.maskFilter = outer
        canvas.drawBitmap(bitmap, 100f, (bitmap.height + 100).toFloat(), paint)

        // 第四个：SOLID
        paint.maskFilter = solid
        canvas.drawBitmap(bitmap, (bitmap.width + 200).toFloat(), (bitmap.height + 100).toFloat(), paint)
    }
}
