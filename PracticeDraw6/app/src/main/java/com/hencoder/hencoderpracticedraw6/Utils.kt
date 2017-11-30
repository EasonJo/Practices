package com.hencoder.hencoderpracticedraw6

import android.content.res.Resources

fun dpToPixel(dp: Float): Float {
    val metrics = Resources.getSystem().displayMetrics
    return dp * metrics.density
}


fun Float.dp2px(): Float {
    val metrics = Resources.getSystem().displayMetrics
    return this * metrics.density
}

