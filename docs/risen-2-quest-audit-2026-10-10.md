# Questbound — Risen 2 quest-content reconciliation

**Started:** 2026-10-10  
**Working branch:** `dev/android-foundation-v0.1`  
**Game:** *Risen 2: Dark Waters*, original game (note edition/DLC/patch differences separately).

## Initial source inventory and first correction pass

The inherited catalog contained **204 entries** grouped into **four Questbound story chapters** (46 / 79 / 75 / 4). These sections are an app navigation structure, **not the nine geographic regions of the original guide**.

| Kotlin file | Entries now | Blank giver | Blank prerequisites | Blank rewards |
| --- | ---: | ---: | ---: | ---: |
| Risen2GuidePart1Data.kt | 20 | 0 | 0 | 0 |
| Risen2GuidePart2Data.kt | 26 | 0 | 0 | 0 |
| Risen2GuidePart3Data.kt | 35 | 0 | 35 | 0 |
| Risen2GuidePart4Data.kt | 44 | 0 | 44 | 0 |
| Risen2GuidePart5Data.kt | 31 | 0 | 31 | 0 |
| Risen2GuidePart6Data.kt | 25 | 0 | 25 | 0 |
| Risen2GuidePart7Data.kt | 19 | 0 | 19 | 0 |
| Risen2GuidePart8Data.kt | 4 | 0 | 4 | 0 |
| Risen2GuidePart9Data.kt (new) | 3 | 0 | 0 | 0 |
| **Total** | **207** | **0** | **158** | **0** |

The original 204 IDs and their playOrder values remain unchanged. **207 unique quest IDs**, in consecutive four-chapter lists of **47 / 80 / 76 / 4** after adding the missing entries. All three new IDs were appended to their respective sections rather than renumbering existing quests.

### Quest-content corrections already committed

1. **Caldera + early Tacarigua (Part 1):** completed all 20 prerequisite fields; corrected the core Caldera glory rewards:
   - Meet the Commandant! — **50 Glory**
   - Search the Beach — **50 Glory**
   - Rescue Patty — **100 Glory**, in addition to glory for personally defeated Sand Devils
   - Talk to Carlos — **50 Glory**
   - Provisions (`R2-C1-010`) — **ask Osorio whether he sells food** to finish. This is **not** an item hand-in. 50 Glory and trading access.
   - Flotsam (`R2-C1-004`) — start through Storehouse Master after Patty's rescue and return report to Carlos; complete before leaving.
2. **Tacarigua/Pirates' Den (Part 2):** completed all 26 prerequisite fields. Rewrote:
   - The Sugar Trade (`R2-C1-043`) — Booze's return letter to Di Fuego, financing from Pedro, negotiated settlement, Roquefort courier reward, and return to Booze. **100 Glory**, dialogue-dependent gold and five rum.
   - Distract Alister (`R2-C1-044`) — **Morris** provides the plan, **Lola** diverts Alister at night, with a low-cost option carrying relationship consequences. **50 Glory**.
   - 10 Bloody Roots (`R2-C1-045`) — **Elia** gives the task and awards **100 Glory plus the Bloody Mary recipe**.
3. **New source-confirmed journal entries in Part 9:**
   - `R2-C1-047` — **Flotsam on the Beach Collected**: collecting all six pieces completes an independent **50 Glory** milestone, separate from the Storehouse Master's Flotsam hand-in.
   - `R2-C2-080` — **Got Anything to Eat?**: Sancho's Sword Coast food quest, **50 Glory** and an optional additional **25 Glory** on a second helping.
   - `R2-C3-076` — **The Treasure on Fortress Beach**: Caldera II cave treasure requiring a map from a **Lockpicking 60** chest near Carlos, **100 Glory** and the legendary Comb with One Tooth.
4. Regression coverage updated in `Risen2QuestDataTest.kt`: new section counts, unique IDs, early-giver and reward fixes, and populated Chapter 1 prerequisites.

### Remaining backlog (do not mark Risen 2 complete yet)

