package com.juniperphoton.h2r

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.widget.RemoteViews
import com.juniperphoton.h2r.activity.AlarmActivity
import com.juniperphoton.h2r.activity.MainActivity
import java.util.*

object WidgetConfigurer {
    private const val NUMBER_PLACEHOLDER = "0"
    private const val NUMBER_TO_TINT = "1"

    fun update(ctx: Context, widgetId: Int) {
        var manager = AppWidgetManager.getInstance(ctx)
        var remoteViews = RemoteViews(ctx.packageName, R.layout.time_layout)
        var calendar = Calendar.getInstance(TimeZone.getDefault())
        var hours = calendar.get(Calendar.HOUR_OF_DAY).toString()
        var hour0 = NUMBER_PLACEHOLDER
        var hour1: String
        if (hours.length == 2) {
            hour0 = hours[0].toString()
            hour1 = hours[1].toString()
        } else {
            hour1 = hours[0].toString()
        }

        var min = calendar.get(Calendar.MINUTE).toString()
        if (min.length == 1) {
            min = NUMBER_PLACEHOLDER + min
        }

        remoteViews.setTextViewText(R.id.hour_text_view_0, hour0)
        remoteViews.setTextViewText(R.id.hour_text_view_1, hour1)
        remoteViews.setTextViewText(R.id.min_text_view, min)

        if (hour0 == NUMBER_TO_TINT) {
            remoteViews.setTextColor(R.id.hour_text_view_0, Color.RED)
        } else {
            remoteViews.setTextColor(R.id.hour_text_view_0, Color.WHITE)
        }

        if (hour1 == NUMBER_TO_TINT) {
            remoteViews.setTextColor(R.id.hour_text_view_1, Color.RED)
        } else {
            remoteViews.setTextColor(R.id.hour_text_view_1, Color.WHITE)
        }

        var intent = Intent(ctx, AlarmActivity::class.java)
        var pendingIntent = PendingIntent.getActivity(ctx, 0, intent, 0)
        remoteViews.setOnClickPendingIntent(R.id.root, pendingIntent)

        manager.updateAppWidget(widgetId, remoteViews)
    }
}
