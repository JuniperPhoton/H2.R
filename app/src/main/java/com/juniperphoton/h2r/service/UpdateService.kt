package com.juniperphoton.h2r.service

import android.app.IntentService
import android.content.Intent
import android.util.Log
import com.juniperphoton.h2r.AppWidgetHelper
import com.juniperphoton.h2r.WidgetConfigurer

class UpdateService : IntentService(TAG) {
    companion object {
        private const val TAG = "UpdateService"
    }

    override fun onHandleIntent(intent: Intent?) {
        Log.d(TAG, "onHandleIntent")
        AppWidgetHelper.doWithWidgetId(this) {
            WidgetConfigurer.update(this, it)
        }
    }
}