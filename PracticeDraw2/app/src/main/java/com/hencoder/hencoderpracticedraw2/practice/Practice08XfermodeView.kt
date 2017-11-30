package com.hencoder.hencoderpracticedraw2.practice

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.hencoder.hencoderpracticedraw2.R


/**
 * 使用 xfermode 来处理多层图形叠加绘制的逻辑.这种方式和 ComposeShader 类似,不过 ComposeShader 只能处理两种 Shader 叠加的模式.
 * 而 xferMode 更加灵活,可以处理多个图片.
 */
class Practice08XfermodeView : View {
    private var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var bitmap1: Bitmap
    private var bitmap2: Bitmap
    private val xferMode1 = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
    private val xferMode2 = PorterDuffXfermode(PorterDuff.Mode.DST_IN)
    private val xferMode3 = PorterDuffXfermode(PorterDuff.Mode.DST_OUT)

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        bitmap1 = BitmapFactory.decodeResource(resources, R.drawable.batman)
        bitmap2 = BitmapFactory.decodeResource(resources, R.drawable.batman_logo)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // 使用 paint.setXfermode() 设置不同的结合绘制效果
        // 别忘了用 canvas.saveLayer() 开启 off-screen buffer

        val saved = canvas.saveLayer(null, null, Canvas.ALL_SAVE_FLAG)

        canvas.drawBitmap(bitmap1, 0f, 0f, paint)
        paint.xfermode = xferMode1
        // 第一个：PorterDuff.Mode.SRC
        canvas.drawBitmap(bitmap2, 0f, 0f, paint)
        paint.xfermode = null

        canvas.drawBitmap(bitmap1, (bitmap1.width + 100).toFloat(), 0f, paint)
        // 第二个：PorterDuff.Mode.DST_IN
        paint.xfermode = xferMode2
        canvas.drawBitmap(bitmap2, (bitmap1.width + 100).toFloat(), 0f, paint)
        paint.xfermode = null

        canvas.drawBitmap(bitmap1, 0f, (bitmap1.height + 20).toFloat(), paint)
        // 第三个：PorterDuff.Mode.DST_OUT
        paint.xfermode = xferMode3
        canvas.drawBitmap(bitmap2, 0f, (bitmap1.height + 20).toFloat(), paint)
        paint.xfermode = null

        // 用完之后使用 canvas.restore() 恢复 off-screen buffer
        canvas.restoreToCount(saved)
    }
}
