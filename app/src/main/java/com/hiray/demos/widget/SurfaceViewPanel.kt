package com.hiray.demos.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.text.TextPaint
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceView
import com.hiray.demos.R

/**
 * Created by hiray on 2018/5/24.
 *@author hiray
 */
class SurfaceViewPanel : SurfaceView, Runnable, SurfaceHolder.Callback {

    var mHolder: SurfaceHolder? = null
    var isRunning: Boolean = false
    var mThread: Thread? = null
    var mCanvas: Canvas? = null
    var mRadius: Int = 0
    var mStartAngle = 0
    var mPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var mTextPaint = TextPaint(Paint.ANTI_ALIAS_FLAG)
    val mTexts = arrayListOf<String>("iPad", "Mac", "iPhone", "OPPO", "谢谢参与")
    val mImages = arrayListOf<Int>(R.mipmap.ipad, R.mipmap.mac, R.mipmap.iphone, R.mipmap.oppo, R.mipmap.thanks)

    override fun run() {

        while (isRunning) {
            val startTime = System.currentTimeMillis()
            drawPanel()
            val endTime = System.currentTimeMillis()
            if (endTime - startTime < 100) {
                Thread.sleep(100 - endTime + startTime)
            }
        }
    }

    private fun drawPanel() {

        mCanvas = mHolder?.lockCanvas()
        var angle = mStartAngle
        for (img in mImages) {
            mCanvas.drawArc()
        }

    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        setMeasuredDimension(mRadius * 2 + paddingLeft + paddingRight, mRadius * 2 + paddingTop + paddingBottom)
    }

    override fun surfaceChanged(holder: SurfaceHolder?, format: Int, width: Int, height: Int) {

    }

    override fun surfaceDestroyed(holder: SurfaceHolder?) {
    }

    override fun surfaceCreated(holder: SurfaceHolder?) {
        mPaint.style = Paint.Style.FILL_AND_STROKE
        mTextPaint.style = Paint.Style.FILL_AND_STROKE
        isRunning = true
        mThread = Thread(this)
        mThread?.start()
    }


    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        mHolder = holder
        mHolder?.addCallback(this)
        keepScreenOn = true
        isFocusableInTouchMode = true

    }
}