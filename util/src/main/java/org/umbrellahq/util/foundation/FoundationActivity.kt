package org.umbrellahq.util.foundation

import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

open class FoundationActivity : AppCompatActivity() {
    private var tvTitle: TextView? = null
    private var navHostFragment: Fragment? = null


    /* ----- Navigation Methods ----- */

    // Setup navHostFragment to take advantage of customized back behavior
    protected fun setupNavigationHostFragment(id: Int) {
        navHostFragment = supportFragmentManager.findFragmentById(id)
        if (navHostFragment == null) {
            Log.e(TAG, "Couldn't find navigation host fragment")
        }
    }


    /* ----- Title methods ----- */

    // Set tvTitle if you want a centered title
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


    /* ----- Back Methods ----- */

    // If navHostFragment exists this will invoke doBack on fragments if exist
    override fun onBackPressed() {
        val currentFragment = navHostFragment?.childFragmentManager?.fragments?.get(0)

        if (currentFragment != null && currentFragment is FoundationFragment) {
            if (!currentFragment.doBack()) super.onBackPressed()
        } else super.onBackPressed()
    }

    companion object {
        private const val TAG = "FOUNDATION ACTIVITY"
    }
}