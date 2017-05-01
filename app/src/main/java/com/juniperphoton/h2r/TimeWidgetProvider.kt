package com.juniperphoton.h2r

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import com.juniperphoton.h2r.receiver.UpdateBroadcastReceiver

class TimeWidgetProvider : AppWidgetProvider() {
    private var receiver: BroadcastReceiver? = null

    override fun onUpdate(context: Context?, appWidgetManager: AppWidgetManager?, appWidgetIds: IntArray?) {
        appWidgetIds!!.map {
            WidgetConfigurer.update(context!!, it)
        }
        receiver = UpdateBroadcastReceiver()

        var filter = IntentFilter()
        filter.addAction(Intent.ACTION_TIME_TICK)
        filter.addAction(Intent.ACTION_TIME_CHANGED)
        filter.addAction(Intent.ACTION_TIMEZONE_CHANGED)
        context!!.applicationContext!!.registerReceiver(receiver, filter)
    }

    override fun onEnabled(context: Context?) {
        super.onEnabled(context)
    }

    override fun onDisabled(context: Context?) {
        super.onDisabled(context)
        if (receiver != null) {
            context?.applicationContext?.unregisterReceiver(receiver)
        }
    }
}