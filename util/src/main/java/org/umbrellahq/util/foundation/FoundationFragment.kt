package org.umbrellahq.util.foundation

import androidx.fragment.app.Fragment

open class FoundationFragment : Fragment() {
    open fun doBack() = false
}

fun Fragment.setupToolbar(title: String, showBack: Boolean = true) {
    (activity as FoundationActivity).setTitle(title)
    (activity as FoundationActivity).supportActionBar?.setDisplayHomeAsUpEnabled(showBack)
}