package com.sliverzfx.gothicquest

import org.junit.Assert.*
import org.junit.Test

class FinalConsistencyTest {
    @Test fun everyQuestHasARewardDescription() {
        GameId.entries.forEach { game ->
            assertTrue("Blank rewards in $game: ${game.quests().filter { it.reward.isBlank() }.map { it.id }}",
                game.quests().all { it.reward.isNotBlank() })
        }
    }

    @Test fun risenThreeLegacyReferencesDoNotCountAsSeparateQuests() {
        val references = Risen3QuestData.quests.filter { isReferenceQuest(GameId.RISEN_3, it) }
        assertEquals(setOf("R3-C2-092", "R3-C2-152"), references.map { it.id }.toSet())
        assertFalse(isReferenceQuest(GameId.RISEN_3, Risen3QuestData.quests.single { it.id == "R3-C2-111" }))
        assertFalse(isReferenceQuest(GameId.RISEN_3, Risen3QuestData.quests.single { it.id == "R3-C2-091" }))
    }
}
