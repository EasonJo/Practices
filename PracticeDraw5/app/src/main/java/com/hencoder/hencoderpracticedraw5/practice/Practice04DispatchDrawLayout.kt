package com.hencoder.hencoderpracticedraw5.practice

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet

class Practice04DispatchDrawLayout : Practice03OnDrawLayout {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        setWillNotDraw(false)
    }

    // 把 onDraw() 换成 dispatchDraw()，让绘制内容可以盖住子 View
    // 另外，在改完之后，上面的 setWillNotDraw(false) 也可以删了

    override fun dispatchDraw(canvas: Canvas) {
        super.dispatchDraw(canvas)
        pattern.draw(canvas)
    }
}
