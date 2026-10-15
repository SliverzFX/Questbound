package com.sliverzfx.gothicquest

internal data class ChapterGuideNote(
    val chapter: Int,
    val beforeQuestOrder: Int,
    val title: String,
    val paragraphs: List<String>
)

internal typealias RisenGuideNote = ChapterGuideNote

internal fun GameId.chapterGuideNotes(chapter: Int): List<ChapterGuideNote> {
    if (chapter !in 1..sectionCount) return emptyList()
    return when (this) {
        GameId.GOTHIC_1_REMAKE -> GothicRemakeGuideNotes.notes(chapter)
        GameId.GOTHIC, GameId.GOTHIC_2_GOLD, GameId.NEW_BALANCE, GameId.GOTHIC_3 -> GothicGuideNotes.notes(this, chapter)
        GameId.RISEN -> RisenQuestData.notes(chapter)
        GameId.RISEN_2 -> Risen2QuestData.notes(chapter)
        GameId.RISEN_3 -> Risen3QuestData.notes(chapter)
        GameId.ARCHOLOS -> ArcholosQuestData.notes(chapter)
    }
}
