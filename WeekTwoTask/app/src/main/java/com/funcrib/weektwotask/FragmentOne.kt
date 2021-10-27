package com.funcrib.weektwotask

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class FragmentOne : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_one, container, false)
        /*Initialize TextView*/
        val textView = view.findViewById<TextView>(R.id.tvFragmentOne)
        /*Get argument passed to fragment*/
        val stackPosition = this.arguments?.getInt("STACK_POSITION")
        /*Set TextView Text */
        textView.text = "BackStack Position: $stackPosition"

        return view
    }
}