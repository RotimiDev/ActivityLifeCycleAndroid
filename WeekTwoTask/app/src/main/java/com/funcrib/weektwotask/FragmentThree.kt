package com.funcrib.weektwotask

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

// Initialize parameters //
private const val STACK_POSITION = "param1"

class FragmentThree : Fragment() {

    private var stackPosition: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            stackPosition = it.getString(STACK_POSITION)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_three, container, false)

        val textView = view.findViewById<TextView>(R.id.tvFragmentBlank)

        textView.text = stackPosition
        return view
    }

    companion object {

        @JvmStatic
        fun newInstance(stackPosition: String) =
            FragmentThree().apply {
                arguments = Bundle().apply {
                    putString(STACK_POSITION, stackPosition)
                }
            }
    }
}