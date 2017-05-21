package com.juniperphoton.h2r

import android.appwidget.AppWidgetManager
import android.content.ComponentName
import android.content.Context

object AppWidgetHelper {
    fun doWithWidgetId(context: Context, block: (Int) -> Unit) {
        val ids = AppWidgetManager.getInstance(context).getAppWidgetIds(ComponentName(context, TimeWidgetProvider::class.java))
        ids.forEach {
            block.invoke(it)
        }
    }
}