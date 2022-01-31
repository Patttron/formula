package teach.meskills.game

import android.graphics.Bitmap

abstract class GameObject(
    var image: Bitmap,
    private val rowCount: Int,
    val colCount: Int,
    var x: Int,
    var y: Int
) {
    private val WIDTH: Int = image.width
    private val HEIGHT: Int = image.height
    val width: Int = WIDTH / colCount
    val height: Int = HEIGHT / rowCount

    fun createSubImageAt(row: Int, col: Int): Bitmap {
        // createBitmap(bitmap, x, y, width, height).
        return Bitmap.createBitmap(image, col * width, row * height, width, height)
    }
}