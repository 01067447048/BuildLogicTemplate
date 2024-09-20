import com.android.build.api.dsl.LibraryExtension
import com.morphine_coder.build_logic.convention.configureAndroidCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.getByType

/**
 * Create by jaehyeon.
 * Date: 2024. 9. 20.
 */
/**
 * 실제 화면은 없지만
 * Compose 를 사용 하는 모듈에 대한 설정을 하는 플러그인 (ex. DesignSystem)
 */
class AndroidLibraryComposeConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        target.run {
            pluginManager.run {
                apply("multi.module.android.library")
                apply("org.jetbrains.kotlin.plugin.compose")
            }

            extensions.getByType<LibraryExtension>().run {
                configureAndroidCompose(this)
            }
        }
    }
}