package com.hencoder.hencoderpracticedraw7.practice.practice03

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PointF
import android.util.AttributeSet
import android.view.View

import com.hencoder.hencoderpracticedraw7.dpToPixel

class Practice03OfObjectView : View {

    private var paint = Paint(Paint.ANTI_ALIAS_FLAG)

    private var position = PointF()

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        paint.color = Color.parseColor("#009688")
    }

    fun getPosition(): PointF {
        return position
    }


    fun setPosition(position: PointF?) {
        if (position != null) {
            this.position.set(position)
            invalidate()
        }
    }

    public override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val innerPaddingLeft = RADIUS * 1
        val innterPaddingRight = RADIUS * 1
        val innterPaddingTop = RADIUS * 1
        val innterPaddingBottom = RADIUS * 3
        val width = width.toFloat() - innerPaddingLeft - innterPaddingRight - RADIUS * 2
        val height = height.toFloat() - innterPaddingTop - innterPaddingBottom - RADIUS * 2

        canvas.drawCircle(innerPaddingLeft + RADIUS + width * position.x, innterPaddingTop + RADIUS + height * position.y, RADIUS, paint)
    }

    companion object {
        val RADIUS = dpToPixel(20f)
    }
}
