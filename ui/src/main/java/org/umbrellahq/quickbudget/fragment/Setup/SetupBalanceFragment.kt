package org.umbrellahq.quickbudget.fragment.Setup


import android.os.Bundle
import android.os.Handler
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
import org.umbrellahq.util.push

class SetupBalanceFragment : FoundationFragment() {

    // Inflate Layout for fragment
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? = container?.inflate(R.layout.fragment_setup_balance)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bNext.setOnClickListener {
            hideKeyboard()
            Handler().postDelayed({ pushSetupIncome() }, 100)
        }
    }

    private fun pushSetupIncome() {
        activity?.findViewById<NonSwipeableViewPager>(R.id.vpSetup)?.push(
            fromIdx = SetupViewPagerAdapter.TAB_POSITION_SETUP_BALANCE
        )
    }
}
