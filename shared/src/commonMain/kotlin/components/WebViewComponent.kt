package components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.multiplatform.webview.web.WebView
import com.multiplatform.webview.web.rememberWebViewState

@Composable
fun WebViewComponent() {
    val webViewState = rememberWebViewState("https://zenika.com/")
    WebView(
        state = webViewState,
        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())
    )
}