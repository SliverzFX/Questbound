package com.sliverzfx.gothicquest

internal object Risen3Chapter2Data {
    val quests: List<Quest> = buildList {
        addAll(Risen3Chapter2Part1Data.quests)
        addAll(Risen3Chapter2Part2Data.quests)
        addAll(Risen3Chapter2Part3Data.quests)
        addAll(Risen3Chapter2Part4Data.quests)
        addAll(listOf(
        Quest(
            id = "R3-C2-141",
            chapter = 2,
            playOrder = 141,
            title = "Capt'n Finch's Treasure",
            aliases = listOf(),
            category = "SIDE QUEST — VERIFIED MISSING ENTRY",
            giver = "Automatic: reading Modern Pirates",
            location = "Calador / Kila",
            prerequisites = "Read Modern Pirates in a hut in Calador's fishing village; digging requires Chapter 3 access to Kila's Forbidden Valley.",
            summary = "Recover Capt'n Finch's treasure and the Pirate Flag legendary item.",
            walkthroughSteps = listOf("Read Modern Pirates in a fishing-village hut on Calador to unlock the treasure lead.", "In Chapter 3 open Kila's Large Gate and enter the Forbidden Valley.", "Head northwest into the valley, defeat the spiders and the Soldier of the Oracle near the marked treasure site.", "Dig at the red X with a shovel and open the chest to obtain the Pirate Flag."),
            reward = "100 Glory; Pirate Flag legendary item",
            warnings = "Cannot finish until the Forbidden Valley is accessible in Chapter 3.",
            searchTags = listOf("Calador", "Source-verified missing quest"),
        ),
        Quest(
            id = "R3-C2-142",
            chapter = 2,
            playOrder = 142,
            title = "Liquid Gold",
            aliases = listOf(),
            category = "SIDE QUEST — VERIFIED MISSING ENTRY",
            giver = "Kramer",
            location = "Calador",
            prerequisites = "Talk to Kramer at the Calador tavern and have 100 Gold available to stake.",
            summary = "Win Kramer's tavern drinking contest and claim his chest key.",
            walkthroughSteps = listOf("Speak with Kramer at the Calador tavern and pay the 100 Gold wager.", "During the contest select the bottles faster than Kramer.", "Collect the victory reward and Kramer's Chest Key; his chest is upstairs."),
            reward = "100 Glory, 200 Gold, Kramer's Chest Key",
            warnings = "",
            searchTags = listOf("Calador", "Source-verified missing quest"),
        ),
        Quest(
            id = "R3-C2-143",
            chapter = 2,
            playOrder = 143,
            title = "Cold Nights",
            aliases = listOf(),
            category = "SIDE QUEST — VERIFIED MISSING ENTRY",
            giver = "Mira",
            location = "Calador",
            prerequisites = "During Ernesto's Engraved Candle Holder, falsely blame Nikodim for the theft to please Mira.",
            summary = "Meet Mira at night to receive the special reward offered after siding with her.",
            walkthroughSteps = listOf("Complete Ernesto's Engraved Candle Holder by telling Ernesto that Nikodim stole the item, rather than blaming the goblins.", "Talk to Mira about her promised special reward.", "Return to Mira at night and finish the meeting."),
            reward = "100 Glory",
            warnings = "Mutually exclusive with the truthful Nikodim resolution; do not require this quest in a single-playthrough completion route that chooses honesty.",
            searchTags = listOf("Calador", "Source-verified missing quest"),
        ),
        Quest(
            id = "R3-C2-144", chapter = 2, playOrder = 144,
            title = "Awesome Deal", aliases = listOf(),
            category = "SIDE QUEST — VERIFIED MISSING ENTRY", giver = "Bran",
            location = "Calador", prerequisites = "Speak with Bran at the farm north of Calador's fishing village.",
            summary = "Choose whether to buy Bran's 20 provisions after he unexpectedly raises the price.",
            walkthroughSteps = listOf("Find Bran on the farm north of the fishing village.", "Ask to buy his provisions; the price rises from 250 to 400 Gold.", "Pay 400 Gold, or use Intimidate 60 to reduce the price to 300 Gold.", "Accept the trade and collect 20 Provisions."),
            reward = "100 Glory and 20 Provisions if the deal is accepted.", warnings = "Declining on the first encounter can permanently remove the purchase opportunity.",
            searchTags = listOf("Calador", "Source-verified missing quest"),
        ),
        Quest(
            id = "R3-C2-145", chapter = 2, playOrder = 145,
            title = "Ernesto's Engraved Candle Holder", aliases = listOf(),
            category = "SIDE QUEST — VERIFIED MISSING ENTRY", giver = "Nikodim",
            location = "Calador", prerequisites = "Speak with Nikodim near Ernesto's farm mill on Calador.",
            summary = "Recover the missing candle holder and choose between clearing Nikodim or falsely blaming him.",
            walkthroughSteps = listOf("Find Nikodim near the mill at Ernesto's farm and ask about the theft.", "Investigate the wagon and follow the clues into the goblin-infested area; retrieve the engraved candle holder.", "Return to Ernesto with the item and decide whom to blame.", "Tell the truth about the goblins to clear Nikodim, or lie to favor Mira and unlock Cold Nights."),
            reward = "400 Glory and the Gold Liquor recipe; gold reward varies with dialogue.", warnings = "Mira's branch can lead to Cold Nights; telling the truth can remove her training services. Save before the final accusation.",
            searchTags = listOf("Calador", "Source-verified missing quest"),
        )
        ))
    }

    val notes: List<RisenGuideNote> = buildList {
        addAll(Risen3Chapter2Part1Data.notes)
        addAll(Risen3Chapter2Part2Data.notes)
        addAll(Risen3Chapter2Part3Data.notes)
        addAll(Risen3Chapter2Part4Data.notes)
    }
}
