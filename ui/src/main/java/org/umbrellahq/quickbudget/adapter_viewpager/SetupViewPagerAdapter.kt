package org.umbrellahq.quickbudget.adapter_viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import org.umbrellahq.quickbudget.fragment.Setup.SetupBalanceFragment
import org.umbrellahq.quickbudget.fragment.Setup.SetupIncomeFragment
import org.umbrellahq.quickbudget.fragment.Setup.SetupNextPayFragment

class SetupViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    companion object {
        const val TAB_POSITION_SETUP_BALANCE    = 0
        const val TAB_POSITION_SETUP_INCOME     = 1
        const val TAB_POSITION_SETUP_NEXT_PAY   = 2
    }

    override fun getItem(position: Int): Fragment = when (position) {
        TAB_POSITION_SETUP_BALANCE  -> SetupBalanceFragment()
        TAB_POSITION_SETUP_INCOME   -> SetupIncomeFragment()
        TAB_POSITION_SETUP_NEXT_PAY -> SetupNextPayFragment()
        else                        -> Fragment()
    }

    override fun getCount(): Int = 3
}