- **158 remaining blank prerequisites** in Parts 3–8; especially distinguish Native vs Inquisition choices on the Sword Coast and Maracai Bay, mutually exclusive outcomes, and island-access gates.
- **Quest-title coverage expansion:** Gamepressure's complete Risen 2 guide lists considerably more independently named quests across Sword Coast, Antigua, Isle of Thieves, Caldera II, Maracai Bay, Isle of the Dead and Water Temple than our **207 app entries**. Examples requiring reconciliation: *Blades for Cooper*, *Dance with Tito*, *Firebird Hunt*, *Hidden Lookouts*, *Jim's Treasure Map*, *Gibson's Grave*, *Where Is Rick?*, *The Thief's Curse*, *Black Lotus*, *Follow Hakeke*, and faction-exclusive Maracai tribal subquests. Add only documented actual journal objectives, with exact giver/trigger, three useful walkthrough steps, verified reward or a clearly labelled uncertainty, and stable new IDs.
- **Rewards:** many existing nonempty rewards are *generic text*, not verified Glory figures. Check against quest-specific source pages instead of inventing exact values.
- **Reference-only records:** distinguish any quest-chain summaries or repeated guides from actual journal entries before calculating completion percent; preserve all existing progress keys.
- **Android release check:** source integrity review passed (207 IDs, consecutive order, no blank giver/reward), but latest CI JVM tests and emulator UI tests are not yet confirmed green.

### Principal sources

