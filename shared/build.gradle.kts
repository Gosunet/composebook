plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidMultiplatformLibrary)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
}

kotlin {
    @OptIn(org.jetbrains.kotlin.gradle.ExperimentalWasmDsl::class)
    wasmJs { browser() }

    android {
        namespace = "com.gosunet.composebook.shared"
        compileSdk = libs.versions.android.compileSdk.get().toInt()
        androidResources {
            enable = true
        }
    }

    jvm()

    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "Shared"
            isStatic = true
            freeCompilerArgs += "-Xbinary=bundleId=com.gosunet.composebook"
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(libs.compose.runtime)
            implementation(libs.compose.foundation)
            implementation(libs.compose.material)
            implementation(libs.compose.material.icons.extended)
            implementation(libs.compose.ui)
            implementation(libs.compose.material3)
            implementation(libs.compose.resources)
            implementation(libs.compose.navigation)
            implementation(libs.kodein.emoji)
            implementation(libs.kodein.emoji.compose)
            implementation(libs.compose.webview)
            implementation(libs.viewmodel)
        }
        commonTest.dependencies {
            implementation(kotlin("test"))
            implementation(libs.compose.ui.test)
        }

        jvmTest.dependencies {
            implementation(compose.desktop.currentOs)
        }

    }
}

compose.resources {
    packageOfResClass = "com.gosunet.composebook.generated.resources"
}
