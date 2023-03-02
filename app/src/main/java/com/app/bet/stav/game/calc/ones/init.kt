package com.app.bet.stav.game.calc.ones

import android.app.Application
import com.onesignal.OneSignal

class init: Application() {

    override fun onCreate() {
        super.onCreate()
        try {


            OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
            OneSignal.initWithContext(this)
            OneSignal.setAppId(parametr.one)


        }catch (e: Exception){

        }
    }

}