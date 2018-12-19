package org.umbrellahq.util.foundation

import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

open class FoundationActivity : AppCompatActivity() {
    private var tvTitle: TextView? = null

    // set tvTitle if you want a centered title
    protected fun setupCenterTitle(tvTitle: TextView) {
        this.tvTitle = tvTitle
    }

    internal fun setTitle(title: String) {
        // Start with empty default title
        this.title = ""

        // Set center title if tvTitle exists, otherwise set default title
        when {
            tvTitle != null -> tvTitle?.text = title
            else -> this.title = title
        }
    }
}