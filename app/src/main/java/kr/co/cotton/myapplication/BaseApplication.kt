package kr.co.cotton.myapplication

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
open class BaseApplication : Application()