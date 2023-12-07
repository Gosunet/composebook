import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import components.AssistChip
import components.CircularButton
import components.FilterChipExample
import components.RangeSlider
import components.SliderMinimal
import components.SwitchMinimal
import components.SwitchWithIcon
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class, ExperimentalLayoutApi::class)
@Composable
fun DesignSystem() {
    Column(
        modifier = Modifier.padding(30.dp).verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Text(
            "Composebook",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary,
        )
        Text(
            modifier = Modifier.padding(bottom = 16.dp),
            text = "Embark on a mystical journey through our design system, a realm where pixels dance with magic. Discover enchanting components, bewitching colors, and the sacred grid guiding your every step. Unleash the power of design tokens, weaving spells of consistency across the digital cosmos. May your creations be as enchanting as the magic within these pages. Welcome to a world where design transcends the ordinary, and every interaction is a spell waiting to be cast.",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.secondary
        )
        FlowRow(modifier = Modifier.padding(bottom = 16.dp), horizontalArrangement = Arrangement.spacedBy(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
            ComponentsBlock(
                title = "Buttons",
                description = "In the realm of user interfaces, common buttons wield their magical influence, conjuring forth the majority of actions with a mere touch – a seamless spellbinding interaction for every user."
            ) {
                Button(onClick = {}) {
                    Text("Button default")
                }
                ElevatedButton(onClick = {}) {
                    Text("Button elevated")
                }
                FilledTonalButton(onClick = {}) {
                    Text("Button tonal")
                }
            }
            ComponentsBlock(
                title = "Icon buttons",
                description = "Behold the mystical prowess of icon buttons, granting individuals the power to enact minor wonders with a mere touch – a spellbinding experience at the tip of your fingers."
            ) {
                CircularButton(painterResource("magic.png")) { }
                CircularButton(painterResource("plus.png")) { }
            }
            ComponentsBlock(
                title = "Chips",
                description = "Enchanting with its prowess, Magic Chips elegantly guides individuals to effortlessly weave through realms of information, craft selections, refine content, and conjure actions at their fingertips."
            ) {
                FilterChipExample()
                AssistChip()
            }
            ComponentsBlock(
                title = "Sliders",
                description = "Sliders, the enchanted navigators of choice, beckon users to traverse the mystical spectrum of values, granting them the power to shape their selections with a mere glide – a magical journey through the realms of choice."
            ) {
                Column {
                    SliderMinimal()
                    RangeSlider()
                }
            }
            ComponentsBlock(
                title = "Switch",
                description = "Enchantments manifest as switches, weaving the arcane dance to toggle the mystical selection of an item, granting the power to illuminate or shroud in the whims of magic."
            ) {
                Column {
                    SwitchMinimal()
                    SwitchWithIcon()
                }
            }
        }
    }
}