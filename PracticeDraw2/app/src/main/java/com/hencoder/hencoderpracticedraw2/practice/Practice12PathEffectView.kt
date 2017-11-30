package com.hencoder.hencoderpracticedraw2.practice

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * 使用 PathEffect 来给图形的轮廓设置效果。对 Canvas 所有的图形绘制有效，也就是 drawLine() drawCircle() drawPath() 这些方法。
 */
class Practice12PathEffectView : View {
    private var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var path = Path()
    private val corner = CornerPathEffect(10f)
    private val discretePathEffect = DiscretePathEffect(20f, 5f)
    private val dashEffect = DashPathEffect(floatArrayOf(20f, 10f, 5f, 10f), 10f)
    private val pathDashPathEffect: PathDashPathEffect
    private var sumPathEffect: PathEffect = SumPathEffect(dashEffect, discretePathEffect)
    private var composePathEffect: PathEffect = ComposePathEffect(dashEffect, discretePathEffect)


    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        paint.style = Paint.Style.STROKE

        path.moveTo(50f, 100f)
        path.rLineTo(50f, 100f)
        path.rLineTo(80f, -150f)
        path.rLineTo(100f, 100f)
        path.rLineTo(70f, -120f)
        path.rLineTo(150f, 80f)

        val dashPath = Path()
        dashPath.lineTo(20f, -30f)
        dashPath.lineTo(40f, 0f)
        dashPath.close()
        pathDashPathEffect = PathDashPathEffect(dashPath, 50f, 0f, PathDashPathEffect.Style.MORPH)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // 使用 Paint.setPathEffect() 来设置不同的 PathEffect

        // 第一处：CornerPathEffect, 折角处改成曲线,使用圆角
        paint.pathEffect = corner
        canvas.drawPath(path, paint)

        canvas.save()
        canvas.translate(500f, 0f)
        // 第二处：DiscretePathEffect,随机偏离线条
        paint.pathEffect = discretePathEffect
        canvas.drawPath(path, paint)
        canvas.restore()

        canvas.save()
        canvas.translate(0f, 200f)
        // 第三处：DashPathEffect, 虚线
        paint.pathEffect = dashEffect
        canvas.drawPath(path, paint)
        canvas.restore()

        canvas.save()
        canvas.translate(500f, 200f)
        // 第四处：PathDashPathEffect
        paint.pathEffect = pathDashPathEffect
        canvas.drawPath(path, paint)
        canvas.restore()

        canvas.save()
        canvas.translate(0f, 400f)
        // 第五处：SumPathEffect,组合效果,分别按照两种 pathEffect对目标进行绘制.
        paint.pathEffect = sumPathEffect
        canvas.drawPath(path, paint)
        canvas.restore()

        canvas.save()
        canvas.translate(500f, 400f)
        // 第六处：ComposePathEffect,组合效果,不同于 SumpathEffect, 这种是按照先后顺序依次对目标进行绘制.
        paint.pathEffect = composePathEffect
        canvas.drawPath(path, paint)
        canvas.restore()
    }
}
