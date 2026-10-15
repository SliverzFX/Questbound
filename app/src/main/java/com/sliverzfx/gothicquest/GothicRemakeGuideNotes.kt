package com.sliverzfx.gothicquest

internal object GothicRemakeGuideNotes {
    private val notes = listOf(
        ChapterGuideNote(1, 1, "Before choosing a camp", listOf("Keep the sealed letter intact and do not commit to a camp until you have finished the admission tasks and side quests you want.")),
        ChapterGuideNote(1, 2, "Camp routes", listOf("Old Camp, New Camp and Swamp Camp admissions are mutually exclusive. Make a separate save before accepting a camp’s armor and status.")),
        ChapterGuideNote(2, 1, "Prepare for the mine", listOf("Raise your weapon skill and carry healing before descending into the minecrawler tunnels.")),
        ChapterGuideNote(2, 2, "Before leaving the chapter", listOf("Finish Brotherhood errands and collect any available mine supplies before advancing the main quest.")),
        ChapterGuideNote(3, 1, "Search the Colony", listOf("The focus stones are spread across dangerous locations. Track each recovered stone in the journal before returning to the Water Mages.")),
        ChapterGuideNote(3, 2, "Point of no return", listOf("The chosen faction affects access and later dialogue. Finish faction-specific work and buy training before advancing.")),
        ChapterGuideNote(4, 1, "Find the exile", listOf("Prepare for hostile territory before following Xardas’ lead. Bring healing and upgrade your best damage option.")),
        ChapterGuideNote(4, 2, "Prepare for the temple", listOf("Complete available Colony errands and collect the equipment you want before following the main route toward the orcs.")),
        ChapterGuideNote(5, 1, "Temple preparation", listOf("Make a permanent save, carry healing and keep the ULU-MULU available for safe passage through the orc city.")),
        ChapterGuideNote(5, 2, "Before the final chapter", listOf("Explore thoroughly and finish any remaining side quests. The temple route is combat-heavy and does not offer easy resupply.")),
        ChapterGuideNote(6, 1, "Final descent", listOf("Make a permanent save before entering the final stretch. Preserve the ancient blades and follow Xardas’ instructions at the heart shrines.")),
        ChapterGuideNote(6, 2, "After the ending", listOf("The final sequence closes the main story. Resolve any remaining tasks before activating the last shrine."))
    )

    fun notes(chapter: Int): List<ChapterGuideNote> = notes.filter { it.chapter == chapter }
}
