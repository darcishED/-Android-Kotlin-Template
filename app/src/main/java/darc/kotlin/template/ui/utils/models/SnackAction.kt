package darc.kotlin.template.ui.utils.models

import android.view.View

data class SnackAction(
    var text: String,
    var textColor: Int,
    var clickListener: View.OnClickListener? = null
)
