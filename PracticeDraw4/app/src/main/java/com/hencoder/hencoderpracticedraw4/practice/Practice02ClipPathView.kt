package com.hencoder.hencoderpracticedraw4.practice

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.hencoder.hencoderpracticedraw4.R

class Practice02ClipPathView : View {
    private var paint = Paint()
    private var bitmap: Bitmap
    private var point1 = Point(200, 200)
    private var point2 = Point(600, 200)
    private val path1 = Path()
    private val path2 = Path()

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)
        path1.addCircle((point1.x + 200).toFloat(), (point1.y + 200).toFloat(), 150f, Path.Direction.CW)

        path2.fillType = Path.FillType.INVERSE_WINDING
        path2.addCircle((point2.x + 200).toFloat(), (point2.y + 200).toFloat(), 150f, Path.Direction.CW)

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        with(canvas) {
            save()
            clipPath(path1)
            drawBitmap(bitmap, point1.x.toFloat(), point1.y.toFloat(), paint)
            restore()

            save()
            clipPath(path2)
            drawBitmap(bitmap, point2.x.toFloat(), point2.y.toFloat(), paint)
            restore()
        }
    }
}
