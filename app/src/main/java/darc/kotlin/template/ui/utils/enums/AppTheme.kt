package darc.kotlin.template.ui.utils.enums

enum class AppTheme(val rawValue: String) {
    LIGHT("light"), DARK("dark"), SYSTEM_DEFAULT("system_default");

    companion object {
        fun String.getAppTheme() = when (this) {
            LIGHT.rawValue -> LIGHT
            DARK.rawValue -> DARK
            else -> SYSTEM_DEFAULT
        }
    }
}
