import org.gradle.api.Plugin
import org.gradle.api.Project

class DependenciesLoader : Plugin<Project> {
    override fun apply(target: Project) {}

    companion object {
        private const val versionMajor = 0
        private const val versionMinor = 1
        private const val versionPatch = 0
        private var versionClassifier: String? = ""
        private var isSnapshot = false

        fun generateVersionCode() =
            AndroidConfig.MIN_SDK * 10000000 + versionMajor * 10000 + versionMinor * 100 + versionPatch

        fun generateVersionName(): String {
            var versionName = "${versionMajor}.${versionMinor}.${versionPatch}"
            if (versionClassifier == null && isSnapshot) versionClassifier = "-SNAPSHOT"
            if (versionClassifier != null) versionName += "$versionClassifier"
            return versionName
        }
    }
}

object AndroidConfig {
    const val ID = "darc.kotlin.template"
    const val ID_SUFFIX_STAGING = ".staging"
    const val ID_SUFFIX_DEBUG = ".debug"
    const val NAME_SUFFIX_STAGING = "_s"
    const val NAME_SUFFIX_DEBUG = "_d"

    const val KEYSTORE_PATH_RELEASE = "../docs/release.keystore.jks"
    const val KEYSTORE_PATH_STAGING = "../docs/staging.keystore.jks"
    const val KEYSTORE_PATH_DEBUG = "../docs/debug.keystore"

    const val MIN_SDK = 17
    const val COMPILE_SDK = 32
    const val TARGET_SDK = 32

    const val TEST_INSTRUMENTATION_RUNNER = "androidx.test.runner.AndroidJUnitRunner"

    val versionCode = DependenciesLoader.generateVersionCode()
    val versionName = DependenciesLoader.generateVersionName()
}

object Versions {
    const val APP_COMPAT = "1.4.2"
    const val CONSTRAINTS = "2.1.4"
    const val CORE_KTX = "1.8.0"
    const val GSON = "2.9.0"
    const val INTUIT = "1.1.0"
    const val KOIN = "3.2.0"
    const val KOTLINX_COROUTINES = "1.6.3"
    const val LIFECYCLE_EXTENSIONS = "2.2.0"
    const val LIFECYCLE_KTX = "2.5.0"
    const val MATERIAL = "1.6.1"
    const val MULTIDEX = "2.0.1"
    const val NAVIGATION = "2.5.0"
    const val RECYCLERVIEW = "1.2.1"
    const val SPLASHSCREEN = "1.0.0-rc01"
    const val TIMBER = "5.0.1"

    const val COROUTINES_TEST = "1.6.3"
    const val ESPRESSO = "3.4.0"
    const val J_UNIT_TEST = "1.1.3"
    const val J_UNIT = "4.13.2"
}

object Dependencies {
    const val appCompat = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"
    const val constraints = "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINTS}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.CORE_KTX}"
    const val gson = "com.google.code.gson:gson:${Versions.GSON}"
    const val intuitSdp = "com.intuit.sdp:sdp-android:${Versions.INTUIT}"
    const val intuitSsp = "com.intuit.ssp:ssp-android:${Versions.INTUIT}"
    const val koin = "io.insert-koin:koin-android:${Versions.KOIN}"
    const val kotlinxCoroutines =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.KOTLINX_COROUTINES}"
    const val lifecycleCommon = "androidx.lifecycle:lifecycle-common:${Versions.LIFECYCLE_KTX}"
    const val lifecycleExtensions =
        "androidx.lifecycle:lifecycle-extensions:${Versions.LIFECYCLE_EXTENSIONS}"
    const val lifecycleLivedata =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIFECYCLE_KTX}"
    const val lifecycleViewmodel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE_KTX}"
    const val lifecycleRuntime =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFECYCLE_KTX}"
    const val material = "com.google.android.material:material:${Versions.MATERIAL}"
    const val multidex = "androidx.multidex:multidex:${Versions.MULTIDEX}"
    const val navigationFragment = "androidx.navigation:navigation-fragment:${Versions.NAVIGATION}"
    const val navigationUI = "androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.RECYCLERVIEW}"
    const val splashScreen = "androidx.core:core-splashscreen:${Versions.SPLASHSCREEN}"
    const val timber = "com.jakewharton.timber:timber:${Versions.TIMBER}"
}

object TestDependencies {
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO}"
    const val jUnitTest = "androidx.test.ext:junit:${Versions.J_UNIT_TEST}"
    const val coroutinesTest =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.COROUTINES_TEST}"
    const val jUnit = "junit:junit:${Versions.J_UNIT}"
}
