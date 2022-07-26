package darc.kotlin.template.di

import darc.kotlin.template.ui.shared.SharedMainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object Modules {

    val appModule = module {
        viewModel { SharedMainViewModel() }
    }
}
