package com.example.lifecycletest.main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.lifecycletest.R
import com.example.lifecycletest.activity_transition.activity_a.ActivityA
import com.example.lifecycletest.lifecycle.MainActivity
import com.example.lifecycletest.nestedrecyclerview.ListActivity
import kotlinx.android.synthetic.main.activity_cool_stuff.*

class CoolStuffActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cool_stuff)
        tvLifecycle.setOnClickListener(this)
        tvNestedRecycler.setOnClickListener(this)
        tvTransitionExample.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v){
            tvLifecycle -> openLifecycleActyvity()
            tvNestedRecycler -> openNestedRecyclerActivity()
            tvTransitionExample -> openTransitionExampleActivity()
        }
    }

    private fun openTransitionExampleActivity() {
        startActivity(Intent(this@CoolStuffActivity, ActivityA::class.java))
    }

    private fun openNestedRecyclerActivity() {
        startActivity(Intent(this@CoolStuffActivity, ListActivity::class.java))
    }

    private fun openLifecycleActyvity() {
        startActivity(Intent(this@CoolStuffActivity, MainActivity::class.java))
    }
}
