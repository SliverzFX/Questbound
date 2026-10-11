package com.sliverzfx.gothicquest

import org.junit.Assert.*
import org.junit.Test

class Risen2QuestDataTest {
    @Test fun chapterOrderCountsAndUniqueProgressRecords() {
        assertEquals(listOf(47, 92, 76, 4), (1..4).map { GameId.RISEN_2.chapterQuests(it).size })
        val quests = GameId.RISEN_2.quests()
        assertEquals(219, quests.size)
        assertEquals(219, quests.map { it.id }.toSet().size)
        assertEquals(219, quests.map { it.title.lowercase() }.toSet().size)
        (1..4).forEach { chapter ->
            val entries = GameId.RISEN_2.chapterQuests(chapter)
            assertEquals((1..entries.size).toList(), entries.map { it.playOrder })
            assertTrue(entries.all { it.summary.isNotBlank() && it.walkthroughSteps.isNotEmpty() })
        }
        assertEquals("Meet the Commandant!", quests.first().title)
        assertEquals("The Pirate Garb", quests.single { it.id == "R2-C1-046" }.title)
    }

    @Test fun continuationGuidanceIsPreservedWithoutDuplicateQuests() {
        val largo = GameId.RISEN_2.quests().single { it.title == "Freeing Largo" }
        assertTrue(largo.walkthroughSteps.any { it.contains("Chapter 1") })
        val password = GameId.RISEN_2.quests().single { it.title == "The Password" }
        assertTrue(password.walkthroughSteps.any { it.contains("inspect the Strange Gate", true) })
        assertTrue(password.walkthroughSteps.any { it.contains("Garcia's Logbook") })
        assertTrue(Risen2QuestData.notes(2).any { it.title.startsWith("The Cunning Captain") })
    }

    @Test fun finaleContainsFourQuestsAndSeparateCombatNotes() {
        assertEquals(listOf("The Water Temple", "Defeat the Kraken", "Kill Mara", "Jaffar's Auri Culci"),
            GameId.RISEN_2.chapterQuests(4).map { it.title })
        assertTrue(Risen2QuestData.notes(4).any { it.title == "KRAKEN COMBAT CHECKLIST" })
        assertTrue(Risen2QuestData.notes(4).any { it.title == "MARA COMBAT CHECKLIST" })
        assertTrue(GameId.RISEN_2.chapterQuests(4).last().warnings.contains("Steelbeard's Hat"))
    }

    @Test fun resumeFindsRisen2Quest() {
        val quest = GameId.RISEN_2.chapterQuests(4).last()
        assertEquals(AppRoute.QuestDetail(GameId.RISEN_2, quest.id),
            routeFromResume("Risen 2", 4, quest.id))
    }
    @Test fun earlyRisen2QuestCorrectionsAndMissingObjectivesAreRetained() {
        val quests = Risen2QuestData.quests
        val byId = quests.associateBy { it.id }
        assertEquals("50 Glory", byId.getValue("R2-C1-001").reward)
        assertEquals("100 Glory", byId.getValue("R2-C1-003").reward.substringBefore(";"))
        assertTrue(byId.getValue("R2-C1-010").walkthroughSteps.any { it.contains("no provisions hand-in") })
        assertEquals("Elia", byId.getValue("R2-C1-045").giver)
        assertEquals("Morris", byId.getValue("R2-C1-044").giver)
        assertEquals("Booze", byId.getValue("R2-C1-043").giver)
        val restored = Risen2GuidePart9Data.quests
        assertEquals(3, restored.size)
        assertEquals(setOf("R2-C1-047", "R2-C2-080", "R2-C3-076"), restored.map { it.id }.toSet())
        assertTrue(restored.all { it.walkthroughSteps.size >= 3 && it.reward.isNotBlank() })
        assertTrue(GameId.RISEN_2.chapterQuests(1).all { it.prerequisites.isNotBlank() })
    }

    @Test fun chapterTwoDataHavePrerequisitesAndFactionsKeepTheirRoutes() {
        val chapterTwo = GameId.RISEN_2.chapterQuests(2)
        assertTrue(chapterTwo.all { it.prerequisites.isNotBlank() && it.giver.isNotBlank() && it.reward.isNotBlank() })
        val byId = chapterTwo.associateBy { it.id }
        assertTrue(byId.getValue("R2-C2-004").prerequisites.contains("Free Tahana"))
        assertTrue(byId.getValue("R2-C2-004").prerequisites.contains("The Lookout's Report"))
        assertEquals("Nakutu", byId.getValue("R2-C2-010").giver)
        assertEquals("Badriya", byId.getValue("R2-C2-011").giver)
        assertEquals("50 Glory", byId.getValue("R2-C2-010").reward)
    }

    @Test fun newSwordCoastSideQuestRecordsAreUniqueAndActionable() {
        val quests = Risen2GuidePart10Data.quests
        assertEquals(12, quests.size)
        assertEquals((81..92).toList(), quests.map { it.playOrder })
        assertEquals(12, quests.map { it.id }.toSet().size)
        assertTrue(quests.all { it.chapter == 2 && it.walkthroughSteps.size == 3 })
        assertTrue(quests.all { it.prerequisites.isNotBlank() && it.reward.isNotBlank() })
        assertEquals("0 Glory; 600 Gold, golden plate, jade, goblet and mask",
            quests.single { it.title == "The Treasure on Puerto Isabella Beach" }.reward)
    }

    @Test fun allRisen2QuestsHaveCompleteStructuralMetadata() {
        val quests = Risen2QuestData.quests
        assertTrue(quests.all {
            it.id.isNotBlank() && it.title.isNotBlank() && it.giver.isNotBlank() &&
            it.prerequisites.isNotBlank() && it.reward.isNotBlank() &&
            it.summary.isNotBlank() && it.walkthroughSteps.isNotEmpty()
        })
    }

}
