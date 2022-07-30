package darc.kotlin.template.ui.screens.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.viewpager2.widget.ViewPager2
import darc.kotlin.template.R
import darc.kotlin.template.databinding.FragmentWelcomeBinding
import darc.kotlin.template.ui.base.BaseActivity
import darc.kotlin.template.ui.base.BaseFragment
import darc.kotlin.template.ui.utils.FadeOutTransformer
import darc.kotlin.template.ui.utils.UIExtensions.shuffle

class WelcomeFragment : BaseFragment() {

    private var _binding: FragmentWelcomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var welcomePagerAdapter: WelcomePagerAdapter
    private val onPageChangeCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            binding.tvTitleWelcome.text = "Welcome screen ${position + 1}"
            binding.tvMessageWelcome.text =
                "Lorem ipsum dolor sit amet, ${"consectetur adipiscing elit. Mauris eleifend eros felis, sed tincidunt arcu faucibus nec.".shuffle()}"
            binding.tvBtnSkip.isVisible = position != 2
            binding.tvBtnNext.text = getString(if (position == 2) R.string.start else R.string.next)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ) = with(FragmentWelcomeBinding.inflate(inflater, container, false)) {
        _binding = this; root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        welcomePagerAdapter = WelcomePagerAdapter(this)
        initView()
    }

    fun onBackPressed() = run {
        if (binding.viewPagerWelcome.currentItem == 0) true
        else {
            binding.viewPagerWelcome.currentItem--; false
        }
    }

    private fun initView() = binding.apply {
        if (viewPagerWelcome.currentItem == 0) {
            tvTitleWelcome.text = "Welcome screen 1"
            binding.tvMessageWelcome.text =
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris eleifend eros felis, sed tincidunt arcu faucibus nec."
        }
        setupViewpager()
        setupOnClickListeners()
    }

    private fun setupViewpager() = binding.viewPagerWelcome.apply {
        setPageTransformer(FadeOutTransformer())
        adapter = welcomePagerAdapter
        registerOnPageChangeCallback(onPageChangeCallback)
        binding.pageIndicatorWelcome.setViewPager(this)
    }

    private fun setupOnClickListeners() {
        binding.tvBtnNext.setOnClickListener {
            if (binding.viewPagerWelcome.currentItem == 2) (activity as BaseActivity?)?.apply {
                // Mark as welcomed in preferences
                navigateToAuth(); finish()
            } else binding.viewPagerWelcome.currentItem++
        }
        binding.tvBtnSkip.setOnClickListener {
            (activity as BaseActivity?)?.navigateToAuth()
        }
    }
}
