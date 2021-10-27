package com.funcrib.weektwotask

import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class MainActivityObserver() : LifecycleObserver, Parcelable {

    private var TAG : String = this.javaClass.simpleName

    constructor(parcel: Parcel) : this() {
        TAG = parcel.readString().toString()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        Log.i(TAG, "Activity Created")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        Log.i(TAG, "Activity Resumed")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        Log.i(TAG, "Activity will be Paused")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        Log.i(TAG, "Activity will be Stopped")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        Log.i(TAG, "Activity will be Destroyed")
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(TAG)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivityObserver> {
        override fun createFromParcel(parcel: Parcel): MainActivityObserver {
            return MainActivityObserver(parcel)
        }

        override fun newArray(size: Int): Array<MainActivityObserver?> {
            return arrayOfNulls(size)
        }
    }
}