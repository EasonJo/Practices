package com.hencoder.hencoderpracticedraw3.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.text.Layout
import android.text.StaticLayout
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View

/**
 * 使用[StaticLayout] 来绘制带有换行符的字符
 */
class Practice02StaticLayoutView : View {
    private var textPaint = TextPaint(Paint.ANTI_ALIAS_FLAG)
    private var text = "Hello\nHenCoder"
    private val staticLayout: StaticLayout

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        textPaint.textSize = 60f
        staticLayout = StaticLayout(text, textPaint, 600, Layout.Alignment.ALIGN_NORMAL, 1f,
                0f, true)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)


        // 使用 StaticLayout 代替 Canvas.drawText() 来绘制文字，
        // 以绘制出带有换行的文字
//        canvas.drawText(text, 50f, 100f, textPaint)
        canvas.save()
        canvas.translate(50f, 40f)
        staticLayout.draw(canvas)
        canvas.restore()
    }
}
