package com.cxp.learningvideo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Toast
import com.cxp.learningvideo.utils.CopyFileUtils
import com.yanzhenjie.permission.AndPermission
import com.yanzhenjie.permission.Permission
import java.io.File
import java.io.IOException

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestPermission()
        copyTestMp4()
        copyTest2Mp4()
    }

    private fun copyTest2Mp4() {
        val fileName = "mvtest.mp4"
        val file = File(cacheDir.absolutePath, "mvtest_2.mp4")
        Log.w(TAG, "copy file start ..")
        if (!file.exists()) {
            try {
                Log.w(TAG, "copy file: ")
                CopyFileUtils.copyFile(assets.open(fileName), file)
            } catch (e: IOException) {
                e.printStackTrace()
                return
            }
        }

    }

    private fun copyTestMp4() {
        val fileName = "mvtest.mp4"
        val file = File(cacheDir.absolutePath, fileName)
        Log.w(TAG, "copy file start ..")
        if (!file.exists()) {
            try {
                Log.w(TAG, "copy file: ")
                CopyFileUtils.copyFile(assets.open(fileName), file)
            } catch (e: IOException) {
                e.printStackTrace()
                return
            }
        }
    }

    private fun requestPermission() {
        val permissions = Permission.Group.STORAGE
        AndPermission.with(this)
            .runtime()
            .permission(permissions)
            .onGranted {
            }
            .onDenied {
                Toast.makeText(this, "请打开权限，否则无法获取本地文件", Toast.LENGTH_SHORT).show()
            }
            .start()
    }

    fun clickSimplePlayer(view: View) {
        startActivity(Intent(this, SimplePlayerActivity::class.java))
    }

    fun clickSimpleTriangle(view: View) {
        val intent = Intent(this, SimpleRenderActivity::class.java)
        intent.putExtra("type", 0)
        startActivity(intent)
    }

    fun clickSimpleTexture(view: View) {
        val intent = Intent(this, SimpleRenderActivity::class.java)
        intent.putExtra("type", 1)
        startActivity(intent)
    }

    fun clickOpenGLPlayer(view: View?) {
        startActivity(Intent(this, OpenGLPlayerActivity::class.java))
    }

    fun clickMultiOpenGLPlayer(view: View?) {
        startActivity(Intent(this, MultiOpenGLPlayerActivity::class.java))
    }

    fun clickEGLPlayer(view: View?) {
        startActivity(Intent(this, EGLPlayerActivity::class.java))
    }

    fun clickSoulPlayer(view: View?) {
        startActivity(Intent(this, SoulPlayerActivity::class.java))
    }

    fun clickEncoder(view: View?) {
        startActivity(Intent(this, SynthesizerActivity::class.java))
    }

    fun clickFFmpegInfo(view: View?) {
        startActivity(Intent(this, FFmpegActivity::class.java))
    }

    fun clickFFmpegGLPlayer(view: View?) {
        startActivity(Intent(this, FFmpegGLPlayerActivity::class.java))
    }

    fun clickFFmpegRepack(view: View?) {
        startActivity(Intent(this, FFRepackActivity::class.java))
    }

    fun clickFFmpegEncode(view: View?) {
        startActivity(Intent(this, FFEncodeActivity::class.java))
    }
}