- [Gamepressure Risen 2 quest walkthrough index](https://www.gamepressure.com/risen2/game-guide/zf8cc1)
- [Gamepressure Flotsam](https://www.gamepressure.com/risen2/flotsam/zf392a)
- [Flotsam on the Beach Collected](https://www.gamepressure.com/risen2/flotsam-on-the-beach-collected/z0392b)
- [Provisions](https://www.gamepressure.com/risen2/provisions/z338f2)
- [Kitchen Help](https://www.gamepressure.com/risen2/kitchen-help/z238e2)
- [The Sugar Trade](https://www.gamepressure.com/risen2/the-sugar-trade/z638d7)
- [Distract Alister](https://www.gamepressure.com/risen2/distract-alister/z438e4)
- [10 Bloody Roots](https://www.gamepressure.com/risen2/10-bloody-roots/z138d2)
- [Got Anything to Eat?](https://www.gamepressure.com/risen2/got-anything-to-eat/zd390a)
- [The Treasure on Fortress Beach](https://www.gamepressure.com/risen2/the-treasure-on-fortress-beach/z43a79)

**Status:** First substantive Risen 2 correction pass done; coverage reconciliation and Chapters 2–4 verification are still outstanding.


## Consolidated prerequisite and Sword Coast expansion — 11 October 2026

This section **supersedes** the initial inventory and open prerequisite count above.

- Completed all **158 previously blank prerequisite fields** across Parts 3–8: **35 Sword Coast opening**, **44 Sword Coast faction/ship**, **31 Antigua**, **25 Isle of Thieves**, **19 Isle of the Dead/Garcia**, and **4 Water Temple**. Parts 1–2 were reconciled previously.
- Existing 204 IDs remain intact, and the first three missing quests in Part 9 remain intact.
- New `Risen2GuidePart10Data.kt`: **12** further source-verified standalone Sword Coast entries, appended as `R2-C2-081` to `R2-C2-092`. These include Basil's Chest, Blades for Cooper, Dance with Tito, Firebird Hunt, Firebirds Blocking the Bridge, Hidden Lookouts, Jim's Treasure Map, Jim's Treasure, Monkey Business and three Sword Coast buried treasure quests.
- The `Risen2-C2-010` *Suspicious Tonka* entry now names **Nakutu**; this only appears with Chani on the Native route. `R2-C2-011` *Four Offerings for Kanadiktu* correctly names **Badriya** and specifies Chani, Nakutu, Ranapiri and Samir. The guide authors disagree whether the gold reward is 100 or 300, so the text preserves uncertainty.
- The three new treasure guides distinguish collection rewards from combat Glory; *The Treasure on Puerto Isabella Beach* explicitly has **no Glory reward**, although the chest contains gold and valuables.

### Current source integrity

| Chapter in Questbound | Entries |
| --- | ---: |
| 1 — Caldera/Tacarigua | 47 |
| 2 — Sword Coast and new side quests | 92 |
| 3 — Antigua, Isle of Thieves, Caldera II, Maracai, Isle of the Dead | 76 |
| 4 — Final Water Temple | 4 |
| **Total** | **219** |

A direct source-level scan of Parts 1–10 found **0 duplicate IDs, 0 duplicate titles**, and **0 blank giver, prerequisite, reward or summary fields**. Chapter ordering remained consecutive, and no original quest ID was renumbered. New unit tests assert 219 entries, faction-exclusive prerequisites and the 12 new quests.

### Still open — genuine content quality work

- **Original-game coverage remains incomplete.** The Gamepressure 2012 quest index has many more standalone objectives than the current 219 entries, particularly Maracai Bay, Caldera II, and Isle of the Dead, plus Sword Coast escort microquests. Add only named, source-confirmed journal quests with useful steps and faction gates.
- **34 entries** still have reward descriptions without a definite numeric Glory payout (including some genuine story quests without a standalone payout). This is **not** equivalent to 34 missing rewards; investigate them individually, and preserve uncertainty rather than inventing values.
- Some early broad location/route summaries need further journal-vs-reference classification, despite all fields being populated.
- Latest *this-commit* Android build and JVM tests are pending. An earlier 11 October workflow passed its build job but its emulator UI suite failed in multiple general navigation tests. These failures are not evidence that the Risen 2 metadata is incorrect, but they must be resolved before full Android release sign-off.

### Verifiable sources used for this pass

- [GameFAQs Risen 2 original walkthrough (quest chains and mutually exclusive paths)](https://gamefaqs.gamespot.com/pc/622499-risen-2-dark-waters/faqs/64985)
- [Gamepressure — full Risen 2 original-game quest index](https://www.gamepressure.com/risen2/)
- [Gamepressure — The Suspicious Tonka](https://www.gamepressure.com/risen2/the-suspicious-tonka/zd3a27)
- [Gamepressure — Four Offerings for Kanadiktu](https://www.gamepressure.com/risen2/four-offerings-for-kanadiktu/ze3a28)
- [Gamepressure — Blades for Cooper](https://www.gamepressure.com/risen2/blades-for-cooper/z539de)
- [Gamepressure — Firebird Hunt](https://www.gamepressure.com/risen2/firebird-hunt/z2390f)
- [Gamepressure — Hidden Lookouts](https://www.gamepressure.com/risen2/hidden-lookouts/z2391e)
- [Gamepressure — Jim's Treasure](https://www.gamepressure.com/risen2/jims-treasure/z53918)
- [Gamepressure — The Treasure on Puerto Isabella Beach](https://www.gamepressure.com/risen2/the-treasure-on-puerto-isabella-beach/z63919)
- [Gamepressure — The Treasure in the Natives' Graveyard](https://www.gamepressure.com/risen2/the-treasure-in-the-natives-graveyard/z339e2)
- [Gamepressure — The Treasure in the Valley of the Jaguar](https://www.gamepressure.com/risen2/the-treasure-in-the-valley-of-the-jaguar/ze391a)

**Status: Risen 2 prerequisite reconciliation is complete; total-quest coverage, item/reward accuracy, and final release verification remain underway.**


## Isle of the Dead quest-index expansion — 11 October 2026 (continued)

**Thirteen more actual in-game journal quests have been added** in `Risen2GuidePart11Data.kt` as stable new IDs `R2-C3-077` through `R2-C3-089`:

1. Akando's Chest
2. Black Lotus
3. Defeat Kusko
4. Follow Motega
5. Grave Dust
6. The Artist's Curse
7. The Hunt
8. The Hunter's Curse
9. The Potion of False Death
10. The Silverback Is Dead
11. The Thief's Curse
12. The Treasure in the Tomb
13. The Warrior's Curse

The original main-story entries **The Journey to the Underworld** and **The Skull Sceptre** were upgraded with exact ingredients and prerequisite quest relationships: Tao requires **five Black Lotus flowers and six Grave Dust containers**; Nahele requires **Steelbeard's Hat, Akando's White Diamond, Kusko's Spear and Motega's undead-animal skull** to make the sceptre. Separately awarded Glory is attached to each individual collection or combat stage, rather than counted as a single reward.

**Source catalog now: 232 entries, all unique, grouped 47 / 92 / 89 / 4; 0 blank required fields.** All legacy IDs preserved, and new tests cover the thirteen Isle of the Dead entries. These are static integrity results, not completed emulator test claims. The Isle of the Dead quest-title list is now represented, except for any alternative title variants or playthrough-specific branch differences that may emerge from final comparison.

**Remaining major content work:** Maracai Bay standalone quests and Caldera II side missions; other Sword Coast and Antigua microquests/treasures; remaining imprecise Glory rewards and giver claims; duplicate/guide-only classification once full coverage is assembled. Do not call Risen 2 completely finished or claim Android UI testing passed.

**Sources:**
- https://www.gamepressure.com/risen2/isle-of-the-dead-quests/za3bcb
- https://www.gamepressure.com/risen2/akandos-chest/zc3bcd
- https://www.gamepressure.com/risen2/black-lotus/zd3bce
- https://www.gamepressure.com/risen2/grave-dust/za3bd1
- https://www.gamepressure.com/risen2/the-hunters-curse/ze3bd5
- https://www.gamepressure.com/risen2/the-warriors-curse/zc3bdc
- https://www.gamepressure.com/risen2/the-artists-curse/zc3bd3
- https://www.gamepressure.com/risen2/the-treasure-in-the-tomb/zb3bdb


## Maracai Bay expansion — 11 October 2026 (second major pass)

**38 additional original-game Maracai Bay entries** have been verified against the individual Gamepressure journal-quest pages and committed without changing any legacy IDs.

- `Risen2GuidePart12Data.kt`, **21 entries** (`R2-C3-090`–`110`): Valdez's Expedition and Hidden Valley, Corrientes's Deserter/Angus branch and Black Dog bounty, Mercutio's wreck supplies (distinct collection and hand-in), the secret fire-barrier discovery, Grave Robbers/Grave Idols/Peace of the Dead and Koraka chain, Map of Maracai, Jamila's Fire Peppers and Nice and Spicy, Bones's Unwanted Sermon, and The Naked Corpses.
- `Risen2GuidePart13Data.kt`, **17 entries** (`R2-C3-111`–`127`): Datu's succession hub, Becoming Halmak, Zaalu/Hakeke branch-specific Black Hunter paws tests, Zaalu's Voodoo possession and three correct answers (**darkness, time, nothing**), Hakeke's four-feather trail, escorts, and the final challenge.
- **Important lockout:** uncovering Corrientes's identity as Garcia before finishing available pirate village quests can cancel Deserter, Black Dog, Grave Robbers and other work. The Angus is Dead / Angus Rescued outcomes are alternatives; returning Angus to Valdez exposes the impostor. Every relevant card warns about the choice.
- **Important faction separation:** the Native route uses Zaalu, Voodoo, and The Three Questions. The Inquisition route uses Hakeke, the Black Hunter and The Four Feathers. Weapons rewarded at the end of Chaka Datu's Legacy are alternatives, **not both rewards in one playthrough**.
- **Rewards:** source-backed Glory/reward fields are populated. Some awards in parent and subquest chains are separate and combat XP depends on the kill. Requirements/Glory can vary with player choices.

**New catalog total:** **270 Questbound records**: chapters 1/2/3/4 = **47 / 92 / 127 / 4**. Source scan: 270 unique IDs, 270 distinct English titles, no empty giver, prerequisite, reward, summary or walkthrough steps. All prior IDs/play orders remain intact; new entries were appended to chapter 3, preserving existing progress keys.

Unit regression coverage now asserts the expanded totals, the 21 early Maracai objectives and 17 exclusive succession objectives. This only proves structural and explicitly asserted details, not that all in-game triggers/Glory values were personally re-played. GitHub Actions' current-commit build/unit/emulator results must be checked independently; earlier failure reports from intermediate commits can reflect temporarily stale quest counts.

**Still genuinely open:** the full **71-title** Maracai reference name-by-name comparison (many smaller grave, beast, treasure, and optional escort tasks still need addition), Caldera II independent quests, Antigua and Sword Coast secondary omissions, uncertain rewards, and emulator/UI verification. Risen 2 is **not finished**.

Original reference index:
https://www.gamepressure.com/risen2/maracai-bay-quests/z93ad1

Key quest-specific references:
https://www.gamepressure.com/risen2/the-hidden-valley/ze3b09
https://www.gamepressure.com/risen2/the-deserter/z93b04
https://www.gamepressure.com/risen2/angus-rescued/zb3ad3
https://www.gamepressure.com/risen2/garcias-masquerade-uncovered/z13ae8
https://www.gamepressure.com/risen2/storage-barrels-from-the-wreck/zb3afa
https://www.gamepressure.com/risen2/the-peace-of-the-dead/z73b0b
https://www.gamepressure.com/risen2/black-dog/zf3ad7
https://www.gamepressure.com/risen2/unwanted-sermon/za3b14
https://www.gamepressure.com/risen2/chaka-datus-legacy/z03ad8
https://www.gamepressure.com/risen2/the-three-questions/z93b0d
https://www.gamepressure.com/risen2/the-four-feathers/zc3b07


### Exact Maracai Bay reference-name coverage crosswalk (October 11, 2026)

Compared the **71 original quest titles** listed under the [Gamepressure Maracai Bay index](https://www.gamepressure.com/risen2/maracai-bay-quests/z93ad1) against `Risen2GuidePart1Data.kt` through `Risen2GuidePart13Data.kt`, including existing Garcia, Bones and Antigua hand-ins regardless of Questbound app chapter. Case and punctuation were normalized. **47 of 71** are already represented by matching titles, leaving **24 named standalone objectives** still missing:

- **Succession/escort/duels (11):** Back to the Village with Zaalu; Duel with Hakeke's Halmak; Duel with Zaalu's Halmak; Follow Daiki to the Ritual Site; Follow Hakeke; Follow Hakeke Through the Jungle; Follow Hakeke to the Cave; Follow Potaka to the Ritual Site; Follow Zaalu; Follow Zaalu Through the Jungle; Get Rid of Potaka.
- **Story/combat/discovery (5):** Garcia's Ship (separate from Seize Garcia's Ship); The Barrier of Flames; The Beast in the Lake; The Beast Is Dead; The Graves of the Ancestors.
- **Feather pickups (4):** The Black Feather; The Blue Feather; The White Feather; The Yellow Feather.
- **Treasure hunts (4):** The Treasure in the Hidden Valley; The Treasure in the Panther Cave; The Treasure on the Hunting Grounds; The Treasure on the Pirate Coast.

This is a **title-to-title coverage comparison**, not a guarantee of identical quest triggers or full reward accuracy. Some quests may be folded into higher-level descriptions; add them as distinct progress records only when an original guide confirms a distinct journal objective. Each new entry must have a stable appended chapter-3 ID and its quest-specific source cited here. A documented branch alternative is never a second quest completable on the same playthrough.

**CI at this checkpoint:** the source head with 270 entries (`e56aaed3692f...`) **passed its Android build and JVM unit-test job** in GitHub Actions run `38120114792`. Emulator instrumentation was still running at the last check, so it is not yet an overall green run.


## Maracai Bay title coverage closed — 11 October 2026

This latest section **supersedes** the prior list of 24 unmatched Maracai titles above. All **24** have now been added as source-backed standalone journal entries in `Risen2GuidePart14Data.kt`, IDs `R2-C3-128`–`151`.

The entries cover:
- Native/Inquisition contender escorts and **both mutually exclusive final Halmak duels**; Daiki/Potaka qualifying quests are not the same as the later final duels.
- Cordobar's **Garcia's Ship** quest (reporting back after boarding), distinct from **Seize Garcia's Ship** (defeating four guards).
- The **Barrier of Flames** (separate from Secret Entrance Found), Hanu's **The Beast in the Lake / The Beast Is Dead**, the four ancestral masks and **The Graves of the Ancestors**.
- The **four feather pickups**, each 50 Glory on the Inquisition route, separate from The Four Feathers hub.
- The **four Maracai treasure quests**: Hidden Valley, Panther Cave, Hunting Grounds and Pirate Coast.

**Maracai Bay title comparison: 71 of 71 titles accounted for** against the Gamepressure quest index as of this source review, counting matching quests previously recorded in existing quest files regardless of app chapter. This is a **title-coverage sign-off for Maracai Bay**, not a claim that mutually exclusive quests are all completable together or that every reward has been independently tested in-game.

**Sources disagree:** Gamepressure lists 200 Glory for Panther Cave treasure, while GameFAQs/Neoseeker gives 100 Glory; the card explicitly records this rather than falsely choosing one. The exact separate Glory payout for Hanu's Beast in the Lake chain is not independently confirmed and is marked accordingly.

**New overall source catalog: 294 unique entries**, chapter counts **47 / 92 / 151 / 4**, no duplicate IDs or duplicate titles, no blank giver/prerequisite/reward/summary/steps. The old entries' IDs/playOrder were preserved and new chapter-3 records appended.

**Outstanding outside Maracai:** Caldera II quests (notably Mauregato and Archives options), Antigua and Sword Coast smaller journal objectives, and remaining quantitative reward checks. CI must be checked at the current commit; emulator UI issues from earlier runs remain a separate app-release blocker.

Sources:
- https://www.gamepressure.com/risen2/maracai-bay-quests/z93ad1
- https://www.gamepressure.com/risen2/garcias-ship/z23ae9
- https://www.gamepressure.com/risen2/the-barrier-of-flames/ze3afd
- https://www.gamepressure.com/risen2/the-graves-of-the-ancestors/zd3b08
- https://www.gamepressure.com/risen2/the-four-feathers/zc3b07
- https://www.gamepressure.com/risen2/the-treasure-in-the-hidden-valley/za3b0e
- https://www.gamepressure.com/risen2/the-treasure-in-the-panther-cave/zb3b0f
- https://www.gamepressure.com/risen2/the-treasure-on-the-pirate-coast/z73b11
- https://www.supercheats.com/guides/risen-2-dark-waters/maracai-sidequests


## 11 October 2026 — Caldera II, Antigua, Sword Coast title and reward reconciliation

This section **supersedes earlier incomplete regional title lists**. No old quest ID or playOrder was removed/reassigned. The source catalog is now **324 distinct entries** grouped across Questbound's four navigation chapters as **47 / 109 / 164 / 4**, with 324 unique IDs, no duplicate English titles, and zero blank giver, prerequisite, reward, summary or walkthrough fields.

### Added, preserving progress IDs

- **Caldera II — Part 15**: 8 entries `R2-C3-152..159` — The Greedy Captain, Mauregato!, Follow the Servant, Errand Boy, Messenger's Attire, The Signet Ring, Scrolls Books and Shelves, Three New Recruits. Corrected existing `R2-C3-064` Following Garcia's Trail (Carlos; 500 Glory) and `R2-C3-065` Access to the Archives (Custodio; 200 Glory; 100 extra from duel). Both Voodoo/Mauregato and Azuro/pass alternatives described and appropriate document-order warning included.
- **Antigua — Part 16**: 5 entries `R2-C3-160..164` — Gibson's Grave, The Treasure in the Grotto on Antigua, The Treasure on a Rocky Plateau of Antigua, Where Is Rick?, There's No Place Like Home. Explicitly distinguished Quinn's 200-Gold treasure map from his 300-Gold Gibson-room key.
- **Sword Coast — Part 17**: 4 entries `R2-C2-093..096`: Interrogate Hawkins, The Warriors in Front of the Temple!, A Terrible Feeling, Through the Rat Cave. Part 17 originally duplicated Back to the Village with Hikoko; that duplicate was replaced with the documented A Terrible Feeling before this sign-off. The true existing Hikoko quest remains `R2-C2-049`.
- **Sword Coast escorts — Part 18**: 13 quest-journal stages `R2-C2-097..109`, including To the Natives, Over the Pass, The Cave at the Pass, Down into the Valley, Across the River, To Puerto Isabella, Over the Bridge, Farther South, Back to the Beginning and the coastal alternative through Puerto Isabella's gates. Each uses its documented 10-Glory step, and warnings distinguish alternate paths.
- Reclassified **existing** `R2-C2-047` as The Jade Cave, and `R2-C2-061` as Eusebio's Debts, matching actual journal titles while preserving IDs.

### Coverage against original 2012 complete Gamepressure Risen 2 quest-index title listing

All the following region-title lists were reconciled, including known alternate English spelling of Steelbeard's Artifact/Artefact:

| Guide region | Original guide title count | Name-coverage |
| --- | ---: | --- |
| Caldera | 7 | All represented |
| Tacarigua | 38 | All represented |
| Sword Coast | 107 | All represented |
| Antigua | 37 | All represented |
| Isle of Thieves | 17 | All represented |
| Caldera II | 12 | All represented |
| Maracai Bay | 71 | All represented |
| Isle of the Dead | 17 | All represented |
| Water Temple | 4 | All represented |
| **Total original index** | **310** | **All 310 accounted for** |

**Important counting distinction:** Questbound has **324 source records** and the Gamepressure region index has **310 unique listed titles**. Questbound includes some additional story hubs, differently named subquest records and merged/unmerged guide objectives, and some faction tasks cannot all complete in one playthrough. **Do not claim there are 324 in-game journal quests or that a 100% progress bar is achievable in one faction route.** A separate classification of legacy nonjournal hub entries and mutually-exclusive progress rules should be completed before publishing a completionist percentage.

### Exact reward, giver and completion fixes (supplement)

- Tacarigua: Grog for the Guards 50 Glory; A Hungry Slave 50 Glory; Pirate Post 100 Glory with conditional gold; Bounty 200 Glory; The Termite Plague 100 Glory + 150 Gold for all 13 termites; Largo's Clothes 100 Glory + 1,000 Gold; Night-time Pursuit **no separate Glory**.
- Sword Coast: Talk to the Pirates at the Tower is a **zero-reward introductory journal stage**; Defeat the Lookouts 100 Glory; The Natives 100 Glory; Crow's Ship 100; Where Is Crow's Ship? 100; Shaganumbi Tribe discovery 50; Duel with Masaru 100 plus 75 for defeat; The Search for the Idol 10; Basil Is Dead! 50; Bartering is a **Torres → Tito → Torres meat parcel** exchange (50 Glory, 200 Gold); Follow Venturo to the City 10 Glory.
- Maracai/Isle Dead: Message from World of Living (Bones → Confused Ghost) 100 Glory; Message from Afterlife (Confused Ghost → Bones) 100; Blood of the Ancestors 200; Search Garcia's Possessions 200; Seize Garcia's Ship 200; Garcia's Logbook 100; Garcia's Treasure 200 plus Earth Amulet.
- Finale: Removed incorrect claim of roughly seven mouth hits against Kraken. Original guide says **four successful mouth hits, then a final precise throw** as the Kraken rises. The Water Temple is one-way; make a separate permanent save before departure.
- Some quests have no separate numerical reward, while others have genuine guide disagreements; leave explicit statements rather than invent exact payouts.

Unit regression tests now validate the 324-record counts/IDs and major confirmed corrections (including the Kraken attack sequence); the full Android **build+JVM+emulator UI test run must be assessed at the newest HEAD**. Intermediate GitHub Actions runs may fail due temporarily obsolete totals, not necessarily source or UI regression.

### Original-game source references used

- https://www.gamepressure.com/risen2/
- https://www.gamepressure.com/risen2/the-greedy-captain/z23a77
- https://www.gamepressure.com/risen2/errand-boy/z43a73
- https://www.gamepressure.com/risen2/scrolls-books-and-shelves/z93a75
- https://www.gamepressure.com/risen2/where-is-rick/z83ba5
- https://www.gamepressure.com/risen2/gibsons-grave/ze3b9e
- https://www.gamepressure.com/risen2/the-jade-cave/ze3909
- https://www.gamepressure.com/risen2/bartering/z03904
- https://www.gamepressure.com/risen2/follow-venturo-to-the-city/z93a32
- https://www.gamepressure.com/risen2/a-message-from-the-world-of-the-living/z93bca
- https://www.gamepressure.com/risen2/a-message-from-the-afterlife/zb3bcc
- https://www.gamepressure.com/risen2/garcias-logbook/z03ae7
- https://www.gamepressure.com/risen2/search-garcias-possessions/z03af6
- https://www.gamepressure.com/risen2/garcias-treasure/za3aea
- https://www.gamepressure.com/risen2/seize-garcias-ship/z23af8
- https://www.gamepressure.com/risen2/defeat-the-kraken/za3bc2

**Source-data verdict:** Quest-title coverage complete against this index; exact numerical rewards and legacy progress classification still contain some explicitly documented uncertainty. **Release verdict:** Green CI on the newest commit and UI/real-device QA not yet confirmed at the time of writing.
