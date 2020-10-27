package com.temp.azuredatatest

import android.app.Application
import com.azure.data.AzureData
import com.azure.data.model.PermissionMode
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

class App:Application() {

    init {
        Thread.setDefaultUncaughtExceptionHandler(ThreadExceptionalHandler())
    }

    override fun onCreate() {
        super.onCreate()

        // provide Valid  cosmosDB accountName and accountKey
        val accountKey = ""
        val accountName= ""
        AzureData.configure(this, accountName, accountKey, PermissionMode.All)

    }
}

