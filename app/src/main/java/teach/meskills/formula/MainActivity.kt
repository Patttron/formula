package teach.meskills.formula

import android.animation.Animator
import android.os.Bundle
import android.view.animation.*
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        go.setOnClickListener {
            bolide()
        }

        reset.setOnClickListener {
            bolide1.x = 0f
            bolide2.x = 0f
            bolide3.x = 0f
        }
    }

    private fun bolide() {
        var isWin = false
        bolide1.animate().setDuration(Random.nextLong(5000)).apply {
            setListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator?) {}

                override fun onAnimationEnd(animation: Animator?) {
                    if(!isWin) {
                        Toast.makeText(this@MainActivity, "Bolid 1 win", LENGTH_SHORT).show()
                        isWin = true
                    }
                }

                override fun onAnimationCancel(animation: Animator?) {}

                override fun onAnimationRepeat(animation: Animator?) {}

            })
        }
            .translationX(finish.x - bolide1.width)
            .setInterpolator(AnticipateInterpolator())

        bolide2.animate().setDuration(Random.nextLong(5000))
            .apply {
                setListener(object : Animator.AnimatorListener {
                    override fun onAnimationStart(animation: Animator?) {}

                    override fun onAnimationEnd(animation: Animator?) {
                        if(!isWin) {
                            Toast.makeText(this@MainActivity, "Bolid 2 win", LENGTH_SHORT).show()
                            isWin = true
                        }
                    }

                    override fun onAnimationCancel(animation: Animator?) {}

                    override fun onAnimationRepeat(animation: Animator?) {}

                })
            }
            .translationX(finish.x - bolide2.width)
            .setInterpolator(LinearInterpolator())

        bolide3.animate().setDuration(Random.nextLong(5000)).apply {
            setListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator?) {}

                override fun onAnimationEnd(animation: Animator?) {
                    if(!isWin) {
                        Toast.makeText(this@MainActivity, "Bolid 3 win", LENGTH_SHORT).show()
                        isWin = true
                    }
                }

                override fun onAnimationCancel(animation: Animator?) {}

                override fun onAnimationRepeat(animation: Animator?) {}
            })
        }
            .translationX(finish.x - bolide3.width)
            .setInterpolator(AccelerateInterpolator())
    }
}