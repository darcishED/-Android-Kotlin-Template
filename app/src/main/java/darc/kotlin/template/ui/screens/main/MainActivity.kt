package darc.kotlin.template.ui.screens.main

import android.os.Bundle
import darc.kotlin.template.databinding.ActivityMainBinding
import darc.kotlin.template.ui.base.BaseActivity
import darc.kotlin.template.ui.utils.ThemeManager

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        ThemeManager[this] = appTheme
        setContentView(binding.root)
    }
}
