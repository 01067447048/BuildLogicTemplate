import com.android.build.api.dsl.LibraryExtension
import com.morphine_coder.build_logic.convention.ExtensionTypes
import com.morphine_coder.build_logic.convention.configureBuildTypes
import com.morphine_coder.build_logic.convention.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

/**
 * Create by jaehyeon.
 * Date: 2024. 9. 20.
 */
class AndroidLibraryConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        target.run {
            pluginManager.run {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<LibraryExtension>() {
                configureKotlinAndroid(this)

                configureBuildTypes(
                    commonExtension = this,
                    extensionTypes = ExtensionTypes.LIBRARY
                )

                defaultConfig {
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                    consumerProguardFiles("consumer-rules.pro")
                }
            }
        }
    }

}