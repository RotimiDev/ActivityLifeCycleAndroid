package com.funcrib.weektwotask

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var lifecycleObserver: MainActivityObserver
    private var TAG : String = this.javaClass.simpleName
    private var portraitCount = 1
    private var landscapeCount = 0
    var handler = Handler()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initialize the LifeCycle//
        lifecycleObserver = MainActivityObserver()
        lifecycle.addObserver(lifecycleObserver)


        handler.postDelayed(
            {tvLifecycle.text = "CREATED"},
            1400
        )
        Log.i(TAG, "Activity Created")

        //Set Orientation Text//
        tvOrientation.text = "Portrait Mode\nPortraitCount = $portraitCount"

        if (savedInstanceState != null
        ) {
            val orientation = resources.configuration.orientation
            portraitCount = savedInstanceState.getInt("PORTRAIT_COUNT")
            landscapeCount = savedInstanceState.getInt("LANDSCAPE_COUNT")

            when (orientation) {
                Configuration.ORIENTATION_LANDSCAPE -> {
                    //Landscape increment count//
                    landscapeCount++
                    tvOrientation.text = "Landscape Mode\nLandScapeCount = $landscapeCount"
                }
                Configuration.ORIENTATION_PORTRAIT -> {
                    //portrait increment count//
                    portraitCount++
                    tvOrientation.text = "Portrait Mode\nPortraitCount = $portraitCount"
                }
                Configuration.ORIENTATION_SQUARE -> {
                    TODO()
                }
                Configuration.ORIENTATION_UNDEFINED -> {
                    TODO()
                }
            }
        }
        //Move to Fragment Activity Using Intent//
        toFragment.setOnClickListener {
            val intent = Intent(this, FragmentActivity::class.java)
            startActivity(intent)
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onStart() {
        super.onStart()
        handler.postDelayed(
            {tvLifecycle.text = "STARTED"},
            1600
        )
        Log.i(TAG, "Activity Started")
    }

    @SuppressLint("SetTextI18n")
    override fun onResume() {
        super.onResume()
        handler.postDelayed(
            {tvLifecycle.text = "RESUMED"},
            1800
        )
        Log.i(TAG, "Activity Resumed")
    }

    @SuppressLint("SetTextI18n")
    override fun onPause() {
        super.onPause()
        handler.postDelayed(
            {tvLifecycle.text = "PAUSED"},
            600
        )
        Log.i(TAG, "Activity Paused")
    }

    @SuppressLint("SetTextI18n")
    override fun onStop() {
        super.onStop()
        handler.postDelayed(
            {tvLifecycle.text = "STOPPED"},
            800
        )
        Log.i(TAG, "Activity Stopped")
    }

    @SuppressLint("SetTextI18n")
    override fun onDestroy() {
        super.onDestroy()
        handler.postDelayed(
            {tvLifecycle.text = "DESTROYED"},
            1000
        )
        Log.i(TAG, "Activity Destroyed")
    }

    @SuppressLint("SetTextI18n")
    override fun onRestart() {
        super.onRestart()
        super.onStop()
        handler.postDelayed(
            {tvLifecycle.text = "RESTARTED"},
            1200
        )
        Log.i(TAG, "Activity Restarted")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt("LANDSCAPE_COUNT", landscapeCount)
        outState.putInt("PORTRAIT_COUNT", portraitCount)
    }
}