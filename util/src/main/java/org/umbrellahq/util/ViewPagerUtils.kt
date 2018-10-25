package org.umbrellahq.util

import androidx.viewpager.widget.ViewPager

fun ViewPager.pop(fromIdx: Int = currentItem) {
    if (fromIdx <= 0) return

    currentItem = fromIdx - 1
}

fun ViewPager.push(fromIdx: Int = currentItem) {
    val count = adapter?.count ?: return
    if (fromIdx >= count - 1) return

    currentItem = fromIdx + 1
}