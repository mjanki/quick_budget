package org.umbrellahq.util.foundation

import androidx.fragment.app.Fragment

open class FoundationFragment : Fragment() {
    open fun doBack() = false
}

fun Fragment.setupToolbar(title: String, showBack: Boolean = true) {
    activity?.title = ""
    (activity as FoundationActivity).cTvTitle.text = title
    (activity as FoundationActivity).supportActionBar?.setDisplayHomeAsUpEnabled(showBack)
}