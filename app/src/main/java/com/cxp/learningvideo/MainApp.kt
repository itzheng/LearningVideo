package com.cxp.learningvideo

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context


/**
 *
 * @author Chen Xiaoping (562818444@qq.com)
 * @since LearningVideo
 * @version LearningVideo
 * @Datetime 2019-10-10 09:28
 *
 */

@SuppressLint("StaticFieldLeak")
var CONTEXT: Context? = null

class MainApp : Application() {
    override fun onCreate() {
        super.onCreate()
        CONTEXT = this
    }

    companion object {
        public fun getFilePath(): String {
            return CONTEXT!!.cacheDir.absolutePath + "/mvtest.mp4"
        }

        public fun getFilePath2(): String {
            return CONTEXT!!.cacheDir.absolutePath + "/mvtest_2.mp4"
        }
    }
}
