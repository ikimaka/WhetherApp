package com.ikimaka.whetherapp

import android.app.Application
import com.ikimaka.whetherapp.di.ApplicationComponent
import com.ikimaka.whetherapp.di.DaggerApplicationComponent

class WeatherApp: Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.factory().create(this)
    }
}