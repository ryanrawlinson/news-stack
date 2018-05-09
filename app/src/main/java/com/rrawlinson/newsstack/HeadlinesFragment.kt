package com.rrawlinson.newsstack


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavOptions
import androidx.navigation.Navigation.createNavigateOnClickListener

class HeadlinesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_headlines, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val options = NavOptions.Builder()
                .setEnterAnim(R.anim.nav_default_enter_anim)
                .setExitAnim(R.anim.nav_default_exit_anim)
                .setPopEnterAnim(R.anim.nav_default_pop_enter_anim)
                .setPopEnterAnim(R.anim.nav_default_pop_exit_anim)
                .build()

        // Navigate with nav controller and options
//        view.findViewById<Button>(R.id.getLatestHeadlinesButton).setOnClickListener {
//            findNavController(view).navigate(R.id.headlineDetailFragment, null, options)
//        }

        // Navigate with an action
        view.findViewById<Button>(R.id.getLatestHeadlinesButton)
                .setOnClickListener(createNavigateOnClickListener(R.id.action_headlinesFragment_to_headlineDetailFragment, null))
    }
}
