package components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pages.ComponentsBlock

@Composable
actual fun ConditionalWebView() {
    ComponentsBlock(
        title = "WebView",
        description = "Behold the WebView, an enchanted looking glass that opens a portal to the vast realms of the internet, allowing ancient scrolls and modern web pages alike to manifest directly within your application's mystical boundaries."
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
        ) {
            WebViewComponent()
        }
    }
}