package com.sliverzfx.gothicquest

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class ChapterGuideNoteTest {
    @Test
    fun existingGothicGuidesHaveOpeningAndInterstitialOrClosingNotes() {
        val games = listOf(GameId.GOTHIC, GameId.GOTHIC_2_GOLD, GameId.NEW_BALANCE, GameId.GOTHIC_3)
        for (game in games) {
            for (chapter in 1..game.sectionCount) {
                val notes = game.chapterGuideNotes(chapter)
                val lastOrder = game.chapterQuests(chapter).maxOfOrNull { it.playOrder } ?: 0
                assertTrue("${game.name} chapter $chapter needs opening guidance",
                    notes.any { it.beforeQuestOrder == 1 && it.paragraphs.isNotEmpty() })
                assertTrue("${game.name} chapter $chapter needs an interstitial or closing note",
                    notes.any { it.beforeQuestOrder > 1 && it.paragraphs.isNotEmpty() })
                assertTrue("${game.name} chapter $chapter has an invalid insertion point",
                    notes.all { it.chapter == chapter && it.beforeQuestOrder in 1..(lastOrder + 1) })
            }
        }
    }

    @Test
    fun guideNotesDoNotChangeExistingGothicQuestTotals() {
        val expectedCounts = mapOf(
            GameId.GOTHIC to 47,
            GameId.GOTHIC_2_GOLD to 202,
            GameId.NEW_BALANCE to 619,
            GameId.GOTHIC_3 to 426
        )
        expectedCounts.forEach { (game, expected) -> assertEquals(expected, game.quests().size) }
    }

    @Test
    fun sharedLookupPreservesExistingRisenAndArcholosNotes() {
        assertEquals(RisenQuestData.notes(1), GameId.RISEN.chapterGuideNotes(1))
        assertEquals(Risen2QuestData.notes(2), GameId.RISEN_2.chapterGuideNotes(2))
        assertEquals(Risen3QuestData.notes(3), GameId.RISEN_3.chapterGuideNotes(3))
        assertEquals(ArcholosQuestData.notes(4), GameId.ARCHOLOS.chapterGuideNotes(4))
    }

    @Test
    fun sharedLookupReturnsNoNotesOutsideAValidSection() {
        assertTrue(GameId.RISEN.chapterGuideNotes(0).isEmpty())
        assertTrue(GameId.ARCHOLOS.chapterGuideNotes(GameId.ARCHOLOS.sectionCount + 1).isEmpty())
    }

    @Test
    fun existingNotesUseOnlyTopThroughAfterLastInsertionPoints() {
        GameId.entries.filter { it != GameId.GOTHIC_3 && it != GameId.GOTHIC_2_GOLD && it != GameId.GOTHIC && it != GameId.NEW_BALANCE }.forEach { game ->
            for (chapter in 1..game.sectionCount) {
                val lastOrder = game.chapterQuests(chapter).maxOfOrNull { it.playOrder } ?: 0
                assertTrue(game.chapterGuideNotes(chapter).all {
                    it.chapter == chapter && it.beforeQuestOrder in 1..(lastOrder + 1)
                })
            }
        }
    }
}
