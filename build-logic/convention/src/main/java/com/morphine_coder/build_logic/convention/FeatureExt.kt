package com.morphine_coder.build_logic.convention

import org.gradle.api.Project
import org.gradle.kotlin.dsl.DependencyHandlerScope

/**
 * Create by jaehyeon.
 * Date: 2024. 9. 20.
 */
fun DependencyHandlerScope.addFeatureDependencies(project: Project) {
    add("implementation", project.libs.findBundle("compose").get())
    add("implementation", project.libs.findBundle("firebase").get())
    add("implementation", project.libs.findLibrary("androidx.appcompat").get())
    add("implementation", project.libs.findLibrary("androidx.core.ktx").get())
    add("implementation", project.libs.findLibrary("androidx.lifecycle.runtime.ktx").get())
}