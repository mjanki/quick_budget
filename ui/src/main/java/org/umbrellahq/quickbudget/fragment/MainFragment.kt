package org.umbrellahq.quickbudget.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_main.*
import org.umbrellahq.quickbudget.R

class MainFragment : FoundationFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupToolbar(getString(R.string.main_fragment), false)

        bSetupFragment.setOnClickListener { it.findNavController().navigate(R.id.toSetup) }
    }


}
