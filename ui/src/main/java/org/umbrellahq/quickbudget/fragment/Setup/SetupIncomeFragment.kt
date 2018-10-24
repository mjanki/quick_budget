package org.umbrellahq.quickbudget.fragment.Setup


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.umbrellahq.quickbudget.R
import org.umbrellahq.util.foundation.FoundationFragment
import org.umbrellahq.util.inflate

class SetupIncomeFragment : FoundationFragment() {

    // Inflate Layout for fragment
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? = container?.inflate(R.layout.fragment_setup_income)
}
