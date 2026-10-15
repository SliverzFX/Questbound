package com.sliverzfx.gothicquest

internal object GothicRemakeQuestData {
    val quests: List<Quest> = buildList {
        addAll(GothicRemakeChapter1Data.quests)
        addAll(GothicRemakeChapter2Data.quests)
        addAll(GothicRemakeChapter3Data.quests)
        addAll(GothicRemakeChapter4Data.quests)
        addAll(GothicRemakeChapter5Data.quests)
        addAll(GothicRemakeChapter6Data.quests)
    }

    fun chapter(number: Int): List<Quest> = quests.filter { it.chapter == number }.sortedBy { it.playOrder }

    internal fun storyQuest(chapter: Int, order: Int, title: String, summary: String) = Quest(
        id = "G1R-C${chapter}-${order.toString().padStart(3, '0')}",
        chapter = chapter,
        playOrder = order,
        title = title,
        category = "Main quest",
        giver = "Story progression",
        location = "Valley of Mines",
        prerequisites = if (chapter == 1) "Begin a new game" else "Complete the preceding chapter",
        summary = summary,
        walkthroughSteps = listOf(summary),
        reward = "Story progression and experience",
        warnings = "The remake changes quest details from the original Gothic. Follow the journal title shown in this guide.",
        searchTags = listOf("gothic remake", "chapter $chapter", "main quest")
    )
}
