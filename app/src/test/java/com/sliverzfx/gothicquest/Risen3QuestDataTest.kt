package com.sliverzfx.gothicquest

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class Risen3QuestDataTest {
    @Test
    fun importedChaptersHaveUniqueIdsAndContiguousOrder() {
        assertEquals(listOf(10, 162, 11, 11), (1..4).map { GameId.RISEN_3.chapterQuests(it).size })
        val quests = GameId.RISEN_3.quests()
        assertEquals(quests.size, quests.map { it.id }.toSet().size)
        for (chapter in 1..4) {
            val entries = GameId.RISEN_3.chapterQuests(chapter)
            assertEquals((1..entries.size).toList(), entries.map { it.playOrder })
            assertTrue(Risen3QuestData.notes(chapter).all { it.beforeQuestOrder in 1..entries.size + 1 })
        }
    }

    @Test
    fun mutuallyExclusiveFactionInitiationsKeepSeparateCompletionIds() {
        val branches = GameId.RISEN_3.quests().filter { it.title.startsWith("New Allies —") }
        assertEquals(setOf("New Allies — Demon Hunters", "New Allies — Natives", "New Allies — Guardians"),
            branches.map { it.title }.toSet())
        assertEquals(3, branches.map { it.id }.toSet().size)
        assertTrue(branches.all { it.warnings.contains("POINT OF NO RETURN") })
    }

    @Test
    fun repeatedSpiritRitualStagesShareOneEntryAtChapterThreeEnd() {
        assertEquals(1, GameId.RISEN_3.quests().count { it.title == "The Spirit Ritual" })
        assertEquals("The Spirit Ritual", GameId.RISEN_3.chapterQuests(3).last().title)
        assertTrue(Risen3QuestData.notes(3).any { it.title.contains("The Spirit Ritual") })
    }

    @Test
    fun finalQuestResumesInsideRisenThree() {
        val finalQuest = GameId.RISEN_3.chapterQuests(4).last()
        assertEquals("Death Incarnate", finalQuest.title)
        assertEquals(AppRoute.QuestDetail(GameId.RISEN_3, finalQuest.id),
            routeFromResume("Risen 3", 4, finalQuest.id))
    }
    @Test
    fun tacariguaFogAndThievesQuestsHaveSourceCheckedWalkthroughs() {
        val section = Risen3QuestData.chapter(2).filter { it.playOrder in 98..137 }
        assertEquals(40, section.size)
        assertEquals((98..137).toList(), section.map { it.playOrder })
        assertTrue(section.all { it.giver.isNotBlank() })
        assertTrue(section.all { it.prerequisites.isNotBlank() })
        assertTrue(section.all { it.reward.isNotBlank() })
        assertTrue(section.all { it.walkthroughSteps.size >= 3 })
        assertTrue(section.all { it.summary.isNotBlank() })
        assertEquals(40, section.map { it.id }.toSet().size)

        val byId = section.associateBy { it.id }
        assertEquals("Rodriguez", byId.getValue("R3-C2-108").giver)
        assertEquals("200 Glory and 100 Gold", byId.getValue("R3-C2-108").reward)
        assertEquals("100 Glory", byId.getValue("R3-C2-107").reward)
        assertEquals("220 Glory", byId.getValue("R3-C2-115").reward)
        assertTrue(byId.getValue("R3-C2-109").warnings.contains("Vasco"))
        assertTrue(byId.getValue("R3-C2-110").warnings.contains("Horas"))
        assertTrue(byId.getValue("R3-C2-128").warnings.contains("Do not kill"))
        assertEquals("850 Glory and 300 Gold", byId.getValue("R3-C2-122").reward)
        assertEquals("Trawi", byId.getValue("R3-C2-136").giver)
        assertEquals("Malik", byId.getValue("R3-C2-134").giver)
    }

    @Test
    fun risenThreeOriginalChapterTotalsAndSavedProgressKeysRemainStable() {
        assertEquals(194, Risen3QuestData.quests.size)
        assertEquals(194, Risen3QuestData.quests.map { it.id }.toSet().size)
        assertEquals(
            listOf(10, 162, 11, 11),
            (1..4).map { Risen3QuestData.chapter(it).size }
        )
        assertEquals("R3-C2-098", Risen3QuestData.chapter(2)[97].id)
        assertEquals("R3-C2-137", Risen3QuestData.chapter(2)[136].id)
    }

    @Test
    fun risenThreePrologueAndLateStoryQuestsHaveNavigableTriggers() {
        for (chapter in listOf(1, 3, 4)) {
            val entries = Risen3QuestData.chapter(chapter)
            assertTrue("Empty prerequisite in chapter $chapter", entries.all { it.prerequisites.isNotBlank() })
        }
        val byId = Risen3QuestData.quests.associateBy { it.id }
        assertTrue(byId.getValue("R3-C3-011").prerequisites.contains("Recruit Zacharias"))
        assertTrue(byId.getValue("R3-C4-001").prerequisites.contains("Spirit Ritual"))
        assertTrue(byId.getValue("R3-C4-011").prerequisites.contains("Reunion"))
        assertTrue(byId.getValue("R3-C1-009").prerequisites.contains("Parrot Flight"))
    }

}
