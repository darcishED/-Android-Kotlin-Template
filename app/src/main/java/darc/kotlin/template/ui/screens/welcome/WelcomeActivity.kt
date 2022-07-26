package darc.kotlin.template.ui.screens.welcome

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import darc.kotlin.template.R
import darc.kotlin.template.databinding.ActivityWelcomeBinding
import darc.kotlin.template.ui.base.BaseActivity
import darc.kotlin.template.ui.utils.ThemeManager

class WelcomeActivity : BaseActivity() {

    private lateinit var binding: ActivityWelcomeBinding
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_welcome) as NavHostFragment
        navController = navHostFragment.navController
        ThemeManager[this] = appTheme
        setContentView(binding.root)
    }

    override fun onBackPressed() {
        val fragment = navHostFragment.childFragmentManager.fragments.firstOrNull()
        if (fragment is WelcomeFragment && fragment.onBackPressed()) super.onBackPressed()
    }
}
