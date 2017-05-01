package com.juniperphoton.h2r.receiver

import android.appwidget.AppWidgetManager
import android.content.BroadcastReceiver
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import com.juniperphoton.h2r.TimeWidgetProvider
import com.juniperphoton.h2r.WidgetConfigurer

class UpdateBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent!!.action == Intent.ACTION_TIME_TICK) {
            var ids = AppWidgetManager.getInstance(context).getAppWidgetIds(ComponentName(context, TimeWidgetProvider::class.java))
            ids.map {
                WidgetConfigurer.update(context!!, it)
            }
        }
    }
}
