package darc.kotlin.template.ui.screens.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import darc.kotlin.template.databinding.FragmentWelcomeSecondBinding
import darc.kotlin.template.ui.base.BaseFragment

class SecondScreenFragment : BaseFragment() {

    private var _binding: FragmentWelcomeSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = with(FragmentWelcomeSecondBinding.inflate(inflater, container, false)) {
        _binding = this; root
    }

    companion object {
        val instance = SecondScreenFragment()
    }
}
