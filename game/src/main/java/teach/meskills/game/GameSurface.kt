package teach.meskills.game

import android.content.Context
import android.view.SurfaceView
import android.view.SurfaceHolder
import android.graphics.BitmapFactory
import android.graphics.Canvas

class GameSurface(context: Context?) : SurfaceView(context), SurfaceHolder.Callback {
    private var gameThread: GameThread? = null
    private var chibi1: ChibiCharacter? = null

    fun update() {
        chibi1!!.update()
    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        chibi1!!.draw(canvas)
    }

    // Implements method of SurfaceHolder.Callback
    override fun surfaceCreated(holder: SurfaceHolder) {
        val chibiBitmap1 = BitmapFactory.decodeResource(this.resources, R.drawable.chibi1)
        chibi1 = ChibiCharacter(this, chibiBitmap1, 100, 50)
        gameThread = GameThread(this, holder)
        gameThread!!.setRunning(true)
        gameThread!!.start()
    }

    // Implements method of SurfaceHolder.Callback
    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {}

    // Implements method of SurfaceHolder.Callback
    override fun surfaceDestroyed(holder: SurfaceHolder) {
        var retry = true
        while (retry) {
            try {
                gameThread!!.setRunning(false)

                // Parent thread must wait until the end of GameThread.
                gameThread!!.join()
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            retry = true
        }
    }

    init {
        // Make Game Surface focusable so it can handle events. .
        this.isFocusable = true

        // Sét callback.
        this.holder.addCallback(this)
    }
}