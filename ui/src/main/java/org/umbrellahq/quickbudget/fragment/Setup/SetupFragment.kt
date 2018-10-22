package org.umbrellahq.quickbudget.fragment.Setup


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.fragment_setup.*
import org.umbrellahq.quickbudget.R
import org.umbrellahq.quickbudget.adapter_viewpager.SetupViewPagerAdapter
import org.umbrellahq.quickbudget.fragment.FoundationFragment
import org.umbrellahq.quickbudget.fragment.setupToolbar

class SetupFragment : FoundationFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_setup, container, false)
    }

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

        bNext.setOnClickListener {
            if (vpSetup.currentItem < 2) {
                vpSetup.currentItem = vpSetup.currentItem + 1
            }
        }

        bPrevious.setOnClickListener {
            if (vpSetup.currentItem > 0) {
                vpSetup.currentItem = vpSetup.currentItem - 1
            }
        }
    }

    // Don't pop on system back
    override fun doBack() = true
}
