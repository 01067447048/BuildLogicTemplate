package com.morphine_coder.build_logic.convention

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.dependencies

/**
 * Create by jaehyeon.
 * Date: 2024. 9. 20.
 */
internal fun Project.configureAndroidCompose(
    commonExtension: CommonExtension<*, *, *, *, *, *>
) {
    commonExtension.run {

        buildFeatures {
            compose = true
        }

        dependencies {
            val bom = libs.findLibrary("androidx.compose.bom").get()
            add("implementation", platform(bom))
            add("androidTestImplementation", platform(bom))
            add("debugImplementation", libs.findLibrary("androidx.ui.tooling.preview").get())
        }
    }
}

fun DependencyHandlerScope.addUiLayerDependencies(project: Project) {
    // todo add ui layer dependencies (Ex. DesignSystem)
    add("implementation", project.libs.findBundle("compose").get())
    add("debugImplementation", project.libs.findBundle("compose.debug").get())
    add("androidTestImplementation", project.libs.findLibrary("androidx.ui.test.junit4").get())
}