package com.juniperphoton.h2r

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.widget.RemoteViews
import java.util.*

object WidgetConfigurer {
    fun update(ctx: Context, widgetId: Int) {
        var manager = AppWidgetManager.getInstance(ctx)
        var remoteViews = RemoteViews("com.juniperphoton.h2r", R.layout.time_layout)
        var hour0 = Calendar.HOUR.toString()[0].toString()
        var hour1 = Calendar.HOUR.toString()[1].toString()
        var min = Calendar.MINUTE.toString()

        remoteViews.setTextViewText(R.id.hour_text_view_0, hour0)
        remoteViews.setTextViewText(R.id.hour_text_view_1, hour1)
        remoteViews.setTextViewText(R.id.min_text_view, min)

        if (hour0 == "1") {
            remoteViews.setTextColor(R.id.hour_text_view_0, Color.RED)
        }

        if (hour1 == "1") {
            remoteViews.setTextColor(R.id.hour_text_view_1, Color.RED)
        }

        var intent = Intent(ctx, MainActivity::class.java)
        var pendingIntent = PendingIntent.getActivity(ctx, 0, intent, 0)
        remoteViews.setOnClickPendingIntent(R.id.root, pendingIntent)

        manager.updateAppWidget(widgetId, remoteViews)
    }
}
