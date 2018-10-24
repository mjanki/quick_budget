package org.umbrellahq.quickbudget.fragment.Setup


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.fragment_setup.*
import org.umbrellahq.quickbudget.R
import org.umbrellahq.quickbudget.adapter_viewpager.SetupViewPagerAdapter
import org.umbrellahq.util.foundation.FoundationFragment
import org.umbrellahq.util.foundation.setupToolbar
import org.umbrellahq.util.inflate

class SetupFragment : FoundationFragment() {

    // Inflate Layout for fragment
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? = container?.inflate(R.layout.fragment_setup)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupToolbar(getString(R.string.setup_fragment), false)

        vpSetup.adapter = SetupViewPagerAdapter(childFragmentManager)
        vpSetup.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                // TODO: hide keyboard and such
            }

            override fun onPageSelected(position: Int) {
                // TODO: change footer (if any)
            }

            override fun onPageScrollStateChanged(state: Int) { }
        })
    }

    // Don't pop on system back
    override fun doBack(): Boolean {
        if (vpSetup.currentItem > 0) {
            vpSetup.currentItem--
        }

        return true
    }
}
