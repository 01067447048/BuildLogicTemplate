package com.morphine_coder.build_logic.convention

/**
 * Create by jaehyeon.
 * Date: 2024. 9. 20.
 */

enum class FlavorTypes(val dimension: FlavorDimension, val idSuffix: String? = null) {
    DEV(FlavorDimension.CONTENT_TYPE, ".dev"),
    STG(FlavorDimension.CONTENT_TYPE, ".stg"),
    PROD(FlavorDimension.CONTENT_TYPE),
}

enum class FlavorDimension(val dimensionName: String) {
    CONTENT_TYPE("contentType"),
}