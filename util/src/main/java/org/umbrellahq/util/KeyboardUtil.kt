package org.umbrellahq.util

import android.app.Activity
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.view.inputmethod.InputMethodManager
import org.umbrellahq.util.foundation.FoundationActivity
import org.umbrellahq.util.foundation.FoundationFragment


fun FoundationActivity.hideKeyboard() {
    // If keyboard is not showing then don't do anything
    if (!isKeyboardShowing()) { return }

    val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager

    //Find the currently focused view, so we can grab the correct window token from it.
    var view = currentFocus

    //If no view currently has focus, create a new one, just so we can grab a window token from it
    if (view == null) {
        view = View(this)
    }

    imm.hideSoftInputFromWindow(view.windowToken, 0)
    view.clearFocus()
}

fun FoundationFragment.hideKeyboard() {
    (activity as? FoundationActivity)?.hideKeyboard()
}

fun FoundationActivity.isKeyboardShowing(): Boolean {
    val rView = rootView
    if (rView == null) {
        Log.e("Keyboard Util", "Please setupRootView")
        return false
    }

    val heightDiff = rView.rootView.height - rView.height

    val metrics = resources.displayMetrics
    val height200 = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200F, metrics)

    return heightDiff > height200
}