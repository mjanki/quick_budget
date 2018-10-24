package org.umbrellahq.quickbudget.fragment.Setup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_setup_balance.*
import org.umbrellahq.quickbudget.R
import org.umbrellahq.quickbudget.adapter_viewpager.SetupViewPagerAdapter
import org.umbrellahq.util.component.NonSwipeableViewPager
import org.umbrellahq.util.foundation.FoundationFragment
import org.umbrellahq.util.hideKeyboard
import org.umbrellahq.util.inflate

class SetupBalanceFragment : FoundationFragment() {

    // Inflate Layout for fragment
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? = container?.inflate(R.layout.fragment_setup_balance)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bNext.setOnClickListener {
            pushSetupIncome()
            hideKeyboard()
        }
    }

    private fun pushSetupIncome() {
        val viewPager = activity?.findViewById<NonSwipeableViewPager>(R.id.vpSetup)
        if (viewPager != null) {
            viewPager.currentItem = SetupViewPagerAdapter.TAB_POSITION_SETUP_INCOME
        }
    }
}
