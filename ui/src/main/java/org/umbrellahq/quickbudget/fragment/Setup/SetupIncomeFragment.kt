package org.umbrellahq.quickbudget.fragment.Setup


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.fragment_setup_income.*
import org.umbrellahq.quickbudget.R
import org.umbrellahq.quickbudget.adapter_viewpager.SetupViewPagerAdapter
import org.umbrellahq.util.component.NonSwipeableViewPager
import org.umbrellahq.util.foundation.FoundationFragment
import org.umbrellahq.util.inflate
import org.umbrellahq.util.pop
import org.umbrellahq.util.push

class SetupIncomeFragment : FoundationFragment() {

    // Inflate Layout for fragment
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = container?.inflate(R.layout.fragment_setup_income)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeIncomePeriodSpinner()

        bBack.setOnClickListener { popToSetupBalance() }
        bNext.setOnClickListener { pushSetupNextPay() }
    }

    private fun initializeIncomePeriodSpinner() {
        val applicationContext = activity?.applicationContext ?: return

        ArrayAdapter.createFromResource(
            applicationContext,
            R.array.setup_income_periods,
            R.layout.component_income_period
        ).also { adapter ->
            // Apply the adapter to the spinner
            spinnerPeriod.adapter = adapter
            spinnerPeriod.setSelection(ITEM_WEEKS_POSITION)
        }
    }

    private fun pushSetupNextPay() {
        activity?.findViewById<NonSwipeableViewPager>(R.id.vpSetup)?.push(
            fromIdx = SetupViewPagerAdapter.TAB_POSITION_SETUP_INCOME
        )
    }

    private fun popToSetupBalance() {
        activity?.findViewById<NonSwipeableViewPager>(R.id.vpSetup)?.pop(
            fromIdx = SetupViewPagerAdapter.TAB_POSITION_SETUP_INCOME
        )
    }

    companion object {
        const val ITEM_DAYS_POSITION = 0
        const val ITEM_WEEKS_POSITION = 1
        const val ITEM_MONTHS_POSITION = 2
        const val ITEM_YEARS_POSITION = 3
    }
}