package teach.meskills.square

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class Draw2D(context: Context?) : View(context) {
    private val paint: Paint = Paint()
    private var xPosition = 150
    private var yPosition = 50
    private var xPosition2 = 500
    private var yPosition2 = 600
    private var xPosition3 = 350
    private var yPosition3 = 150
    private var xMove = 10
    private var yMove = 10
    private var xMove2 = xMove * 2
    private var yMove2 = yMove * 2
    private var xMove3 = xMove * 4
    private var yMove3 = yMove * 4
    private val scale = resources.displayMetrics.xdpi
    private val ballRadius = 100 / (scale / 160)


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.apply {
            style = Paint.Style.FILL
            color = Color.WHITE
        }
        canvas?.drawPaint(paint)
        paint.apply {
            isAntiAlias = true
            color = Color.RED
        }
        canvas?.drawCircle(xPosition.toFloat(), yPosition.toFloat(), ballRadius, paint)
        paint.apply {
            isAntiAlias = true
            color = Color.BLUE
        }
        canvas?.drawCircle(xPosition2.toFloat(), yPosition2.toFloat(), ballRadius, paint)
        paint.apply {
            isAntiAlias = true
            color = Color.BLACK
        }
        canvas?.drawCircle(xPosition3.toFloat(), yPosition3.toFloat(), ballRadius, paint)
        invalidate()
    }

    fun update() {
        xPosition += xMove
        yPosition += yMove
        xPosition2 += xMove2
        yPosition2 += yMove2
        xPosition3 += xMove3
        yPosition3 += yMove3
        if (xPosition + xMove > width - ballRadius || xPosition + xMove < ballRadius) {
            xMove = -xMove
        }
        if (xPosition2 + xMove2 > width - ballRadius || xPosition2 + xMove2 < ballRadius) {
            xMove2 = -xMove2
        }
        if (xPosition3 + xMove3 > width - ballRadius || xPosition3 + xMove3 < ballRadius) {
            xMove3 = -xMove3
        }
        if (yPosition + yMove > height - ballRadius || yPosition + yMove < ballRadius) {
            yMove = -yMove
        }
        if (yPosition2 + yMove2 > height - ballRadius || yPosition2 + yMove2 < ballRadius) {
            yMove2 = -yMove2
        }
        if (yPosition3 + yMove3 > height - ballRadius || yPosition3 + yMove3 < ballRadius) {
            yMove3 = -yMove3
        }
    }
}
