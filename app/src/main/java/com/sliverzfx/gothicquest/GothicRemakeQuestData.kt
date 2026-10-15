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

    internal fun quest(chapter: Int, order: Int, title: String, category: String, giver: String,
        location: String, summary: String, reward: String, warnings: String): Quest {
        val missionType = category.startsWith("Main")
        return Quest(
            id = "G1R-C${chapter}-${order.toString().padStart(3, '0')}",
            chapter = chapter, playOrder = order, title = title, category = category, giver = giver,
            location = location, prerequisites = "See the journal entry and chapter guidance.", summary = summary,
            walkthroughSteps = listOf(summary,
                "Check the journal after each objective. If it requests a report, return to $giver."),
            reward = reward, warnings = warnings,
            searchTags = listOf("gothic remake", "chapter $chapter", giver.lowercase(), title.lowercase(), if (missionType) "main quest" else "side quest")
        )
    }
}
