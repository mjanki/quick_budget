package org.umbrellahq.quickbudget.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.activity_main.*
import org.umbrellahq.quickbudget.R
import org.umbrellahq.quickbudget.fragment.FoundationFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        android.R.id.home -> findNavController(R.id.myNavHostFragment).navigateUp()
        else -> super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.myNavHostFragment)
        val currentFragment = navHostFragment?.childFragmentManager?.fragments?.get(0)

        if (currentFragment != null && currentFragment is FoundationFragment) {
            if (!currentFragment.doBack()) super.onBackPressed()
        } else super.onBackPressed()
    }
}
