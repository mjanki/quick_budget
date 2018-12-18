package org.umbrellahq.quickbudget.fragment.Setup

import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_setup_next_pay.*
import org.umbrellahq.quickbudget.R
import org.umbrellahq.quickbudget.adapter_viewpager.SetupViewPagerAdapter
import org.umbrellahq.util.component.NonSwipeableViewPager
import org.umbrellahq.util.foundation.FoundationFragment
import org.umbrellahq.util.inflate
import org.umbrellahq.util.pop
import java.util.*


class SetupNextPayFragment : FoundationFragment() {
    private val calendar = Calendar.getInstance()
    private var year = calendar.get(Calendar.YEAR)
    private var month = calendar.get(Calendar.MONTH)
    private var day = calendar.get(Calendar.DAY_OF_MONTH)

    // Inflate Layout for fragment
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = container?.inflate(R.layout.fragment_setup_next_pay)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bSave.setOnClickListener { it.findNavController().navigate(R.id.toMain) }
        bBack.setOnClickListener { popToSetupIncome() }
        bDate.setOnClickListener { showDatePicker() }

        updateDate()
    }

    private fun showDatePicker() {
        val ctx = context ?: return

        val datePicker = DatePickerDialog(
            ctx,
            DatePickerDialog.OnDateSetListener { _, year, month, day ->
                this.day = day
                this.month = month
                this.year = year

                updateDate()
            },
            year, month, day
        )

        datePicker.show()
    }

    private fun popToSetupIncome() {
        activity?.findViewById<NonSwipeableViewPager>(R.id.vpSetup)?.pop(
            fromIdx = SetupViewPagerAdapter.TAB_POSITION_SETUP_NEXT_PAY
        )
    }

    private fun updateDate() {
        bDate.text = getString(R.string.date_format, month + 1, day, year)
    }
}
