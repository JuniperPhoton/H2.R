package com.juniperphoton.h2r.service

import android.app.IntentService
import android.appwidget.AppWidgetManager
import android.content.ComponentName
import android.content.Intent
import android.util.Log
import com.juniperphoton.h2r.TimeWidgetProvider
import com.juniperphoton.h2r.WidgetConfigurer

class UpdateService : IntentService(TAG) {
    companion object {
        private const val TAG = "UpdateService"
    }

    override fun onHandleIntent(intent: Intent?) {
        Log.d(TAG, "onHandleIntent")
        var ids = AppWidgetManager.getInstance(this).getAppWidgetIds(ComponentName(this, TimeWidgetProvider::class.java))
        ids.map {
            WidgetConfigurer.update(this, it)
        }
    }
}