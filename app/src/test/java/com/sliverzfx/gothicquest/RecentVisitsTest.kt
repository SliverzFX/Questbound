package com.sliverzfx.gothicquest

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

class RecentVisitsCodecTest {
    @Test fun gothicRemakeRecentQuestKeepsItsGameIdentityOnResume() {
        val remakeQuest = GothicRemakeQuestData.quests.first()
        val originalVisit = recentVisitFromRoute(AppRoute.Chapter(GameId.GOTHIC, 1))
        val remakeVisit = recentVisitFromRoute(AppRoute.QuestDetail(GameId.GOTHIC_1_REMAKE, remakeQuest.id))
        assertEquals(GameId.GOTHIC, originalVisit?.game)
        assertEquals(GameId.GOTHIC_1_REMAKE, remakeVisit?.game)
        assertEquals(AppRoute.QuestDetail(GameId.GOTHIC_1_REMAKE, remakeQuest.id), remakeVisit?.route())
        assertNotEquals(originalVisit?.game, remakeVisit?.game)
    }
}
