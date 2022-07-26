package darc.kotlin.template.ui.screens.welcome

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class WelcomePagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount() = 3
    override fun createFragment(position: Int) = when (position) {
        1 -> SecondScreenFragment.instance
        2 -> ThirdScreenFragment.instance
        else -> FirstScreenFragment.instance
    }
}
