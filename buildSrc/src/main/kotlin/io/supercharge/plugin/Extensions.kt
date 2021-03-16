package io.supercharge.plugin

import com.android.build.api.dsl.ApplicationBuildFeatures
import com.android.build.api.dsl.CommonExtension
import com.android.build.gradle.BaseExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

object Extensions {
    fun Project.android(action: BaseExtension.() -> Unit) = extensions.configure(action)

    fun BaseExtension.applicationBuildFeatures(action: ApplicationBuildFeatures.() -> Unit) {
        @Suppress("UNCHECKED_CAST")
        (this as CommonExtension<*, ApplicationBuildFeatures, *, *, *, *, *, *>).buildFeatures(action)
    }
    val Project.android
        get() = extensions.getByType(BaseExtension::class.java)
}
