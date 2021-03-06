package com.hencoder.hencoderpracticedraw2.sample

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

class Sample10StrokeJoinView : View {
    internal var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    internal var path = Path()

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        paint.strokeWidth = 40f
        paint.style = Paint.Style.STROKE

        path.rLineTo(200f, 0f)
        path.rLineTo(-160f, 120f)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.save()

        canvas.translate(100f, 100f)
        paint.strokeJoin = Paint.Join.MITER
        canvas.drawPath(path, paint)

        canvas.translate(300f, 0f)
        paint.strokeJoin = Paint.Join.BEVEL
        canvas.drawPath(path, paint)

        canvas.translate(300f, 0f)
        paint.strokeJoin = Paint.Join.ROUND
        canvas.drawPath(path, paint)

        canvas.restore()
    }
}
