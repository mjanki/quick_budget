package org.umbrellahq.quickbudget.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_main.*
import org.umbrellahq.quickbudget.R
import org.umbrellahq.util.foundation.FoundationFragment
import org.umbrellahq.util.foundation.setupToolbar
import org.umbrellahq.util.inflate

class MainFragment : FoundationFragment() {

    // Inflate Layout for fragment
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? = container?.inflate(R.layout.fragment_main)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupToolbar(getString(R.string.main_fragment), false)

        bSetupFragment.setOnClickListener { it.findNavController().navigate(R.id.toSetup) }
    }
}
