package com.funcrib.weektwotask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_fragment.*

class FragmentActivity : AppCompatActivity() {

    private lateinit var fragmentTransaction: FragmentTransaction
    var stackPosition = supportFragmentManager.backStackEntryCount + 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        initFragment()

        //Add new fragment on each button click//
        btAddFragment.setOnClickListener {
            addFragment()
        }

        btRemoveFragment.setOnClickListener {
            if (supportFragmentManager.backStackEntryCount == 1) {
                startActivity(Intent(this, MainActivity::class.java))
            } else {

                supportFragmentManager.popBackStack()
            }
        }
    }

    //Fragment Added Dynamically//
    private fun addFragment() {
        val fragment: Fragment

        stackPosition = supportFragmentManager.backStackEntryCount + 1

        //bundle to hold data to be passed between activity and fragments//
        val bundle = Bundle()
        bundle.putInt("STACK_POSITION", stackPosition)

        when(stackPosition) {
            1 -> {
                fragment = FragmentOne()
                fragment.arguments = bundle
            }
            2 -> {
                fragment =FragmentTwo()
                fragment.arguments = bundle
            }
            3 -> {
                fragment = FragmentThree.newInstance(
                    "BackStack Position: $stackPosition"
                )
            }
            else -> {
                fragment = FragmentOne()
                fragment.arguments = bundle
            }
        }

        fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.apply {
            setReorderingAllowed(true)
            replace(R.id.fragmentContainer, fragment)
            addToBackStack(null)
            commit()
        }
    }

    //Add Initial Fragment//
    private fun initFragment() {
        stackPosition = supportFragmentManager.backStackEntryCount + 1
        fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.apply {
            setReorderingAllowed(true)
            replace(R.id.fragmentContainer, FragmentThree.newInstance(
                "BackStack Position: $stackPosition"))
            addToBackStack(null)
            commit()
        }
    }

}

