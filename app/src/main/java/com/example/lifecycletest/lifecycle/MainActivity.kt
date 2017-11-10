package com.example.lifecycletest.lifecycle

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import com.example.lifecycletest.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val chronoMeterVM: ChronometerViewModel = ViewModelProviders.of(this).get(ChronometerViewModel::class.java)
        if (chronoMeterVM.startDate==null){
            val startTime = SystemClock.elapsedRealtime()
            chronoMeterVM.startDate = startTime
        }
        else{
            chronometer.base = chronoMeterVM.startDate!!
        }
        chronometer.start()
    }
}
