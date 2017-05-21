package com.juniperphoton.h2r

import android.app.AlarmManager
import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import com.juniperphoton.h2r.service.UpdateService

class TimeWidgetProvider : AppWidgetProvider() {
    override fun onUpdate(context: Context?, appWidgetManager: AppWidgetManager?, appWidgetIds: IntArray?) {
        appWidgetIds?.forEach {
            WidgetConfigurer.update(context!!, it)
        }
        val intent = Intent(context, UpdateService::class.java)
        val pendingIntent = PendingIntent.getService(context, 0, intent, 0)

        val am = context!!.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        am.setRepeating(AlarmManager.RTC, 0, 60 * 1000, pendingIntent)
    }
}