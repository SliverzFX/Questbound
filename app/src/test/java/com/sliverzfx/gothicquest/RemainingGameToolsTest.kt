package com.sliverzfx.gothicquest

import org.junit.Assert.*
import org.junit.Test

class RemainingGameToolsTest {
    @Test fun everyGameHasCodesAndGameplayTips() {
        GameId.entries.forEach { game ->
            assertTrue("Missing codes: $game", game.toolReferenceCards(ToolSection.MARVIN_CODES).isNotEmpty())
            assertTrue("Missing tips: $game", game.toolReferenceCards(ToolSection.USEFUL_TIPS).isNotEmpty())
        }
    }

    @Test fun newReferencesHaveStableUniqueIdsAndSources() {
        listOf(GameId.GOTHIC_1_REMAKE, GameId.NEW_BALANCE).forEach { game ->
            val codes = game.toolReferenceCards(ToolSection.MARVIN_CODES)
            val tips = game.toolReferenceCards(ToolSection.USEFUL_TIPS)
            val entries = (codes + tips).map { it.entry }
            assertTrue(entries.size > 20)
            assertEquals(entries.size, entries.map { it.id }.toSet().size)
            assertTrue(entries.all { it.body.isNotBlank() && it.source.startsWith("https://") })
            assertTrue(codes.all { it.entry.codeCategory != null })
            assertTrue(tips.all { it.entry.command == null })
            assertEquals(codes, game.toolReferenceCards(ToolSection.ITEMS))
        }
    }

    @Test fun remakeCommandsDescribeTheRequiredMod() {
        val entries = GameId.GOTHIC_1_REMAKE.toolReferenceCards(ToolSection.MARVIN_CODES).map { it.entry }
        assertTrue(entries.any { it.command == null && it.body.contains("UE4SS") })
        assertTrue(entries.any { it.command == "spawnmenu" })
        assertTrue(entries.any { it.command == "additem ItMw_1H_Sword_01 5" })
        assertFalse(entries.any { it.command == "marvin" || it.command?.startsWith("insert ") == true })
    }

    @Test fun favoritesResolveForBothGamesWithoutCrossingIdentities() {
        val games = listOf(GameId.GOTHIC_1_REMAKE, GameId.NEW_BALANCE)
        games.forEach { game ->
            val first = game.toolReferenceCards(ToolSection.MARVIN_CODES).first()
            val favorite = buildToolFavorites(setOf(toolFavoriteKey(game, first.entry.id))).single()
            assertEquals(game, favorite.game)
            assertEquals(first, favorite.card)
        }
    }
}
