import com.android.build.api.dsl.ApplicationExtension
import com.morphine_coder.build_logic.convention.configureAndroidCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.getByType

/**
 * Create by jaehyeon.
 * Date: 2024. 9. 20.
 */
class AndroidApplicationComposeConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        target.run {
            pluginManager.run {
                apply("multi.module.android.application")
                apply("org.jetbrains.kotlin.plugin.compose")
            }

            extensions.getByType<ApplicationExtension>().run {
                configureAndroidCompose(this)
            }
        }
    }
}