package components

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test

class FilterChipTest {

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun `filter chip should be clickable and icon should be visible when clicked`() = runComposeUiTest {
        setContent {
            FilterChipExample()
        }

        onNodeWithText("Filter chip").assertExists()
        onNodeWithText("Filter chip").performClick()
        onNodeWithContentDescription("Done icon").assertExists()
    }
}