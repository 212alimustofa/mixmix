package com.example.lifecycletest.activity_transition.activity_a

import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.transition.Slide
import android.view.Window
import com.example.lifecycletest.R
import com.example.lifecycletest.activity_transition.activity_b.ActivityB
import kotlinx.android.synthetic.main.a_activity.*

class ActivityA : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                message.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                message.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                openActivityB()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun openActivityB() {
        val intent = Intent(this@ActivityA, ActivityB::class.java)
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }
        else{
            startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
            window.enterTransition = Slide()
        }
        setContentView(R.layout.a_activity)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
