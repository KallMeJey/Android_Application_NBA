package com.example.nba.presentation

import android.app.Application
import android.content.Context

class NbaApplication : Application(){
    companion object{
        var context: Context?=null
    }

    override fun onCreate() {
        super.onCreate()
        context=this
    }
}