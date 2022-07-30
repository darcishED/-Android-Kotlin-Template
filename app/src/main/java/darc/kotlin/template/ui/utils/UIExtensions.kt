package darc.kotlin.template.ui.utils

import android.content.Context
import android.graphics.Paint
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import darc.kotlin.template.ui.utils.models.SnackAction
import java.util.*

object UIExtensions {

    fun Context.makeToast(message: String, isLong: Boolean = false) {
        Toast.makeText(this, message, if (isLong) Toast.LENGTH_LONG else Toast.LENGTH_SHORT).show()
    }

    fun View.makeSnack(
        message: String,
        duration: Int = Snackbar.LENGTH_SHORT,
        backgroundColor: Int? = null,
        textColor: Int? = null,
        textSize: Float? = null,
        action: SnackAction? = null
    ) {

        Snackbar.make(this, message, duration).apply {
            if (action != null) {
                setAction(action.text, action.clickListener)
                setActionTextColor(action.textColor)
            }
            view.findViewById<TextView>(com.google.android.material.R.id.snackbar_text).let { tv ->
                if (textColor != null) tv.setTextColor(textColor)
                if (textSize != null) tv.textSize = textSize
            }
            if (backgroundColor != null) view.setBackgroundColor(backgroundColor)
        }.show()
    }

    fun TextView.strikeThrough() {
        paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
    }

    fun randomString(sizeOfRandomString: Int) = run {
        val characters = "0123456789qwertyuiopasdfghjklzxcvbnm"
        val random = Random()
        val sb = StringBuilder(sizeOfRandomString)
        for (i in 0 until sizeOfRandomString)
            sb.append(characters[random.nextInt(characters.length)])
        "$sb"
    }

    fun String.shuffle() = StringBuilder(length).let { output ->
        val characters: MutableList<Char> = ArrayList()
        for (c in toCharArray()) characters.add(c)
        while (characters.size != 0)
            output.append(characters.removeAt((Math.random() * characters.size).toInt()))
        "$output"
    }
}
