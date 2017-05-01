package com.juniperphoton.h2r.receiver

import android.appwidget.AppWidgetManager
import android.content.BroadcastReceiver
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.util.Log
import com.juniperphoton.h2r.TimeWidgetProvider
import com.juniperphoton.h2r.WidgetConfigurer

class UpdateBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d("UpdateBroadcastReceiver", "onReceive:" + System.currentTimeMillis())
        if (intent!!.action == Intent.ACTION_TIME_TICK
                || intent!!.action == Intent.ACTION_TIME_CHANGED
                || intent!!.action == Intent.ACTION_TIMEZONE_CHANGED) {
            var ids = AppWidgetManager.getInstance(context).getAppWidgetIds(ComponentName(context, TimeWidgetProvider::class.java))
            ids.map {
                WidgetConfigurer.update(context!!, it)
            }
        }
    }
}
