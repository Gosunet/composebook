plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
}

kotlin {
    @OptIn(org.jetbrains.kotlin.gradle.ExperimentalWasmDsl::class)
    wasmJs {
        outputModuleName = "composebook"
        browser {
            commonWebpackConfig {
                outputFileName = "composebook.js"
            }
            testTask {
                useKarma {
                    useFirefox()
                }
            }
        }
        binaries.executable()
    }

    sourceSets {
        wasmJsMain.dependencies {
            implementation(projects.shared)
            implementation(libs.compose.ui)
        }
    }
}

compose.resources {
    packageOfResClass = "com.gosunet.composebook.web.generated.resources"
}
