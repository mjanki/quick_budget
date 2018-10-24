package org.umbrellahq.util.foundation

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

open class FoundationFragment : Fragment() {
    open fun doBack() = false
}

fun Fragment.setupToolbar(title: String, showBack: Boolean = true) {
    activity?.title = title
    (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(showBack)
}