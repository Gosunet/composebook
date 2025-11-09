package pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import components.AssistChip
import components.CircularButton
import components.ConditionalWebView
import components.FilterChipExample
import components.RangeSlider
import components.RealtimePriceIndicator
import components.SliderMinimal
import components.SwitchMinimal
import components.SwitchWithIcon
import composebook.composeapp.generated.resources.Res
import composebook.composeapp.generated.resources.magic
import composebook.composeapp.generated.resources.plus
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Components() {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 300.dp), // This creates the responsive multi-column layout
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp),
    ) {
        item {
            ComponentsBlock(
                title = "Buttons",
                description = "In the realm of user interfaces, common buttons wield their magical influence, conjuring forth the majority of actions with a mere touch – a seamless spellbinding interaction for every user."
            ) {
                Button(onClick = {}) { Text("Button default") }
                ElevatedButton(onClick = {}) { Text("Button elevated") }
                FilledTonalButton(onClick = {}) { Text("Button tonal") }
            }
        }
        item {
            ComponentsBlock(
                title = "Icon buttons",
                description = "Behold the mystical prowess of icon buttons, granting individuals the power to enact minor wonders with a mere touch – a spellbinding experience at the tip of your fingers."
            ) {
                CircularButton(painterProvider = { painterResource(Res.drawable.magic) }) { }
                CircularButton(painterProvider = { painterResource(Res.drawable.plus) }) { }
            }
        }
        item {
            ComponentsBlock(
                title = "Chips",
                description = "Enchanting with its prowess, Magic Chips elegantly guides individuals to effortlessly weave through realms of information, craft selections, refine content, and conjure actions at their fingertips."
            ) {
                FilterChipExample()
                AssistChip()
            }
        }
        item {
            ComponentsBlock(
                title = "Switch",
                description = "Enchantments manifest as switches, weaving the arcane dance to toggle the mystical selection of an item, granting the power to illuminate or shroud in the whims of magic."
            ) {
                SwitchMinimal()
                SwitchWithIcon()
            }
        }
        item {
            ComponentsBlock(
                title = "Sliders",
                description = "Sliders, the enchanted navigators of choice, beckon users to traverse the mystical spectrum of values, granting them the power to shape their selections with a mere glide – a magical journey through the realms of choice."
            ) {
                Column {
                    SliderMinimal()
                    RangeSlider()
                }
            }
        }
        item {
            // Because it's in a lazy grid, this WebView will now be properly disposed of when scrolled off-screen.
            ConditionalWebView()
        }
        item {
            ComponentsBlock(
                title = "Price Indicator",
                description = "Behold the Oracle of Value, a mystical indicator that channels the ever-shifting tides of fortune. With a flicker of emerald green for rising prosperity or a flush of crimson for waning wealth, it grants seers a real-time glimpse into the unpredictable dance of the market's magic."
            ) {
                // Your price indicator will also benefit from this virtualization.
                RealtimePriceIndicator()
            }
        }
    }
}
