package teach.meskills.formula

import android.os.Bundle
import android.view.animation.*
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat.animate
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val d1 = Random.nextLong(5000)
        val d2 = Random.nextLong(5000)
        val d3 = Random.nextLong(5000)

        go.setOnClickListener {
            findViewById<ImageView>(R.id.bolid1).animate().setDuration(d1)
                .translationX(finish.x - bolid1.width)
                .setInterpolator(AnticipateInterpolator())
                .start()
            findViewById<ImageView>(R.id.bolid2).animate().setDuration(d2)
                .translationX(finish.x - bolid2.width)
                .setInterpolator(LinearInterpolator())
                .start()
            findViewById<ImageView>(R.id.bolid3).animate().setDuration(d3)
                .translationX(finish.x - bolid3.width)
                .setInterpolator(AccelerateInterpolator())
                .start()

//            if (bolid1.x + bolid3.width == finish.x) {
//                Toast.makeText(this, "Bolid 9 win", LENGTH_SHORT).show()
//            }
//            whoWin()
//            ValueAnimator.ofFloat(0f, finish.x - bolid1.width).apply {
//                duration = 3000
//                addUpdateListener {
//                    bolid3.translationX = it.animatedValue as Float
//                }
//                start()
//            }
        }
        reset.setOnClickListener {
            bolid1.x = 0f
            bolid2.x = 0f
            bolid3.x = 0f
        }
        if(bolid1.animate().duration < bolid2.animate().duration)
        {
            Toast.makeText(this, "Bolid 1 win", LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(this, "Bolid 2 win", LENGTH_SHORT).show()
        }
    }

    private fun whoWin() {
        when (finish.x) {
            bolid1.x + bolid1.width -> Toast.makeText(this, "Bolid 1 win", LENGTH_SHORT).show()
            bolid2.x + bolid2.width -> Toast.makeText(this, "Bolid 2 win", LENGTH_SHORT).show()
            bolid3.x + bolid3.width -> Toast.makeText(this, "Bolid 3 win", LENGTH_SHORT).show()

//            else -> {
//                Toast.makeText(this, "Bolid loh win", LENGTH_SHORT).show()
//            }
        }
    }
}
