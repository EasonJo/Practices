package com.hencoder.hencoderpracticedraw4.practice

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.hencoder.hencoderpracticedraw4.R

class Practice12CameraRotateFixedView : View {
    private var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var bitmap: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)
    private var point1 = Point(200, 200)
    private var point2 = Point(600, 200)
    private val camera = Camera()
    private val mt = Matrix()

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val center1X: Float = (point1.x + bitmap.width / 2).toFloat()
        val center1Y: Float = (point1.y + bitmap.height / 2).toFloat()
        val center2X: Float = (point2.x + bitmap.width / 2).toFloat()
        val center2Y: Float = (point2.y + bitmap.height / 2).toFloat()

        with(canvas) {

            with(camera) {
                save()
                rotateX(30f)
                mt.reset()
                getMatrix(mt)
                restore()
            }

            //使用 Matrix 来来组合几何变换,这里使用 pre和 post 来操作.需要注意的是这里的移动并不是移动坐标系,而是移动画布
            //我在这里犯过一个理解错误,误将移动理解为坐标系的移动.
            with(mt) {
                //将画布移动到圆心, 在开始旋转之前
                preTranslate(-center1X, -center1X)
                //将画布移动到原始位置,在旋转之后
                postTranslate(center1X, center1Y)
            }

            save()
            concat(mt)
            drawBitmap(bitmap, point1.x.toFloat(), point1.y.toFloat(), paint)
            restore()

            with(camera) {
                save()
                rotateY(30f)
                mt.reset()
                getMatrix(mt)
                restore()
            }

            with(mt) {
                preTranslate(-center2X, -center2Y)
                postTranslate(center2X, center2Y)
            }

            save()
            concat(mt)
            drawBitmap(bitmap, point2.x.toFloat(), point2.y.toFloat(), paint)
            restore()
        }

    }
}
