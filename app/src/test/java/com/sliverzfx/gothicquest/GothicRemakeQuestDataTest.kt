package com.sliverzfx.gothicquest

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File

class GothicRemakeQuestDataTest {
    @Test
    fun catalogHasIndependentOrderedQuestSectionsAndGuideNotes() {
        val game = GameId.GOTHIC_1_REMAKE
        val quests = GothicRemakeQuestData.quests
        assertEquals(88, quests.size)
        assertEquals(quests.size, quests.map { it.id }.distinct().size)
        assertTrue(quests.all { it.id.startsWith("G1R-") })
        assertTrue(quests.all { it.chapter in 1..6 && it.playOrder > 0 })
        assertTrue(quests.all {
            it.title.isNotBlank() && it.category.isNotBlank() && it.giver.isNotBlank() &&
                it.location.isNotBlank() && it.summary.isNotBlank() && it.walkthroughSteps.isNotEmpty()
        })
        assertEquals(listOf(40, 16, 17, 9, 5, 1), (1..6).map { game.chapterQuests(it).size })
        val ledgerFile = listOf(File("docs/sources/gothic-remake-quest-sources.md"), File("../docs/sources/gothic-remake-quest-sources.md")).first { it.exists() }
        val ledger = ledgerFile.readText()
        for (quest in quests) {
            assertTrue("missing source ledger mapping for ${quest.id}", ledger.contains("`${quest.id}`"))
        }
        for (chapter in 1..game.sectionCount) {
            val entries = game.chapterQuests(chapter)
            assertEquals(entries.sortedBy { it.playOrder }, entries)
            assertEquals(entries.size, entries.map { it.playOrder }.distinct().size)
            val notes = game.chapterGuideNotes(chapter)
            assertTrue(notes.any { it.beforeQuestOrder == 1 && it.paragraphs.isNotEmpty() })
            val lastOrder = entries.maxOf { it.playOrder }
            assertTrue(notes.any { it.beforeQuestOrder in 2..(lastOrder + 1) && it.paragraphs.isNotEmpty() })
            assertTrue(notes.all { it.chapter == chapter && it.beforeQuestOrder in 1..(lastOrder + 1) })
        }
        assertEquals("G1R", game.savedKeyPrefix)
        assertTrue(game.savedKeyPrefix != GameId.GOTHIC.savedKeyPrefix)
    }
}
