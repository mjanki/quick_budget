package org.umbrellahq.quickbudget.fragment

import android.os.Bundle
import android.view.*
import androidx.navigation.fragment.findNavController
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
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.menu_fragment_main, menu)

        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.action_add -> findNavController().navigate(R.id.toSetup)
        }

        return super.onOptionsItemSelected(item)
    }
}
