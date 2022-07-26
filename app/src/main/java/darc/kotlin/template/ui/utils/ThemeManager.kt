package darc.kotlin.template.ui.utils

import android.content.Context
import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import darc.kotlin.template.R
import darc.kotlin.template.ui.utils.enums.AppTheme

internal object ThemeManager {

    operator fun set(context: Context, appTheme: AppTheme) {
        context.setTheme(
            when (appTheme) {
                AppTheme.LIGHT -> R.style.AppTheme_Light
                AppTheme.DARK -> R.style.AppTheme_Dark
                else -> {
                    if (context.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK == UI_MODE_NIGHT_YES)
                        R.style.AppTheme_Dark
                    else R.style.AppTheme_Light
                }
            }
        )
    }
}
