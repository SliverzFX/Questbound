package com.sliverzfx.gothicquest

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class ChapterGuideNoteTest {
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
