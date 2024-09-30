package com.android.aigittest.presenter

import android.app.Application
import com.android.aigittest.data.api.RetrofitClient

class IpApplication : Application() {
    lateinit var container: RetrofitClient
    override fun onCreate() {
        super.onCreate()
        container = RetrofitClient()
    }
}