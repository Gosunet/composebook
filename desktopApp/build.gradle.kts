plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
}

kotlin {
    dependencies {
        implementation(projects.shared)
        implementation(libs.compose.desktop)
        implementation(compose.desktop.currentOs)
    }
    jvmToolchain(21)
}

compose.desktop {
    application {
        mainClass = "MainKt"
    }
}
