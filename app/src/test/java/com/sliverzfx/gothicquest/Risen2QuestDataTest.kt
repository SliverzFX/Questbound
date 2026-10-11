package com.sliverzfx.gothicquest

import org.junit.Assert.*
import org.junit.Test

class Risen2QuestDataTest {
    @Test fun chapterOrderCountsAndUniqueProgressRecords() {
        assertEquals(listOf(47, 92, 164, 4), (1..4).map { GameId.RISEN_2.chapterQuests(it).size })
        val quests = GameId.RISEN_2.quests()
        assertEquals(307, quests.size)
        assertEquals(307, quests.map { it.id }.toSet().size)
        assertEquals(307, quests.map { it.title.lowercase() }.toSet().size)
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

    @Test fun isleOfTheDeadQuestChainHasCorrectSubquestMilestones() {
        val addition = Risen2GuidePart11Data.quests
        assertEquals(13, addition.size)
        assertEquals((77..89).toList(), addition.map { it.playOrder })
        assertEquals(13, addition.map { it.id }.distinct().size)
        assertTrue(addition.all { it.chapter == 3 && it.walkthroughSteps.size == 3 })
        val entries = addition.associateBy { it.title }
        assertEquals("50 Glory", entries.getValue("Black Lotus").reward)
        assertEquals("50 Glory", entries.getValue("Grave Dust").reward)
        assertTrue(entries.getValue("Akando's Chest").walkthroughSteps.any { it.contains("Nahele") })
        assertTrue(entries.getValue("The Hunter's Curse").reward.contains("Skull of an undead animal"))
        val main = Risen2QuestData.quests.associateBy { it.id }
        assertTrue(main.getValue("R2-C3-058").summary.contains("five Black Lotus"))
        assertTrue(main.getValue("R2-C3-059").summary.contains("Nahele"))
    }

    @Test fun maracaiBayJournalExpansionHasDistinctObjectivesAndConsequences() {
        val entries = Risen2GuidePart12Data.quests
        assertEquals(21, entries.size)
        assertEquals((90..110).toList(), entries.map { it.playOrder })
        assertEquals(21, entries.map { it.id }.toSet().size)
        assertTrue(entries.all { it.chapter == 3 && it.walkthroughSteps.size == 3 })
        assertTrue(entries.all { it.giver.isNotBlank() && it.prerequisites.isNotBlank() && it.reward.isNotBlank() })
        val byTitle = entries.associateBy { it.title }
        assertEquals("Corrientes", byTitle.getValue("The Deserter").giver)
        assertEquals("Valdez", byTitle.getValue("The Expedition").giver)
        assertEquals("Mercutio", byTitle.getValue("Storage Barrels from the Wreck").giver)
        assertTrue(byTitle.getValue("Angus Rescued").warnings.contains("Garcia"))
        assertTrue(byTitle.getValue("Angus is Dead").warnings.contains("Angus Rescued"))
        assertTrue(byTitle.getValue("The Naked Corpses").prerequisites.contains("Garcia"))
        assertTrue(byTitle.getValue("Unwanted Sermon").summary.contains("Bones"))
    }

    @Test fun maracaiSuccessionBranchesAreSeparateAndValid() {
        val quests = Risen2GuidePart13Data.quests
        assertEquals(17, quests.size)
        assertEquals((111..127).toList(), quests.map { it.playOrder })
        assertEquals(17, quests.map { it.id }.distinct().size)
        assertTrue(quests.all { it.prerequisites.isNotBlank() && it.walkthroughSteps.size == 3 })
        val byTitle = quests.associateBy { it.title }
        assertTrue(byTitle.getValue("Paws for Hakeke").category.contains("INQUISITION"))
        assertTrue(byTitle.getValue("Paws for Zaalu").category.contains("NATIVE"))
        assertTrue(byTitle.getValue("The Four Feathers").category.contains("INQUISITION"))
        assertTrue(byTitle.getValue("The Three Questions").category.contains("NATIVE"))
        assertTrue(byTitle.getValue("Become Halmak of the Maracai").warnings.contains("Intimidation"))
        assertTrue(byTitle.getValue("Chaka Datu's Legacy").warnings.contains("mutually exclusive"))
        assertEquals("Datu", byTitle.getValue("Datu's Second Question").giver)
        assertEquals("100 Glory", byTitle.getValue("Datu's Third Question").reward)
    }

    @Test fun completeMaracaiReferenceTitleCatalogHasNoMissingStandaloneJournalNames() {
        val additional = Risen2GuidePart14Data.quests
        assertEquals(24, additional.size)
        assertEquals((128..151).toList(), additional.map { it.playOrder })
        assertTrue(additional.all { it.chapter == 3 && it.prerequisites.isNotBlank() && it.walkthroughSteps.size == 3 })
        val byTitle = additional.associateBy { it.title }
        assertTrue(byTitle.getValue("Duel with Hakeke's Halmak").category.contains("NATIVE"))
        assertTrue(byTitle.getValue("Duel with Zaalu's Halmak").category.contains("INQUISITION"))
        assertEquals("Cordobar", byTitle.getValue("Garcia's Ship").giver)
        assertEquals("100 Glory", byTitle.getValue("The Treasure on the Hunting Grounds").reward.substringBefore(";"))
        assertTrue(byTitle.getValue("The Treasure in the Panther Cave").reward.contains("disagreement"))
        assertTrue(byTitle.getValue("The Beast Is Dead").reward.contains("not verified"))
        assertEquals("50 Glory", byTitle.getValue("The White Feather").reward)
        assertEquals("50 Glory", byTitle.getValue("The Yellow Feather").reward)
    }

    @Test fun calderaTwoCompleteOriginalIndexKeepsAlternativeArchiveRoutesDistinct() {
        val newQuests = Risen2GuidePart15Data.quests
        assertEquals(8, newQuests.size)
        assertEquals((152..159).toList(), newQuests.map { it.playOrder })
        assertTrue(newQuests.all { it.chapter == 3 && it.walkthroughSteps.size == 3 })
        assertEquals(8, newQuests.map { it.id }.distinct().size)
        val byTitle = newQuests.associateBy { it.title }
        assertEquals("Carlos", byTitle.getValue("Mauregato!").giver)
        assertEquals("Azuro", byTitle.getValue("Errand Boy").giver)
        assertEquals("10 Glory", byTitle.getValue("Follow the Servant").reward)
        assertEquals("200 Glory", byTitle.getValue("Scrolls, Books and Shelves").reward)
        assertTrue(byTitle.getValue("The Signet Ring").walkthroughSteps.any { it.contains("Hermina") })
        val quests = Risen2QuestData.quests.associateBy { it.id }
        assertEquals("Custodio", quests.getValue("R2-C3-065").giver)
        assertEquals("500 Glory", quests.getValue("R2-C3-064").reward)
        assertTrue(quests.getValue("R2-C3-065").reward.contains("200 Glory"))
    }

    @Test fun antiguaTreasureAndRicksReturnQuestHaveSeparateProgress() {
        val appendix = Risen2GuidePart16Data.quests
        assertEquals(5, appendix.size)
        assertEquals((160..164).toList(), appendix.map { it.playOrder })
        assertTrue(appendix.all { it.chapter == 3 && it.walkthroughSteps.size == 3 })
        assertEquals(5, appendix.map { it.id }.toSet().size)
        val byTitle = appendix.associateBy { it.title }
        assertEquals("Scarlett", byTitle.getValue("Where Is Rick?").giver)
        assertEquals("Rick", byTitle.getValue("There's No Place Like Home").giver)
        assertTrue(byTitle.getValue("Where Is Rick?").prerequisites.contains("Where Is My Ship?"))
        assertTrue(byTitle.getValue("Gibson's Grave").reward.contains("Silver Mask"))
        assertEquals("100 Glory", byTitle.getValue("The Treasure in the Grotto on Antigua").reward.substringBefore(";"))
    }

}
