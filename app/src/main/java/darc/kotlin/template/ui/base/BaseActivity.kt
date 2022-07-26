package darc.kotlin.template.ui.base

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.google.gson.Gson
import darc.kotlin.template.ui.screens.auth.AuthActivity
import darc.kotlin.template.ui.screens.main.MainActivity
import darc.kotlin.template.ui.screens.welcome.WelcomeActivity
import darc.kotlin.template.ui.utils.enums.AppTheme

abstract class BaseActivity : AppCompatActivity() {
    var appTheme = AppTheme.SYSTEM_DEFAULT

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appTheme = Gson().fromJson(
            (intent.extras ?: savedInstanceState)?.getString("app_theme"), AppTheme::class.java
        ) ?: AppTheme.SYSTEM_DEFAULT

        val isLight = (appTheme == AppTheme.LIGHT)
                || (appTheme == AppTheme.SYSTEM_DEFAULT && (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK != Configuration.UI_MODE_NIGHT_YES))
        if (isLight) WindowCompat.getInsetsController(window, window.decorView)
            .isAppearanceLightStatusBars = isLight
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("app_theme", Gson().toJson(appTheme))
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        appTheme = Gson().fromJson(savedInstanceState.getString("app_theme"), AppTheme::class.java)
            ?: AppTheme.SYSTEM_DEFAULT
    }

    fun navigateToWelcome() {
        startActivity(Intent(this, WelcomeActivity::class.java))
    }

    fun navigateToAuth() {
        startActivity(Intent(this, AuthActivity::class.java))
    }

    fun navigateToMain(appTheme: AppTheme) {
        startActivity(Intent(this, MainActivity::class.java).apply {
            putExtra("app_theme", Gson().toJson(appTheme))
        })
    }
}
