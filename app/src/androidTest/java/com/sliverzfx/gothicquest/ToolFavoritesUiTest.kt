package com.sliverzfx.gothicquest

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.Clipboard
import androidx.compose.ui.platform.ClipEntry
import androidx.compose.ui.platform.LocalClipboard
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class ToolFavoritesUiTest {
    @get:Rule val rule = createComposeRule()

    @Test fun starSavesWeaponInItsCategoryAndDetailCanCopyAndRemoveIt() {
        var keys by mutableStateOf(emptySet<String>())
        var showFavorites by mutableStateOf(false)
        var copiedCommand: String? = null
        // Android 10+ can refuse clipboard reads by instrumentation even after a
        // successful write. Inject a recorder so this checks the command copied
        // by the actual detail button, not the emulator's clipboard visibility.
        val recordingClipboard = object : Clipboard {
            private var latestEntry: ClipEntry? = null
            override suspend fun getClipEntry(): ClipEntry? = latestEntry
            override suspend fun setClipEntry(clipEntry: ClipEntry?) {
                latestEntry = clipEntry
                copiedCommand = clipEntry?.clipData?.getItemAt(0)?.text?.toString()
            }
        }
        rule.setContent {
            CompositionLocalProvider(
                LocalClipboard provides recordingClipboard,
                LocalToolFavoriteKeys provides keys,
                LocalToggleToolFavorite provides { game, id ->
                    val key = toolFavoriteKey(game, id)
                    keys = if (key in keys) keys - key else keys + key
                }) {
                if (showFavorites) Column { ToolFavoritesSections(buildToolFavorites(keys)) }
                else GothicReferenceScreen(ToolSection.MARVIN_CODES, {}, {}, embedded = true)
            }
        }
        rule.onNodeWithTag("tools_search_toggle").performClick()
        rule.onNodeWithTag("tool_reference_search").performTextInput("rusty sword")
        rule.onNodeWithTag("tool_favorite_rusty_sword_insert").performClick()
        rule.runOnIdle {
            assertTrue("G1|tool:rusty_sword_insert" in keys)
            showFavorites = true
        }
        rule.onNodeWithTag("favorites_category_weapons").assertExists()
        rule.onNodeWithTag("saved_tool_gothic_rusty_sword_insert").performClick()
        rule.onNodeWithTag("tool_detail_body").assertExists()
        rule.onNodeWithTag("tool_detail_copy").performClick()
        rule.onNodeWithText("COPIED").assertExists()
        rule.runOnIdle {
            assertEquals("insert itmw_1h_sword_old_01", copiedCommand)
        }
        rule.onNodeWithTag("tool_detail_favorite").performClick()
        rule.onNodeWithTag("tool_detail_close").performClick()
        rule.onNodeWithTag("saved_tool_gothic_rusty_sword_insert").assertDoesNotExist()
        rule.runOnIdle { assertTrue(keys.isEmpty()) }
    }
}
