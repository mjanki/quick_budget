package org.umbrellahq.util

import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager

fun ViewPager.pop(fromIdx: Int = currentItem, hideKeyboard: Boolean = true) {
    if (hideKeyboard) {
        val ctx = context
        if (ctx is AppCompatActivity) {
            ctx.hideKeyboard()
            Handler().postDelayed({
                move(fromIdx - 1)
            }, 100)
        } else { move(fromIdx - 1) }
    } else { move(fromIdx - 1) }
}

fun ViewPager.push(fromIdx: Int = currentItem, hideKeyboard: Boolean = true) {
    if (hideKeyboard) {
        val ctx = context
        if (ctx is AppCompatActivity) {
            ctx.hideKeyboard()
            Handler().postDelayed({
                move(fromIdx + 1)
            }, 100)
        } else { move(fromIdx + 1) }
    } else { move(fromIdx + 1) }
}

fun ViewPager.move(toIdx: Int) {
    val count = adapter?.count ?: return
    if (toIdx < 0 || toIdx >= count) return

    currentItem = toIdx
}