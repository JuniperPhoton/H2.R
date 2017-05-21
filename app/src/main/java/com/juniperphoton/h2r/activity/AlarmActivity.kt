package com.juniperphoton.h2r.activity

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock
import android.support.v7.app.AppCompatActivity
import com.juniperphoton.h2r.AppWidgetHelper
import com.juniperphoton.h2r.WidgetConfigurer

class AlarmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AppWidgetHelper.doWithWidgetId(this) {
            WidgetConfigurer.update(this, it)
        }

        val openClockIntent = Intent(AlarmClock.ACTION_SHOW_ALARMS)
        openClockIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

        try {
            startActivity(openClockIntent)
        } catch (e: ActivityNotFoundException) {
            e.printStackTrace()
        }

        finish()
    }
}