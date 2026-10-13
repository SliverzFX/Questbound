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
        ),
        Quest(
            id = "R3-C2-146", chapter = 2, playOrder = 146, title = "One Made It",
            aliases = listOf(), category = "SIDE QUEST — SOURCE-VERIFIED RECOVERY",
            giver = "Kjeld", location = "Taranis",
            prerequisites = "Speak with Kjeld near the Mages Camp tavern.", summary = "Discover the fate of Kjeld's companions Lina and Tokel.",
            walkthroughSteps = listOf("Find Kjeld by the Mages Camp tavern and agree to investigate the attack.", "Go southwest to the lakeside hut; kill the skeletons and minions and examine Lina's body.", "Swim to the island in the lake, speak to Tokel, and escort him back safely past the Water Lizards.", "Tell Kjeld that Lina died and Tokel survived. Tokel can then help with The Cleaner."),
            reward = "200 Glory and 300 Gold, plus intermediate Glory from discovering Lina and escorting Tokel.", warnings = "",
            searchTags = listOf("Taranis", "Recovered original journal quest"),
        ),
        Quest(
            id = "R3-C2-147", chapter = 2, playOrder = 147, title = "The Lost Treasure",
            aliases = listOf(), category = "SIDE QUEST — SOURCE-VERIFIED RECOVERY",
            giver = "Kamil", location = "Kila",
            prerequisites = "Join the Natives on Kila and talk to Kamil, who guards the bridge to the Natives Village.", summary = "Recover the stolen Precious Idol and choose between returning it to Kamil or selling it to Buddy.",
            walkthroughSteps = listOf("Meet Kamil after joining the Natives; Silver Tongue 30 can earn an additional Sapphire.", "On the pirate beach question Harry, Colby and Cunningham, then tell Buddy what you learned.", "Bring a shovel; from Asali's watering hole follow the southern trail southeast then northeast, watching for a rope trap.", "Dig at the red X on the hill and recover the Precious Idol, an Old Letter and 150 Gold.", "Give the Idol to Kamil for the Rebound spell, or sell it to Buddy for 1000 Gold."),
            reward = "200 Glory; Rebound spell from Kamil OR 1000 Gold from Buddy.", warnings = "Native-faction quest with mutually exclusive final rewards.",
            searchTags = listOf("Kila", "Recovered original journal quest"),
        ),
        Quest(
            id = "R3-C2-148", chapter = 2, playOrder = 148, title = "The Treasure in the Woods of Taranis",
            aliases = listOf(), category = "SIDE QUEST — SOURCE-VERIFIED RECOVERY",
            giver = "Automatic: Treasure Map", location = "Taranis",
            prerequisites = "Pick up the Treasure Map on a wooden bench in front of a warehouse in eastern Taranis harbour.", summary = "Dig up treasure in the southern Taranis jungle.",
            walkthroughSteps = listOf("Collect the Treasure Map from the harbour warehouse bench.", "Bring a shovel and head into the jungle in southern Taranis.", "Avoid or defeat the large Grave Spider near the red X.", "Dig up the chest and collect 90 Gold, a Diamond and the Ring of Magic schematic."),
            reward = "100 Glory; 90 Gold, Diamond and Ring of Magic schematic in the chest.", warnings = "",
            searchTags = listOf("Taranis", "Recovered original journal quest"),
        ),
        Quest(
            id = "R3-C2-149", chapter = 2, playOrder = 149, title = "The Treasure in the Deadlands of Taranis",
            aliases = listOf(), category = "SIDE QUEST — SOURCE-VERIFIED RECOVERY",
            giver = "Automatic: Treasure Map", location = "Taranis",
            prerequisites = "Find the Treasure Map pinned inside the lakeside hut visited in Kjeld's One Made It quest.", summary = "Locate the buried treasure near the southwestern Shadow Lord territory.",
            walkthroughSteps = listOf("While investigating Lina's hut during One Made It, take the Treasure Map from the wall.", "Bring a shovel and travel southwest into the Taranis Deadlands.", "Clear or avoid enemies around the Shadow Lord's lair; defeating the Shadow Lord is not necessary for this treasure.", "Find the red X and dig up 50 Gold, Gold Ore, Golden Goblet and Emerald."),
            reward = "100 Glory; 50 Gold, Gold Ore, Golden Goblet and Emerald in the chest.", warnings = "",
            searchTags = listOf("Taranis", "Recovered original journal quest"),
        ),
        Quest(
            id = "R3-C2-150", chapter = 2, playOrder = 150, title = "Herbs and Tinctures",
            aliases = listOf(), category = "SIDE QUEST — SOURCE-VERIFIED RECOVERY",
            giver = "Nergal", location = "Taranis",
            prerequisites = "Gain access to the Mages Camp's main building and talk to Nergal in its basement.", summary = "Collect five Taranis Herbs from the central lake for Nergal.",
            walkthroughSteps = listOf("Find Nergal in the basement under the main staircase of the mages' building.", "Accept his herbal request and travel to the lake in central Taranis.", "Collect at least five Taranis Herbs growing around the lake.", "Deliver them to Nergal; speak to him again after his initial banana reward to receive the real reward."),
            reward = "200 Glory, Tincture of Toughness and Recipe for Alchemist's Liquor.", warnings = "",
            searchTags = listOf("Taranis", "Recovered original journal quest"),
        ),
        Quest(
            id = "R3-C2-151", chapter = 2, playOrder = 151, title = "Language Lessons",
            aliases = listOf(), category = "SIDE QUEST — SOURCE-VERIFIED RECOVERY",
            giver = "Bisi", location = "Taranis",
            prerequisites = "Reach the Mages Camp and speak with the wandering gnome Bisi.", summary = "Teach Bisi an expression in a short dialogue exchange.",
            walkthroughSteps = listOf("Find Bisi wandering around the Mages Camp or inside the main mages' building.", "Choose the dialogue option to teach him a new saying.", "Finish the conversation to complete the quest."),
            reward = "20 Glory.", warnings = "",
            searchTags = listOf("Taranis", "Recovered original journal quest"),
        ),
        Quest(
            id = "R3-C2-152", chapter = 2, playOrder = 152, title = "The Nameless Captain's Treasure",
            aliases = listOf(), category = "SIDE QUEST — SOURCE-VERIFIED RECOVERY",
            giver = "Automatic: reading Magical Legends", location = "Taranis / Tacarigua",
            prerequisites = "Complete Visiting Rights on Taranis and read Magical Legends upstairs in the mages' headquarters.", summary = "Uncover the buried treasure and the Vial legendary item on Tacarigua.",
            walkthroughSteps = listOf("On Taranis, after Visiting Rights, go upstairs in the main mage building and read Magical Legends.", "Sail to Tacarigua with a shovel and reach the rocky area beside the central beach.", "Find the red X, dig up the chest and loot it to obtain the Vial."),
            reward = "100 Glory for the treasure quest; additional 400 Glory on obtaining the legendary Vial.", warnings = "",
            searchTags = listOf("Taranis", "Recovered original journal quest"),
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
