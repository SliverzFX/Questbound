package com.sliverzfx.gothicquest

internal object GothicGuideNotes {
    private fun note(chapter: Int, beforeOrder: Int, title: String, vararg paragraphs: String) =
        ChapterGuideNote(chapter, beforeOrder, title, paragraphs.toList())

    private val notesByGame = mapOf(
        GameId.GOTHIC to listOf(
            note(1, 1, "Before you choose a camp", "Chapter 1 is the only safe time to compare all three camps. Make a permanent save before taking a camp’s final admission step; joining one closes the other two routes.", "Meet trainers and finish errands for the camps you want to see. Keep named NPCs alive unless a quest explicitly requires a fight."),
            note(1, 8, "New Camp route", "Lares values useful contacts and practical help. Mordrag’s escort is a safe introduction; if you want Fisk’s replacement-fence quest, drive Mordrag away non-lethally instead."),
            note(1, 16, "Swamp Camp route", "The Brotherhood admission route depends on earning several Gurus’ approval. Speak to each Guru, complete the small introductions, and deliver the swampweed orders before pushing the main story."),
            note(1, 25, "Chapter 1 handoff", "Before advancing, check the Old Mine list, the camp admission you intend to follow, and the Stranger/Chromanin trail. Chapter 2 shifts the main focus toward the Brotherhood and minecrawler threat."),
            note(2, 1, "The minecrawler investigation", "Ask the Brotherhood leaders what they need before entering the Old Mine. Take healing supplies, explore the workers’ routes carefully, and loot named quest items instead of leaving them behind."),
            note(2, 4, "Brotherhood and camp errands", "Several Brotherhood jobs overlap around swampweed and the mine. Finish the errands you have accepted and speak to the relevant camp leaders after major discoveries so the journal can advance."),
            note(2, 6, "Before the Orc Cemetery", "The Orc Cemetery is the chapter’s major expedition. Make a permanent save, bring healing and ranged options, and finish the minecrawler nest objectives before following the expedition deeper."),
            note(3, 1, "Focus-stone route", "The focus hunt opens four dangerous regions. Take one route at a time, use the companions and maps already offered by the quest givers, and report each stone to the person who sent you."),
            note(3, 6, "Do not rush the camp choice", "Complete the focus-stone work and the camp tasks you care about before accepting a permanent rank. The Old Camp, New Camp, and Brotherhood advancement paths do not all remain available together."),
            note(3, 11, "Chapter transition", "Keep the focus stones, reports, and faction decision settled before the next story push. Make a separate save if you want to compare the different camp outcomes."),
            note(4, 1, "Preparation for the Colony’s turning point", "This chapter connects Xardas, Ur-Shak, the Free Mine, and the Ulu-Mulu. Avoid killing neutral orc characters; their dialogue is part of the route forward."),
            note(4, 6, "Before entering the Orc Enclave", "Finish the Free Mine and Ulu-Mulu preparations first. Carry the required crafting materials and keep a save before presenting yourself to the orc leaders."),
            note(4, 6, "Chapter 4 checklist", "Confirm Xardas’s instructions, the Ulu-Mulu, the Free Mine objectives, and the orc-shaman route are resolved before leaving this stage."),
            note(5, 1, "Sleeper Temple preparation", "The temple is a long, dangerous endgame route. Upgrade your main weapon and armor, stock healing and resistance potions, and keep a permanent save before entering."),
            note(5, 3, "Temple route", "Search side chambers and read the temple’s clues before opening the next passage. Keep Uriziel and its related instructions; both are central to the final sequence."),
            note(6, 1, "Final expedition", "This is the final chapter. Spend remaining learning points, bring your best supplies, and save before the last temple encounters; there is no later chapter for unfinished business."),
            note(6, 2, "Sleeper encounter", "Follow the chamber mechanisms and use the tools and weapon prepared during the previous chapter. Do not assume ordinary attacks will resolve every part of the final encounter.")
        ),
        GameId.GOTHIC_2_GOLD to listOf(
            note(1, 1, "Khorinis: establish your route first", "Complete the city-entry and citizenship steps before committing to a guild. Explore the harbor, marketplace, farms, and monastery road while the early errands are still available.", "Save before consequential choices such as Canthar and Sarah, joining the Thieves’ Guild, or accepting a permanent apprenticeship."),
            note(1, 42, "Guild and apprenticeship decisions", "Compare the guilds’ trainers, equipment, and entry tasks before taking the oath. A choice that advances one route can close competing guild quests, so keep a separate save if you want to compare them."),
            note(1, 70, "Finish city errands before leaving", "Check unfinished Khorinis, harbor, farm, and Thieves’ Guild jobs before the Valley of Mines trip. Keep quest documents, packages, and named trophies until their owners have received them."),
            note(1, 102, "Chapter 1 handoff", "Before reporting to Lord Hagen and leaving for the Valley, make sure the city investigations and guild jobs you want are recorded as complete. Pack healing, food, and a ranged weapon for the road."),
            note(2, 1, "Prepare for the Valley of Mines", "Bring a map, healing supplies, and enough food for the trip. Speak to Jergan on the approach and follow the miners’ reports in a deliberate loop so you do not miss the camps or their leaders."),
            note(2, 14, "Three mining camps", "Fajeth, Marcos, and the remaining expedition each have separate information for Garond. Finish nearby snapper and escort tasks while you are at each camp, then confirm all reports with Garond."),
            note(2, 45, "Return with Garond’s evidence", "Before returning to Khorinis, check that Garond has accepted each mining report and that you have the written evidence for Lord Hagen. Resolve Valley-specific side jobs while the route is still open."),
            note(3, 1, "Jharkendar expedition", "Complete the portal and missing-person prerequisites, then speak to the Water Mages before entering the new land. Read the tablets you find and keep a note of the bandit factions and their leaders."),
            note(3, 14, "Use the four regions methodically", "Jharkendar’s routes connect the swamp, canyon, beach, and mountain areas. Finish local faction requests before entering the next major ruin, and bring the appropriate ornament fragments back to the Water Mages."),
            note(3, 27, "Before leaving Jharkendar", "Resolve Raven’s temple route and return the key story items to the Water Mages. Check the pirate and bandit errands you accepted before using the portal back to Khorinis."),
            note(4, 1, "Dragon Hunt preparation", "Speak with Garond and Oric for the dragon leads. Keep the Eye of Innos charged: after each dragon, use its heart to recharge the amulet before confronting the next one."),
            note(4, 11, "A clean dragon route", "The Valley’s dragons can be tackled in a safer order, from the swamp toward the stone fortress, volcanic crater, and former New Camp. Kill summoned elementals quickly because they can restore a dragon’s health."),
            note(4, 23, "Chapter 4 wrap-up", "Complete the remaining dragon reports, named companions’ errands, and mine objectives before the story returns to Khorinis. Keep the Eye and its charging materials available for the next stage."),
            note(5, 1, "Return to Khorinis", "Talk to familiar leaders after the Valley events; several new reports and follow-ups are tied to those conversations. Finish any city tasks that the changed world state makes urgent."),
            note(5, 4, "Before the voyage", "Recruit a captain and crew, resolve the remaining ship preparations, and buy supplies. Make a permanent save before sailing because the next chapter is the final island expedition."),
            note(5, 7, "Chapter 5 handoff", "Check your equipment, healing, ranged options, and crew before boarding. Once you leave, ordinary Khorinis errands are no longer the priority."),
            note(6, 1, "Irdorath supplies", "Bring strong healing, mana, and ammunition. Speak with the crew and make use of the ship as a safe resupply point during the assault."),
            note(6, 4, "Final chapter checklist", "Rescue and report to companions where possible, search the side rooms for keys and supplies, and make a permanent save before the final confrontation.")
        ),
        GameId.NEW_BALANCE to listOf(
            note(1, 1, "New Balance: plan a long chapter", "Chapter 1 contains a very large number of island quests and several overlapping progressions. Keep the main story moving, but record side-quest names and return to their givers after major discoveries.", "Do not spend learning points just because you can. Decide whether your character is following a class, camp, or weapon path and learn from the trainers that support it."),
            note(1, 50, "Khorinis and the harbor", "Use the city, harbor, farms, and nearby coast as separate sweeps. Packages, debts, missing-person clues, and merchant decisions can open distinct journal entries; finish each delivery with the intended NPC."),
            note(1, 100, "Before the first major departure", "Check access to the Upper Quarter, guild requirements, and the Ring of Water investigation. Make a permanent save before choices that change a merchant, expose a suspect, or close a faction route."),
            note(1, 150, "Island exploration and camp quests", "The expanded island is easier to clear in regional loops. Mark caves, hunters, farms, and camp contacts as you go; return to quest givers after collecting named trophies or evidence."),
            note(1, 200, "Class and faction progression", "New Balance adds long class and camp chains to the original story. Read each prerequisite before spending points or accepting a permanent rank, and keep a separate save before faction admission."),
            note(1, 284, "Chapter 1 transition", "Before advancing, check the Eye of Innos chain, portal requirements, camp decision, and any quests whose warnings mention a chapter deadline. Keep unique tablets, letters, and creature trophies until their quest is closed."),
            note(2, 1, "Chapter 2: resolve the portal leads", "The chapter combines the Portal’s Secret, Raven, Valley of Mines, and several expanded camp routes. Confirm the Water Mages’ next step and keep the ornament and temple evidence rather than selling it."),
            note(2, 55, "Jharkendar and the Valley", "Handle these regions as separate loops. Finish the local camp and companion tasks while nearby, read the Builders’ clues, and report major discoveries before moving into the next dungeon."),
            note(2, 110, "Faction and temple commitments", "Before a major camp or temple decision, check whether you still have work for the other groups. Make a permanent save before joining or betraying a faction, and do not attack neutral leaders needed for later quests."),
            note(2, 160, "Mid-chapter route check", "The later quest list spans the Sleeper’s Temple, pirates, hunters, and Valley follow-ups. Keep keys, named weapons, and evidence until all related journals have updated."),
            note(2, 212, "Chapter 2 transition", "Finish Raven’s consequences, the portal and camp chains, and any warnings tied to the Valley before advancing. Revisit the main quest givers after completing a large region; New Balance often adds a follow-up dialogue."),
            note(3, 1, "Chapter 3: the Eye of Innos", "The main story resumes around Bennet’s imprisonment and the Eye’s repair. Collect testimony and read decisive evidence before reporting it, then arrange the replacement Water Mage before the Sun Circle ritual."),
            note(3, 30, "Regional cleanup", "The island still has optional class, camp, and companion quests during the main story. Complete the ones you want before the chapter’s major ritual and check trainer access before committing to late builds."),
            note(3, 55, "Before the ritual", "Gather the required participants and ritual supplies, speak to Xardas and the Fire Mages, and make a permanent save before the Eye is restored. The restored amulet is required for the dragon hunt."),
            note(3, 84, "Chapter 3 handoff", "Check that Bennet is free, the Eye is repaired, and the remaining chapter-sensitive island work is done before following the dragon story into the Valley."),
            note(4, 1, "Dragon Hunt", "Keep the charged Eye of Innos in your inventory when speaking to each dragon. After every kill, recharge it with the dragon’s heart at an alchemy table before continuing."),
            note(4, 11, "Valley of Mines route", "Follow Garond’s reports and resolve nearby mercenary and dragon-hunter requests as you cross the Valley. Loot dragon hearts and trophies before leaving each area."),
            note(4, 21, "Before Chapter 5", "Report all four dragon victories, collect any faction and companion follow-ups, and prepare the ship route. Make sure your intended guild and dragon-hunter progression is complete."),
            note(4, 31, "Chapter 4 checklist", "Keep the Eye, ship preparations, and outstanding Valley reports settled. The next chapters narrow the route toward the final journey."),
            note(5, 1, "A ship and crew", "Finish the remaining Khorinis errands, recruit a captain and crew, and buy enough healing and ammunition for a long expedition. Save before sailing."),
            note(5, 5, "Before the final voyage", "Review equipment, class abilities, and companion choices. Complete any quest with a chapter deadline before leaving the island."),
            note(5, 10, "Chapter 5 handoff", "Once you are ready, take the ship to Irdorath; the final chapter begins on arrival."),
            note(6, 1, "Irdorath: last preparation", "This is the final chapter. Speak to your crew, train and trade before pressing deeper into the dungeon; return to the ship when you need supplies."),
            note(6, 3, "Final checklist", "Keep keys, special weapons, and quest items from named enemies. Search cells and side rooms before advancing through sealed passages, and make a permanent save before the final battle.")
        ),
        GameId.GOTHIC_3 to listOf(
            note(1, 1, "Myrtana: choose your liberation pace", "Gothic 3 is open-ended, but city liberation changes the world state. Make a permanent save before starting a town uprising and avoid liberating three Orc-held cities before you are ready for the resulting hostility."),
            note(1, 40, "Before starting an uprising", "Complete the town’s wanted errands, named NPC conversations, and rebel contacts first. Once the fight begins, some quests and services can disappear."),
            note(1, 85, "Myrtana transition", "Before leaving the first regional route, review the settlement quests and reputation gates you still care about. Keep unique letters, artifacts, and named trophies for their owners."),
            note(2, 1, "Continue the Myrtana sweep", "Work through settlements and rebel camps in a deliberate loop. Talk to local leaders before clearing a nearby ruin; their requests often explain which group controls the area."),
            note(2, 35, "Faction consequences", "Rebel, Orc, and Hashishin reputation can unlock different services and dialogue. Delay irreversible town liberation until you have finished the local side quests and chosen the outcome you want."),
            note(2, 69, "Regional checklist", "Revisit the settlements from this part and close their local errands before moving the main route forward. Save before turning a neutral dispute into a large battle."),
            note(3, 1, "Expand beyond the first region", "Keep following the main trail while treating each town as its own quest hub. Reputation and dialogue choices can change what leaders will offer, so report discoveries before changing control."),
            note(3, 35, "Use the quest log as a route map", "When several objectives point to the same region, group them into one trip and bring named items back to the correct giver. Do not attack a settlement just to finish a single liberation objective."),
            note(3, 71, "Part 3 wrap-up", "Check regional leaders, open faction tasks, and unfinished companion requests before the next large story push."),
            note(4, 1, "Late Myrtana and Nordmar", "Prepare for longer trips into dangerous territory. Carry healing and cold-protection supplies where needed, and use the named guides or companions offered by the quests."),
            note(4, 37, "Before changing a town’s control", "Finish local jobs and collect unique items before an uprising or liberation. If the quest warns that a leader will become hostile, save and resolve their dialogue first."),
            note(4, 73, "Part 4 transition", "Review the unfinished settlement and faction chains, then return to the story contact who sent you north. Keep rare artifacts and keys until all related quests update."),
            note(5, 1, "Varant preparation", "The desert routes are long and faction reputation matters. Stock up before crossing the wastes and speak with local leaders before taking bounty or liberation work."),
            note(5, 29, "Faction and temple choices", "Several Varant objectives overlap around temples, nomads, and Hashishin. Resolve the local quests you want before changing a city’s control, and keep a save before a major alignment choice."),
            note(5, 57, "Part 5 checklist", "Finish the temple and city errands you care about, then check your reputation and main-story objectives before leaving Varant."),
            note(6, 1, "Final regional decisions", "This part brings major faction outcomes together. Complete local jobs and speak to the leaders involved before choosing which settlements or groups to support."),
            note(6, 34, "Before the endgame", "Check open main quests, unique artifact deliveries, and any city quests affected by liberation. Keep a permanent save before the final faction decisions."),
            note(6, 67, "Part 6 wrap-up", "Revisit the journal for unfinished settlement chains and required artifacts, then follow the main objective when you are ready to commit to the endgame."),
            note(7, 1, "Completion references", "This part contains reference checklists and route maps rather than ordinary journal quests. Use them to verify a full playthrough; their entries do not represent extra in-game quest starts."),
            note(7, 6, "Checklists and dependencies", "Follow the artifact, teleport-stone, and quest-dependency references alongside the journal. Complete each regional item before the world-state change listed in its warning."),
            note(7, 11, "Before you finish", "Use the part’s final reference entries to audit faction outcomes and remaining collectibles. Save before any irreversible city or endgame choice.")
        )
    )

    fun notes(game: GameId, chapter: Int): List<ChapterGuideNote> =
        notesByGame[game].orEmpty().filter { it.chapter == chapter }
}
