package com.morphine_coder.build_logic.convention

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.BuildType
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

/**
 * Create by jaehyeon.
 * Date: 2024. 9. 20.
 */
internal fun Project.configureBuildTypes(
    commonExtension: CommonExtension<*, *, *, *, *, *>,
    extensionTypes: ExtensionTypes,
) {
    commonExtension.run {

        buildFeatures {
            buildConfig = true
            flavorDimensions += FlavorDimension.CONTENT_TYPE.dimensionName
        }

        when (extensionTypes) {
            ExtensionTypes.APPLICATION -> {
                extensions.configure<ApplicationExtension>() {
                    buildTypes {
                        debug {
                            configureDebugBuildType()
                            applicationIdSuffix = FlavorTypes.DEV.idSuffix
                        }
                        create("stage") {
                            configureStageBuildType()
                            applicationIdSuffix = FlavorTypes.STG.idSuffix
                        }
                        release {
                            configureReleaseBuildType(commonExtension)
                        }
                    }
                }
            }

            ExtensionTypes.LIBRARY -> {
                extensions.configure<LibraryExtension>() {
                    buildTypes {
                        debug {
                            configureDebugBuildType()
                        }
                        create("stage") {
                            configureStageBuildType()
                        }
                        release {
                            configureReleaseBuildType(commonExtension)
                        }
                    }
                }
            }
        }

        productFlavors {

        }
    }

}

private fun BuildType.configureDebugBuildType() {
    buildConfigField("String", "BASE_URL", "\"TEST_URL\"" )
}

private fun BuildType.configureStageBuildType() {
    buildConfigField("String", "BASE_URL", "\"STAGE_URL\"" )
}

private fun BuildType.configureReleaseBuildType(
    commonExtension: CommonExtension<*, *, *, *, *, *>,
) {
    buildConfigField("String", "BASE_URL", "\"BASE_URL\"" )

    isMinifyEnabled = true
    proguardFiles(
        commonExtension.getDefaultProguardFile("proguard-android-optimize.txt"),
        "proguard-rules.pro"
    )
}