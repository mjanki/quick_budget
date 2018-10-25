package org.umbrellahq.quickbudget.fragment.Setup


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_setup.*
import org.umbrellahq.quickbudget.R
import org.umbrellahq.quickbudget.adapter_viewpager.SetupViewPagerAdapter
import org.umbrellahq.util.foundation.FoundationFragment
import org.umbrellahq.util.foundation.setupToolbar
import org.umbrellahq.util.inflate
import org.umbrellahq.util.pop

class SetupFragment : FoundationFragment() {

    // Inflate Layout for fragment
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? = container?.inflate(R.layout.fragment_setup)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupToolbar(getString(R.string.setup_fragment), false)

        vpSetup.adapter = SetupViewPagerAdapter(childFragmentManager)
    }

    // Don't pop on system back
    override fun doBack(): Boolean {
        vpSetup.pop()

        return true
    }
}
