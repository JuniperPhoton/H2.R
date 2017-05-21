package com.juniperphoton.h2r.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.juniperphoton.h2r.AppWidgetHelper
import com.juniperphoton.h2r.WidgetConfigurer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppWidgetHelper.doWithWidgetId(this) {
            WidgetConfigurer.update(this, it)
        }
        finish()
    }
}
