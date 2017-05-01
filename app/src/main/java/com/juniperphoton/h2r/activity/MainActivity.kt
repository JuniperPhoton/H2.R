package com.juniperphoton.h2r.activity

import android.appwidget.AppWidgetManager
import android.content.ComponentName
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.juniperphoton.h2r.TimeWidgetProvider
import com.juniperphoton.h2r.WidgetConfigurer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var ids = AppWidgetManager.getInstance(this).getAppWidgetIds(ComponentName(this, TimeWidgetProvider::class.java))
        ids.map {
            WidgetConfigurer.update(this, it)
        }
        finish()
    }
}
