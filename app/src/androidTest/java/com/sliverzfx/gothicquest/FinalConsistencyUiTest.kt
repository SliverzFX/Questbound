package com.sliverzfx.gothicquest

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import org.junit.Rule
import org.junit.Test

class FinalConsistencyUiTest {
    @get:Rule val rule = createAndroidComposeRule<MainActivity>()

    @Test fun risenThreeReferenceCanBeReadAndFavoritedWithoutQuestCompletionControls() {
        rule.waitUntil(30000) {
            rule.onAllNodesWithText("PICK A GAME").fetchSemanticsNodes().isNotEmpty()
        }
        rule.onNodeWithText("PICK A GAME").performClick()
        rule.onNodeWithTag("library_search_toggle").performClick()
        rule.onNodeWithTag("library_game_search").performTextInput("Risen 3")
        rule.onNodeWithTag("game_risen_3").performClick()
        rule.onNodeWithTag("game_quest_search").performClick()
        rule.onNodeWithTag("quest_search_field").performTextInput("R3-C2-152")
        rule.onNodeWithText("CHAPTER 2  •  R3-C2-152", substring = true).performScrollTo().performClick()
        rule.onNodeWithText("REFERENCE ONLY • Not an independent journal quest").assertExists()
        rule.onNodeWithTag("quest_completed_toggle").assertDoesNotExist()
        rule.onNodeWithTag("quest_favorite_toggle").assertExists()
    }
}
