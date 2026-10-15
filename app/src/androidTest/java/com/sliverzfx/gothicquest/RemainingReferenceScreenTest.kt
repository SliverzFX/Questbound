package com.sliverzfx.gothicquest

import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test

class RemainingReferenceScreenTest {
    @get:Rule val composeRule = createComposeRule()

    @Test fun remakeCommandsAreSearchableAndCopyable() {
        composeRule.setContent {
            MaterialTheme { ToolReferenceScreen(ToolSection.MARVIN_CODES, GameId.GOTHIC_1_REMAKE, {}, {}, embedded = true) }
        }
        composeRule.onNodeWithText("Reference being prepared").assertDoesNotExist()
        composeRule.onNodeWithText(GothicRemakeToolsData.sourceNote).assertExists()
        composeRule.onNodeWithTag("tools_search_toggle").performClick()
        composeRule.onNodeWithTag("tool_reference_search").performTextInput("spawnmenu")
        composeRule.onNodeWithTag("gothic_reference_g1r_menu").performClick()
        composeRule.onNodeWithTag("tool_detail_body").assertTextContains("mod’s spawn browser", substring = true)
        composeRule.onNodeWithTag("tool_detail_copy").performClick()
        composeRule.onNodeWithText("COPIED").assertExists()
    }

    @Test fun newBalanceEquipmentSearchUsesModStats() {
        composeRule.setContent {
            MaterialTheme { ToolReferenceScreen(ToolSection.MARVIN_CODES, GameId.NEW_BALANCE, {}, {}, embedded = true) }
        }
        composeRule.onNodeWithText("Reference being prepared").assertDoesNotExist()
        composeRule.onNodeWithTag("tools_search_toggle").performClick()
        composeRule.onNodeWithTag("tool_reference_search").performTextInput("Light Halberd")
        composeRule.onNodeWithTag("gothic_reference_nb_equipment_zbrane-sila_halberds_light_halberd").performClick()
        composeRule.onNodeWithTag("tool_detail_body").assertTextContains("Damage: 60", substring = true)
        composeRule.onNodeWithTag("tool_detail_copy").assertDoesNotExist()
    }

    @Test fun newBalanceTipsAreSearchable() {
        composeRule.setContent {
            MaterialTheme { ToolReferenceScreen(ToolSection.USEFUL_TIPS, GameId.NEW_BALANCE, {}, {}, embedded = true) }
        }
        composeRule.onNodeWithTag("tools_search_toggle").performClick()
        composeRule.onNodeWithTag("tool_reference_search").performTextInput("Ur-Karras")
        composeRule.onNodeWithTag("gothic_reference_nb_tip_orc_fangs").performClick()
        composeRule.onNodeWithTag("tool_detail_body").assertTextContains("Hunt for Muritan", substring = true)
    }
}
