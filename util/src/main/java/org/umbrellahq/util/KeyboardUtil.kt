package org.umbrellahq.util

import android.app.Activity
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import org.umbrellahq.util.foundation.FoundationActivity

fun FoundationActivity.hideKeyboard() {
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

fun Fragment.hideKeyboard() {
    (activity as? FoundationActivity)?.hideKeyboard()
}