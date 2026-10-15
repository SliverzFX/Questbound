package com.sliverzfx.gothicquest

/** Opening context for the Gothic guides, followed by their existing route notes. */
internal object ChapterIntroductions {
    private fun overview(vararg paragraphs: String) = paragraphs.toList()

    private val byGame = mapOf(
        GameId.GOTHIC to listOf(
            overview(
                "Your first task in the Colony is to find your footing and learn how its three camps work. The quests below cover camp admission, useful contacts, supplies and the smaller jobs that help you earn a place.",
                "Explore the competing admission routes before choosing a camp. Their entries describe alternatives; completing every admission quest is not a requirement for one playthrough."
            ),
            overview(
                "The Brotherhood's preparations become the centre of the main story. Follow the focus-stone, minecrawler and Almanac leads while handling the related deliveries between camps.",
                "Several errands share destinations. Read their prerequisites before travelling, keep the requested quest items, and report back after completing each objective."
            ),
            overview(
                "The Orc Cemetery investigation leads into the search for the focus stones. This chapter takes you across the Colony, with separate expeditions to its ruins and dangerous wilderness sites.",
                "Use the companions offered for each expedition and return with the recovered stones. The list also includes camp-related developments; follow the entries available to your own character."
            ),
            overview(
                "The search for another way forward brings Xardas and the orcs into focus. Follow the meeting and shaman leads, then work through the preparations for the Ulu-Mulu and the route toward the temple.",
                "Speak to friendly quest characters before fighting through an area. Keep the requested trophies and materials until their quests are resolved."
            ),
            overview(
                "This chapter follows the way into the Sleeper's Temple and the discovery of Uriziel. Exploration, temple mechanisms and the weapon's preparation form a connected sequence.",
                "Keep a separate save before entering the temple. Follow the weapon quest through its return visits and conversations rather than treating the first temple expedition as the final assault."
            ),
            overview(
                "The final chapter returns you to the Sleeper's Temple for the conclusion of The Awakening of the Sleeper. The remaining guidance follows the final encounters and their required quest items.",
                "Finish your preparations, spend useful learning points and make a permanent save before the last expedition. Follow the quest's specific steps through the final chamber."
            )
        ),
        GameId.GOTHIC_1_REMAKE to listOf(
            overview(
                "The opening chapter introduces the Colony, the Fire Mages' letter and the admission routes of the Old Camp, New Camp and Swamp Camp. The surrounding errands build your contacts and resources before a permanent camp choice.",
                "These entries follow the Remake's quests. Compare the admission requirements and save before accepting membership; the camp routes describe different choices for a playthrough."
            ),
            overview(
                "The Brotherhood's plan draws you into the minecrawler investigation, the focus stone and the Almanac. Camp errands and new side quests accompany the main route through this chapter.",
                "Use each entry's prerequisites to decide when to return to a camp or the mine. Collect the required quest items and finish the conversations that advance the investigation."
            ),
            overview(
                "The focus-stone search becomes the main route through the Colony's distant ruins. The chapter also includes the Water Mages' plan, camp developments and the Remake's additional side quests.",
                "Prepare for each expedition separately and check which companions or quest leads are available. Some allegiance-related entries depend on your camp and earlier decisions."
            ),
            overview(
                "Xardas, the exiled shaman and the Free Mine lead toward the Orc Enclave. The quests below bring together the equipment and access needed for the next temple expedition.",
                "Follow the recovery and preparation quests before advancing into hostile territory. Speak to quest characters and retain the items they request along the route."
            ),
            overview(
                "The route now leads into the Sleeper's Temple and the Uriziel quest. The chapter combines the temple investigation with the remaining preparations for the final confrontation.",
                "Keep a permanent save before committing to the temple route. Follow the Remake-specific quest steps for access, exploration and weapon preparation."
            ),
            overview(
                "The Sleeper's Awakening concludes the Remake's main story. This chapter's entry covers the final armor preparation, temple route and encounters that lead to the ending.",
                "Read the full quest guidance before beginning the final sequence. Keep a separate save and bring the supplies and equipment you want for the last expedition."
            )
        ),
        GameId.GOTHIC_2_GOLD to listOf(
            overview(
                "Begin in Khorinis by finding a way into the city, meeting its citizens and investigating a guild route. The chapter also gathers early farm, monastery, harbor and Night of the Raven leads.",
                "Guild and apprenticeship choices affect which quests you can complete. Compare their preliminary jobs, keep a save before committing, and use each entry's availability to plan your route."
            ),
            overview(
                "The Valley of Mines investigation sends you after the evidence Lord Hagen needs. This guide section also follows the Jharkendar expedition's early regional quests, including pirate and bandit camp work.",
                "The expansion route can overlap the main game's chapter progression. Treat its placement here as a browsing route and check each quest's prerequisites before travelling."
            ),
            overview(
                "Returning to Khorinis opens the Seeker-related follow-ups and the work needed to restore the Eye of Innos. This chapter's list also brings together the later Jharkendar temple and Raven quests.",
                "Resolve the relevant city, farm and guild leads, then follow the Eye's repair and ritual requirements. Check the Jharkendar route when arranging a replacement for Vatras."
            ),
            overview(
                "The Dragon Hunt takes you back into the Valley of Mines. Alongside the dragons themselves, this chapter includes dragon-hunter encounters, faction follow-ups and new threats around Khorinis.",
                "Prepare the Eye of Innos and follow the instructions for restoring its power between dragons. Combine nearby side quests with each expedition and check the rewards before leaving the Valley."
            ),
            overview(
                "The next expedition needs a ship, a captain and a crew. Return to the relevant contacts in Khorinis, follow the tower lead and settle the remaining travel arrangements.",
                "Complete the mainland business you still want before sailing. Make a separate save, finish your training and buy supplies before confirming the departure."
            ),
            overview(
                "The Halls of Irdorath form the final expedition. Your crew remains part of the journey while the main route leads through the island's encounters and mechanisms toward the ending.",
                "Use the crew's available help and follow the quest instructions through each chamber. Keep a permanent save before advancing through the final encounters."
            )
        ),
        GameId.NEW_BALANCE to listOf(
            overview(
                "New Balance expands the opening journey through Khorinis with many additional investigations, faction paths, professions and regional quests. Use the list to establish your character and build the contacts needed for later chapters.",
                "The guide covers several alternative builds and allegiances. Check version-sensitive prerequisites and save before permanent guild, class or faction decisions; every listed route is not intended for one character."
            ),
            overview(
                "The second chapter opens a long network of expedition and faction quests around Jharkendar, the Valley of Mines and the mod's additional storylines. Many objectives develop across several regions or return visits.",
                "Follow the prerequisites and warnings for your chosen build. Group tasks by destination, keep the items requested by active chains and check for follow-ups before advancing the main story."
            ),
            overview(
                "The Eye of Innos and Bennet's imprisonment anchor the main story while new regional and faction follow-ups become available. Earlier investigations may also continue as their conditions are met.",
                "Work through your available follow-ups before the chapter handoff. New Balance branches can have different prerequisites, so use the individual entries when planning the ritual and your next departure."
            ),
            overview(
                "The Dragon Hunt is the main expedition, with additional New Balance quests and encounters around the Valley of Mines and other regions. The list includes both the central hunt and the branches available alongside it.",
                "Prepare your build for the tougher encounters and follow the Eye of Innos requirements. Revisit relevant faction contacts as the hunt progresses and check unfinished chains before moving on."
            ),
            overview(
                "The journey turns toward the final voyage: finding a ship, selecting a captain and gathering the crew. This is also a useful stage to review the mainland quests and faction work your character can still finish.",
                "Read departure warnings before confirming travel. Finish the training, equipment upgrades and optional chains you want, then keep a permanent save before sailing."
            ),
            overview(
                "Irdorath brings the main route to its conclusion. Follow the island's encounters and mechanisms while using the support available from the crew you recruited.",
                "Use the New Balance entry for each objective, since the mod can change encounters and requirements. Keep separate saves as you advance through the final expedition."
            )
        ),
        GameId.GOTHIC_3 to listOf(
            overview(
                "The opening route covers Ardea, Reddock, Cape Dun and Montera. These quests introduce the occupied towns, rebel camps, local reputation jobs and the competing choices about who controls each settlement.",
                "Gothic 3 has an open world; these parts are guide groupings rather than story chapters. Finish the local quests you want before attacking a town or rebel camp, and read the faction warnings first."
            ),
            overview(
                "This part continues through Okara, Gotha, Trelis and Nemora. Recruitment, supplies and local investigations connect the rebel camps with the surrounding towns and ruins.",
                "Work through each area's ordinary jobs before choosing its military outcome. Opposing faction objectives may exclude one another; the list records the alternatives rather than a single-playthrough target."
            ),
            overview(
                "The route gathers quests around Geldern, Silden, Vengard and Faring. It combines town reputation, arena and wilderness tasks with larger leads such as the fire chalices.",
                "Some collection quests continue well beyond this part. Keep them active while exploring, and check each town's access and faction requirements before deciding its fate."
            ),
            overview(
                "Nordmar's clans, mountain routes and monastery are the focus of this part. The quests include the search toward Xardas, work for the clans and expeditions connected to the ancestral tombs.",
                "Plan trips around the terrain and nearby objectives. Speak to the relevant clan members before and after an expedition, and keep the items requested by unfinished tomb and monastery quests."
            ),
            overview(
                "The desert route begins around Braga and continues through the Lago, Ben Erai and Ben Sala areas. Tribute, trade, mining and local faction jobs introduce Varant's settlements and wilderness routes.",
                "Check the consequences before helping one side against another. Keep access to towns and quest givers while you complete the ordinary jobs and cross-region errands you still want."
            ),
            overview(
                "This part covers Mora Sul, Al Shedim, Bakaresh and Ishtar, alongside the major artifact and ending-related decisions. Several objectives depend on reputation or work begun elsewhere in the world.",
                "Review the relevant faction and artifact chains before making permanent choices. The ending routes describe alternatives, so choose the path you intend to follow and keep a separate save first."
            ),
            overview(
                "This reference section brings together whole-game checklists for fire chalices, Adanos artifacts, druid stones, teleport stones and the ending routes. It also includes reputation guidance and quest-dependency reminders.",
                "These entries are reference guides rather than separate journal quests. Use them to review the regional parts and unfinished objectives before committing to the final decisions."
            )
        )
    )

    fun note(game: GameId, chapter: Int): ChapterGuideNote? =
        byGame[game]?.getOrNull(chapter - 1)?.let { paragraphs ->
            ChapterGuideNote(chapter, 1,
                if (game == GameId.GOTHIC_3) "Part guide" else "Chapter guide", paragraphs)
        }
}
