package com.sliverzfx.gothicquest

internal object RisenQuestData {
    val quests: List<Quest> = buildList {
        addAll(RisenGuidePart1Data.quests)
        addAll(RisenGuidePart2Data.quests)
        addAll(RisenGuidePart3Data.quests)
        addAll(RisenGuidePart4Data.quests)
        addAll(RisenGuidePart5Data.quests)
        addAll(RisenGuidePart6Data.quests)
        addAll(RisenGuidePart7Data.quests)
        addAll(RisenGuidePart8Data.quests)
        addAll(RisenGuidePart9Data.quests)
        addAll(RisenGuidePart10Data.quests)
        addAll(RisenGuidePart11Data.quests)
        addAll(RisenGuidePart12Data.quests)
        addAll(RisenGuidePart13Data.quests)
        addAll(RisenGuidePart14Data.quests)
        addAll(RisenGuidePart15Data.quests)
    }

    private val guideNotes: List<ChapterGuideNote> = buildList {
        addAll(RisenGuidePart1Data.notes)
        addAll(RisenGuidePart2Data.notes)
        addAll(RisenGuidePart3Data.notes)
        addAll(RisenGuidePart4Data.notes)
        addAll(RisenGuidePart5Data.notes)
        addAll(RisenGuidePart6Data.notes)
        addAll(RisenGuidePart7Data.notes)
        addAll(RisenGuidePart8Data.notes)
    }

    fun isGuideEntry(quest: Quest): Boolean = quest.category.startsWith("GUIDE", ignoreCase = true)

    fun chapter(number: Int): List<Quest> =
        quests.filter { it.chapter == number }.sortedBy { it.playOrder }

    fun notes(chapter: Int): List<ChapterGuideNote> =
        guideNotes.filter { it.chapter == chapter }
}

internal fun isReferenceQuest(game: GameId, quest: Quest): Boolean = when (game) {
    GameId.GOTHIC_3 -> Gothic3QuestData.isGuideEntry(quest)
    GameId.RISEN -> RisenQuestData.isGuideEntry(quest)
    else -> false
}
