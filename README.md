
## Badges

[![MIT License](https://img.shields.io/badge/License-MIT-green.svg)](https://choosealicense.com/licenses/mit/)

# Composebook 🪄

This is a **Kotlin Multiplatform project** targeting Android, iOS, Web.

[Compose Multiplatform](https://www.jetbrains.com/fr-fr/lp/compose-multiplatform/) let us share compose components between mutliples targets such as Android, iOS, Desktop, etc... The new target WASM allow us to now share our component to the web!

**Composebook** is a proof of concept that show how you can use Compose multiplatform to create a **shared component library** for **Android and iOS** while letting you share this library to our beloved designers, colleagues etc with **just a [link](https://gosunet.github.io/composebook/)**. 
Removing the need to install an app to see those components! A bit like **a storybook for native app** 🙌



## Demo

https://gosunet.github.io/composebook/


## Run Locally

Clone the project

### Run your application on browser

You can open the web application by running the `:composeApp:wasmJsBrowserDevelopmentRun` Gradle task.

### Run your application on Android

- Create an Android virtual device.
- In the list of run configurations, select **composeApp**.
- Choose your Android virtual device and click **Run**.

### Run your application on iOS

- Launch Xcode in a separate window. The first time, you may also need to accept its license terms and allow it to perform some necessary initial tasks.
- In the list of run configurations, select **iosApp** and click **Run**.
- If you don't have an available iOS configuration in the list, add a new iOS simulated device.

### Run your application on desktop

- In the list of run configurations, select **composeApp** and click **Run**.

## Authors

- [@Gosunet](https://www.github.com/Gosunet)


## Contributing

Contributions are always welcome!

## Appendix

Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html),
[Compose Multiplatform](https://github.com/JetBrains/compose-multiplatform/#compose-multiplatform),
[Kotlin/Wasm](https://kotl.in/wasm/)…

