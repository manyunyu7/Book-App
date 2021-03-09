package com.firriezky.submission1_intro.Util

import android.app.Activity
import android.graphics.*
import android.os.Build
import android.view.WindowInsets
import android.view.WindowManager
import androidx.core.content.ContextCompat


class Util {

    companion object{


        fun setStatusBarColor( mContext : Activity,color : Int ){
            //Set Fullscreen
            @Suppress("DEPRECATION")
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                mContext.window.insetsController?.hide(WindowInsets.Type.statusBars())
            } else {
                mContext.window.setFlags(
                    WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN
                )
            }
            mContext.window.statusBarColor = ContextCompat.getColor(mContext,color)

        }


        fun getRoundedCornerBitmap(bitmap: Bitmap, pixels: Int): Bitmap? {
            val output = Bitmap.createBitmap(
                bitmap.width, bitmap
                    .height, Bitmap.Config.ARGB_8888
            )
            val canvas = Canvas(output)
            val color = -0xbdbdbe
            val paint = Paint()
            val rect = Rect(0, 0, bitmap.width, bitmap.height)
            val rectF = RectF(rect)
            val roundPx = pixels.toFloat()
            paint.isAntiAlias = true
            canvas.drawARGB(0, 0, 0, 0)
            paint.color = color
            canvas.drawRoundRect(rectF, roundPx, roundPx, paint)
            paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
            canvas.drawBitmap(bitmap, rect, rect, paint)
            return output
        }



    }


}