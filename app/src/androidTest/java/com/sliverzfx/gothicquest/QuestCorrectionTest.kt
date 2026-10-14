package com.sliverzfx.gothicquest

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollTo
import androidx.compose.ui.test.performTextInput
import org.junit.Rule
import org.junit.Test

class QuestCorrectionTest {
    @get:Rule val rule = createAndroidComposeRule<MainActivity>()

    @Test fun reportUsesSelectedQuestAndBackReturnsThroughOriginalSearch() {
        rule.waitUntil(30000) {
            rule.onAllNodesWithText("PICK A GAME").fetchSemanticsNodes().isNotEmpty()
        }
        rule.onNodeWithText("PICK A GAME").performClick()
        rule.onNodeWithTag("game_gothic").performClick()
        rule.onNodeWithText("SEARCH").performClick()
        rule.onNodeWithText("Quest, NPC, location, ID...").performTextInput("G1-C1-02")
        rule.onNodeWithText("Test of Faith").performClick()
        rule.onNodeWithTag("quest_report_correction").performScrollTo().performClick()
        // Confirm the selected quest reached the correction screen; Android
        // may hide the clipboard from instrumentation even when copying worked.
        rule.onNodeWithTag("support_correction_context")
            .assertTextContains("Gothic")
            .assertTextContains("Test of Faith")
            .assertTextContains("G1-C1-02")
        rule.onNodeWithTag("support_copy_report").performScrollTo().performClick()
        // The confirmation is shown only after Android's setPrimaryClip succeeds.
        rule.onNodeWithText("Report copied. Paste it into Discord and fill in the details.")
            .assertExists()
        rule.onNodeWithTag("support_back").performClick()
        rule.onNodeWithTag("quest_report_correction").assertExists()
        rule.onAllNodesWithText("‹  BACK TO QUESTS")[0].performScrollTo().performClick()
        rule.onNodeWithText("GOTHIC — SEARCH").assertExists()
        rule.onNodeWithText("HOME").performClick()
        rule.onNodeWithText("SUPPORT").performClick()
        rule.onNodeWithTag("support_correction_context").assertDoesNotExist()
        rule.onNodeWithText("COPY BUG REPORT").assertExists()
        rule.onNodeWithTag("support_copy_report").performScrollTo().performClick()
        rule.onNodeWithText("Report copied. Paste it into Discord and fill in the details.")
            .assertExists()
    }
}
