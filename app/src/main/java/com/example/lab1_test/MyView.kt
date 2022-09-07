package com.example.lab1_test

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import kotlin.random.Random

class MyView : View {

    var rect = Rect(10, 10, 110, 110)

    var circle_x = 100F
    var circle_y = 100F
    var circle_r = 50F //circle

    var triangle_x = 100F
    var triangle_y = 100F
    var triangle_w = 100F //triangle


    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val paint = Paint()
        paint.color = Color.BLUE
        //canvas.drawRect(rect, paint)

        var random = Random.nextInt(3) + 1

        when (random) {
            1 -> {
                canvas.drawRect(rect, paint)
            }
            2 -> {
                canvas.drawCircle(circle_x, circle_y, circle_r, paint)
            }
            3 -> {
                var hw = triangle_w/2
                var path = Path()
                path.moveTo(triangle_x, triangle_y - hw)
                path.lineTo(triangle_x - hw, triangle_y + hw)
                path.lineTo(triangle_x + hw, triangle_y + hw)
                path.lineTo(triangle_x, triangle_y - hw)
                path.close()
                canvas.drawPath(path, paint)
            }
        }
    }


    override fun onTouchEvent(event: MotionEvent): Boolean {
        if(event.action == MotionEvent.ACTION_DOWN || event.action == MotionEvent.ACTION_MOVE) {
            rect.left = event.x.toInt()
            rect.top = event.y.toInt()
            rect.right = rect.left + 100
            rect.bottom = rect.top + 100

            circle_x = event.x.toFloat() //circle
            circle_y = event.y.toFloat()

            triangle_x = event.x.toFloat() //triangle
            triangle_y = event.y.toFloat()

            invalidate()
            return true
        }
        return super.onTouchEvent(event)
    }

}