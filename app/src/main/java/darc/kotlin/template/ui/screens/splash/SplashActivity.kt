package darc.kotlin.template.ui.screens.splash

import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import darc.kotlin.template.ui.base.BaseActivity

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            installSplashScreen().setKeepOnScreenCondition { true }
        }
        super.onCreate(savedInstanceState)
        Handler(Looper.getMainLooper()).postDelayed({
            navigateToWelcome(); finish()
        }, 2000)
    }
}
