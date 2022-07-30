package darc.kotlin.template.ui.utils

import android.view.View
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs

class FadeOutTransformer : ViewPager2.PageTransformer {

    override fun transformPage(view: View, position: Float) {
        view.apply {
            when {
                position < -1 -> alpha = 0f
                position <= 0 -> {
                    alpha = 1f
                    translationX = 0f
                    scaleX = 1f
                    scaleY = 1f
                }
                position <= 1 -> {
                    alpha = 1 - position
                    translationX = width * -position
                    val scaleFactor = (0.75f + (1 - 0.75f) * (1 - abs(position)))
                    scaleX = scaleFactor
                    scaleY = scaleFactor
                }
                else -> alpha = 0f
            }
        }
    }
}
