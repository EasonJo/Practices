package com.hencoder.hencoderpracticedraw6.practice

import android.content.Context
import android.graphics.Outline
import android.graphics.Path
import android.os.Build
import android.os.Build.VERSION.SDK_INT
import android.os.Build.VERSION_CODES.LOLLIPOP
import android.support.annotation.RequiresApi
import android.util.AttributeSet
import android.view.View
import android.view.ViewOutlineProvider
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import com.hencoder.hencoderpracticedraw6.R
import com.hencoder.hencoderpracticedraw6.dp2px
import com.hencoder.hencoderpracticedraw6.dpToPixel

class Practice01Translation : RelativeLayout {
    private lateinit var animateBt: Button
    private lateinit var imageView: ImageView

    private var translationStateCount = if (SDK_INT > LOLLIPOP) 6 else 4
    private var translationState = 0

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        animateBt = findViewById(R.id.animateBt) as Button
        imageView = findViewById(R.id.imageView) as ImageView
        if (SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            // 给音乐图标加上合适的阴影
            imageView.outlineProvider = MusicOutlineProvider()
        }

        // TODO 在这里处理点击事件，通过 View.animate().translationX/Y/Z() 来让 View 平移
        animateBt.setOnClickListener {
            when (translationState) {
                0 -> imageView.animate().translationX(100f.dp2px())
                1 -> imageView.animate().translationX(0f)
                2 -> imageView.animate().translationY(50f.dp2px())
                3 -> imageView.animate().translationY(0f)
                4 -> if (SDK_INT > LOLLIPOP) imageView.animate().translationZ(15f.dp2px())
                5 -> if (SDK_INT > LOLLIPOP) imageView.animate().translationZ(0f)
            }

            translationState++
            if (translationState == translationStateCount) {
                translationState = 0
            }
        }
    }

    /**
     * 为音乐图标设置三角形的 Outline。
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private inner class MusicOutlineProvider : ViewOutlineProvider() {
        var path = Path()

        init {
            path.moveTo(0f, dpToPixel(10f))
            path.lineTo(dpToPixel(7f), dpToPixel(2f))
            path.lineTo(dpToPixel(116f), dpToPixel(58f))
            path.lineTo(dpToPixel(116f), dpToPixel(70f))
            path.lineTo(dpToPixel(7f), dpToPixel(128f))
            path.lineTo(0f, dpToPixel(120f))
            path.close()
        }

        override fun getOutline(view: View, outline: Outline) {
            outline.setConvexPath(path)
        }
    }


}