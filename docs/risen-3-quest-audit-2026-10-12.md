# Questbound — Risen 3: Titan Lords quest audit

**Started:** 12 October 2026  
**Repository:** `SliverzFX/Questbound` — `dev/android-foundation-v0.1`  
**Scope:** Original Risen 3 game quest walkthrough data; distinguish additional-content/DLC quests, faction alternatives and general story-chain summaries.

## Starting point

The inherited Risen 3 guide consisted of **172 existing records** in four Questbound story sections: **10 / 140 / 11 / 11**. These are *app navigation chapters*, not a one-to-one list of the game's distinct journal missions.

Compared with the original 2014–2016 Gamepressure Risen 3 walkthrough index, the guide has **significant incomplete coverage and many blank metadata fields**. It cannot be called finished on the basis of 172 titles. Original-game source index: https://www.gamepressure.com/risen3/game-guide/z58d5d

## Completed first source-reconciliation pass

Updated **40 existing Chapter 2 records** with stable original IDs `R3-C2-098`–`R3-C2-137`. No ID, chapter or playOrder was changed. All 40 now have named or explicitly automatic givers, specific trigger prerequisites, actionable walkthrough steps, a nonblank reward statement and important warning text where relevant.

### Tacarigua (22 records: 098–117 plus 2 original-chain entries)

- **Jack and Inquisition:** News from Puerto Sacarico (Jack), Kicking Ass (Jack / Holtby's stolen goods), Wet Behind the Ears (Pipkin's stash). Both cave quests are safely combined in one visit; the Cruel Lindworm has its own **600 Glory** combat award.
- **Deserters:** Vasco's Stuff (Vasco), Menacing Shadows (Severin; **ten** Menacing Minions), and Death to the Deserters (Sebastiano). **Complete Vasco's and Severin's jobs before killing either deserter.** They may both be spared, and Sebastiano can be given a false report.
- **Governor's murder:** Di Fuego's Corpse: examine the body and blade, steal Sebastiano's Execution Order, question a Nightwatch soldier and confront Sebastiano. An antagonistic reaction can cancel the deserters' task.
- **Horas:** Betray Horas is **optional**; protecting Horas may cancel this quest, whereas betraying him yields **100 Glory / 300 Gold** but harms Soul and can disrupt later dialogue.
- **Osorio:** Off and Away follows Hawke, requires liana climbing (or Parrot form for the purse), and pays **200 Glory / 200 Gold** after returning the purse.
- **Rosco:** Unfathomable Riches (**20 Glory**) → A Stately Chest (**300 Glory**, Rusty Fork) → Parting of Ways (**300 Glory**, Hand Mirror) → Close Enough to Touch (**220 Glory**) → The Biggest Treasure (Ramirez's mutually exclusive answer/reward choices).
- **Other:** Commandant Roquefort's three entry options, Rodriguez's stolen Redeployment Order (**200 Glory / 100 Gold**), lighthouse and mountain treasure maps, Shadow Lord of Madness (**600 Glory / Raw Black Heart**).

### Fog Island (9 records: 118–126)

- Nebulous Suggestions begins in **Bones's dialogue** and pays **100 Glory**.
- Venturo's expedition kills **Rakazor**, finds Rodrigo, then leads to Carlos's hilltop camp.
- Carlos's Paths to the Afterlife involves **five Soul Eaters** including disguised **Raxkarok (Suspicious Duck)** and **Xora Rul (Circe)**. Doing Circe's evil bidding can kill Diaz/Hector and leave the player vulnerable; take Hector's Braggart arm-wrestling first.
- Venturo's Scattered Soldiers mission reports on Fletcher/Hull, Diaz/Hector, Domingo/Gonzales and Nathan; **850 Glory / 300 Gold**.
- Balthazar's United in the Afterlife requires Weathered Bottle Message, Weathered Records, Protector's Notes, Calypso's Skull and the removal of the five Soul Eaters; reward choices differ in Soul, potion and gold.
- Mortimer's escort and treasure are distinct objectives. **200 Glory** for escort, **200 Glory** for treasure, chest with 500 Gold. Killing Mortimer to reveal the map loses the peaceful rewards.

### Isle of Thieves (11 records: 127–137)

- **Critical progression rule:** In Kaan's Goblin Invasion, collect **four Auri Culci from goblin encampments without killing goblins first**. Only AFTER the nonlethal return can you pursue Ulvi's northern scouts, 14 camp goblins and the Goblin King. The main chain is a multistage quest, so rewards can be cumulative and should not be counted as a simple single-payout statement.
- Akila's Lucky Coin offers four recovery methods, then a **Pearls / Gold Ore / Crown** choice.
- Malik's missing hammer is in a nearby crate (**40 Glory, 5 Gold, Raw Chicken Drumstick**). His separate Escaped quest rescues Dowi from Russel's slavers.
- Zeki's Graveyard Gardener clears six goblins in a tomb; gold/pot/both choices change Soul.
- Trawi's Gnome Riddle correct answers: **He's with the mother; On Calador; White**.
- Gabu's Gnome Eater refers to a *Risen 3* Leviathan, not the analogous **Risen 2** quest with a different giver and payout.

Principal per-quest sources:
- https://www.gamepressure.com/risen3/side-quests-tacarigua/zd6779
- https://www.gamepressure.com/risen3/death-to-the-deserters/za6785
- https://www.gamepressure.com/risen3/di-fuegos-corpse/z56780
- https://www.gamepressure.com/risen3/parting-of-ways/z6678a
- https://www.gamepressure.com/risen3/close-enough-to-touch/z7678b
- https://www.gamepressure.com/risen3/paths-to-the-afterlife/za66e9
- https://www.gamepressure.com/risen3/the-scattered-soldiers/zc66ea
- https://www.gamepressure.com/risen3/united-in-the-afterlife/z366eb
- https://www.gamepressure.com/risen3/goblin-invasion/z86765
- https://www.gamepressure.com/risen3/the-lucky-coin/zc6769
- https://www.gamepressure.com/risen3/gnome-riddle/z7676d
- https://www.gamepressure.com/risen3/the-gnome-eater/z8676e

## Source-level checks after first pass

| Kotlin quest-data source | Existing entries | Blank giver | Blank prerequisites | Blank reward |
| --- | ---: | ---: | ---: | ---: |
| Risen3Chapter1Data.kt | 10 | 0 | 10 | 0 |
| Risen3Chapter2Part1Data.kt | 35 | 2 | 35 | 2 |
| Risen3Chapter2Part2Data.kt | 35 | 7 | 35 | 7 |
| Risen3Chapter2Part3Data.kt | 35 | 7 | 27 | 7 |
| Risen3Chapter2Part4Data.kt | 35 | 0 | 0 | 0 |
| Risen3Chapter3Data.kt | 11 | 1 | 11 | 1 |
| Risen3Chapter4Data.kt | 11 | 0 | 11 | 0 |
| **Total** | **172** | **17** | **129** | **17** |

All 172 quest IDs are distinct; no duplicate English titles were found in the inherited catalog. Tests now ensure that the repaired **40-record batch has no blank essential fields**, an actionable step sequence, and source-specific rewards/choice warnings.

**These are source-level assertions only.** The newest GitHub Android build, JVM unit tests and emulator instrumentation must pass at the new HEAD, and the original-game journal-title list still must be compared item by item before overall coverage can be considered complete.

## Remaining work: do NOT claim Risen 3 finished

1. Reconcile missing original-game quests in **Calador, Kila, Taranis, Antigua, Skull Island**, including independent small journal stages, rewards and giver identities. Do not invent new titles from broad prose; check each title against an original journal/guide entry.
2. Verify and populate the **129 remaining blank prerequisites**, **17 givers**, and **17 reward descriptions**. Do not disguise unknown numeric Glory behind invented precision.
3. Preserve saved quest IDs and playOrder; append truly missing standalone objectives with new stable IDs, updating chapter expectations and reference-only classification as necessary.
4. Properly distinguish mutually exclusive **Demon Hunter / Native / Guardian** faction initiations and any permanently missable NPC decisions; these must not count toward a single-playthrough 100% requirement.
5. Audit the **Tacarigua Become a Voodoo Master** cross-island quest, which may be present in another island under a different title, and finish any not-yet-verified Rosco/treasure milestone aliases.
6. Check CI and compile on Android after source updates, then do an app usability pass (readability of lengthy walkthroughs, tablet layouts, route-specific completion).

**Status: Risen 3 audit ACTIVE, 40 existing quests polished and 132 other existing entries still require cross-check or coverage work.**


## Further milestone — prologue and post-faction prerequisites, 12 October 2026

**32 more records** now have useful trigger prerequisites, without altering their titles, IDs or playOrder:

- All **10 Chapter 1** records: Patty's shipboard vision and Crab Coast temple; Dragon Snapper, Hellhound, lever, magic scroll and Parrot Flight subquests; the post-death Bones revival.
- All **11 Chapter 3** records: Eldric's eastern-Calador entry, Ancient Spell, recruiting Zacharias/Chani, Kila's Large Gate and Forbidden Valley, Oracle challenges, ritual location and final Spirit Ritual. Most demand a permanent faction decision or prerequisites from the other islands.
- All **11 Chapter 4** records: Bones's traitor revelation, Alvarez's multi-faction ship alliance, Crow, Skull Island's camp missions, recruiting the rescued mages and the Nekroloth finale.

New source-level remaining blanks: **17 givers, 97 prerequisites and 17 rewards**, all concentrated in the Chapter 2 Calador/Kila/Taranis imports except a single Chapter 3 giver/reward. The **40-record Tacarigua/Fog Island/Isle of Thieves batch is fully populated**. Total count remains **172**, with all saved-progress IDs unchanged. Regression tests now check all late-chapter prerequisites and the original four-chapter counts.

**Release status:** current Android build, JVM unit test and emulator instrumentation must be verified on the latest commit; no green result has been asserted for this follow-up. The original game's wider quest-title coverage remains a separate incomplete task.

## Continuing audit — Crab Coast / Antigua triggers

Eleven additional Chapter 2 entries (`R3-C2-001`–`R3-C2-011`) now contain explicit start conditions and cross-quest dependencies, preserving every existing ID and ordering. The source-backed sequence includes Bones's post-revival conversations, Ramon's introductory escort unlocking Edward and the crystal quest, and Alvarez's report unlocking the Harbour Town cleanup. The other trigger statements follow the existing guide chain and should still receive a full per-entry source comparison.

**Current source-field tally:** 86 blank prerequisite fields remain (97 minus 11); 17 blank givers and 17 blank rewards remain. The catalog still has 172 entries. This does *not* constitute coverage certification or an Android build pass.

Cross-checks: https://www.gamepressure.com/risen3/lets-get-out-of-here/z26660 ; https://www.gamepressure.com/risen3/bring-ramon-into-the-harbour-town/z067ba ; https://www.gamepressure.com/risen3/find-the-demon-hunter-on-antigua/z167bb .

## Continuing audit — Chapter 2 prerequisite navigation, 12 October 2026

A further **71 Chapter 2 prerequisite fields** were populated without changing IDs, titles, chapter assignments or playOrder: 24 in `Risen3Chapter2Part1Data.kt` (012–035), 35 in `Risen3Chapter2Part2Data.kt` (036–070), and 12 in `Risen3Chapter2Part3Data.kt` (071, 072, 074, 075, 077, 078, 087, 088, 091–093, 097). Along with the preceding eleven (001–011), this reduces the prior **86 blanks to 15**. Existing **17 blank givers and 17 blank rewards** remain. Total records: **172**.

These additions clarify navigation/trigger conditions from the already-imported quest narratives, plus cross-island and mutually exclusive faction requirements. **They are not all independently source-verified**: an explicitly cautious trigger is preferable to invented precision, but ambiguous entries (especially generic Calador/Taranis workers and late-rank entries) still need line-by-line source checking and fuller walkthroughs. The preliminary coverage comparison already identifies source-index titles absent from the inherited Calador catalog (e.g. `Capt'n Finch's Treasure`, `A Big Haul`, `Ernesto's Engraved Candle Holder`, `Cold Nights`, `Liquid Gold`, `Awesome Deal`, `Dangerous Liaison` and `John's Treasure`). Do not treat the 172 current records as exhaustive.

Sources used to check chapter indexing and quest chains:
- https://www.gamepressure.com/risen3/side-quests-calador/z7666e
- https://www.gamepressure.com/risen3/map-side-quests-calador/z8666f
- https://www.gamepressure.com/risen3/side-quests-antigua/z767b8
- https://www.gamepressure.com/risen3/map-side-quests-kila/z466c5
- https://www.gamepressure.com/risen3/shattered-inheritance/z467be

**Validation pending:** latest Android compilation, JVM tests and emulator/UI testing; no green checks claimed.

## Completion attempt — source-verified spot corrections

Source-verified `R3-C2-095` and `R3-C2-096` against Gamepressure's individual Zakir entries. The former triggers automatically when retrieving the item from Faruco's chest during Agila's Private Store chain, and pays 200 Glory upon return; the latter needs Chapter 3 and first quest completion, takes place atop Zacharias's tower, and pays 200 Glory + Sapphire on return. Neither should be represented as a vague post-faction generic quest. Source: https://www.gamepressure.com/risen3/bring-zakirs-auri-culci-back/z26741 and https://www.gamepressure.com/risen3/bring-zakirs-auri-culci-back-again/z7684e .

Source-verified `R3-C2-041` Ghost Eyes giver Drake and its six western-Calador ghosts, restricted to Demon Hunters: https://www.gamepressure.com/risen3/ghost-eyes/z767ee .

**Coverage blocker confirmed:** the game guide's original-game quest index includes independent entries absent from the imported catalog, including `Capt'n Finch's Treasure`, `A Big Haul`, `Ernesto's Engraved Candle Holder`, `Cold Nights`, `Liquid Gold`, `Awesome Deal`, `Dangerous Liaison`, `John's Treasure`, and many Kila/Taranis entries. Reference: https://www.gamepressure.com/risen3/game-guide/z58d5d . Existing chapter allocations and saved quest IDs should remain unchanged while adding individually verified standalone records. The quest catalog is **not complete**. No compile/test pass was demonstrated for these commits.

## Further verified fixes and newly recovered catalog entries — 12 October 2026

Corrected original records:
- `R3-C2-018` Become a Voodoo Master: Hirutu, Native-only initiation, cross-island Red / Emma / Abbas tasks, Tenya and Hirutu promotion, and separate stage rewards. https://www.gamepressure.com/risen3/become-a-voodoo-master-side-quests-kila/z767e5
- `R3-C2-026` Letter for Harry: Killian on Calador; Harry on Kila; 200 Glory and 100 Gold. https://www.gamepressure.com/risen3/letter-for-harry/z466ce
- `R3-C2-073` The Cleaner: Vetranio's broom for Tokel (after One Made It); 100 Glory, 100 Gold. https://www.gamepressure.com/risen3/the-cleaner/z2672c
- `R3-C2-094` Waterproof: Mauricio, Guardian-only, following golem defeat; three samples. https://www.gamepressure.com/risen3/waterproof/z867d7
- `R3-C3-010` The Tower in the Shadows: Becca's eastern-Calador lighthouse monsters; 100 Glory, 100 Gold. https://www.gamepressure.com/risen3/the-tower-in-the-shadows/z36841

Added three independently verified original-game quest entries after the existing Chapter 2 records, preserving `R3-C2-001` through `R3-C2-140`:
- `R3-C2-141` Capt'n Finch's Treasure: Modern Pirates book on Calador, Chapter 3 Forbidden Valley on Kila, Pirate Flag. https://www.gamepressure.com/risen3/captn-finchs-treasure/z4684b
- `R3-C2-142` Liquid Gold: Kramer's Calador tavern challenge. https://www.gamepressure.com/risen3/liquid-gold/z76683
- `R3-C2-143` Cold Nights: Mira's mutually exclusive branch following Ernesto's stolen candle holder. https://www.gamepressure.com/risen3/cold-nights/z56681

**New cardinality:** 175 original records (10 / 143 / 11 / 11). JVM expectations adjusted. **Still not complete:** source-index comparison finds other missing standalone quests (notably Ernesto's Engraved Candle Holder, A Big Haul, and multiple Taranis/Kila quests) and placeholder walkthroughs; other fields remain unverified. CI was in progress at commit `6edc8d1` when last checked; no successful Android or unit-test result should be asserted yet.

## Further recovery — Calador entries (12 October 2026)

Added `R3-C2-144` Awesome Deal (Bran, 100 Glory and 20 Provisions if purchased; Intimidate 60 can lower cost) and `R3-C2-145` Ernesto's Engraved Candle Holder (Nikodim, farm theft resolution, alternate truth/Mira route, Gold Liquor recipe) while preserving prior IDs. Sources:
- https://www.gamepressure.com/risen3/awesome-deal/z96685
- https://www.gamepressure.com/risen3/ernestos-engraved-candle-holder/z46680

**Catalog now 177 entries** (10 / 145 / 11 / 11); source-level expectation assertions changed. The imported catalog is **still incomplete** relative to the external guide's many Kila/Taranis/Calador journal quests, and some inherited quest details remain generic or unverified. Do not mark audit complete on field population alone. GitHub Actions for the newest commits was queued/in-progress when checked; no successful build or test validation was observed.

## Additional source-index reconciliation — 12 October 2026

The GitHub Actions run on prior HEAD `eb4a2a8` completed successfully, as did `70e3dbf`. Subsequently:

- Corrected **Rum for Rumold** (`R3-C2-066`) from an invented Rumold rum-delivery job to Gadi's harbour riddle. The answer is **One**, reward **100 Glory**. Source: https://www.gamepressure.com/risen3/rum-for-rumold/z0672a
- Added four verified missing records without renumbering any previous saved IDs:
  - `R3-C2-146` **One Made It**, Kjeld, southwest lake: Lina's body, rescue Tokel, 200 Glory and 300 Gold. https://www.gamepressure.com/risen3/one-made-it/z26732
  - `R3-C2-147` **The Lost Treasure**, Kamil, Kila, Native-only; Idol can be returned for Rebound spell or sold to Buddy for 1000 Gold. https://www.gamepressure.com/risen3/the-lost-treasure/z867e6
  - `R3-C2-148` **The Treasure in the Woods of Taranis**, harbour warehouse map, southern jungle chest, 100 Glory. https://www.gamepressure.com/risen3/the-treasure-in-the-woods-of-taranis/z1672b
  - `R3-C2-149` **The Treasure in the Deadlands of Taranis**, Lina's lakeside hut map, southwest Deadlands chest, 100 Glory. https://www.gamepressure.com/risen3/the-treasure-in-the-deadlands-of-taranis/za6749
- Catalog now **181 records** (10 / 149 / 11 / 11); regression-test counts updated, all original IDs preserved.

**Not yet complete**: Kila and Taranis sources index additional journal quests not present in the catalog; placeholder metadata and generic text remain. Latest CI post-181-record change must be checked before claiming successful test validation.

## 13 October 2026 continuation — source-index repairs

**Catalog: 187 entries (10 / 155 / 11 / 11).** Original quest IDs 001–140 in Chapter 2 and all previous chapter IDs are preserved. Newly appended:

- 150 Herbs and Tinctures (Nergal, five herbs, recipe/Tincture) https://www.gamepressure.com/risen3/herbs-and-tinctures/z3673c
- 151 Language Lessons (Bisi, 20 Glory) https://www.gamepressure.com/risen3/language-lessons/z16740
- 152 The Nameless Captain's Treasure (Magical Legends on Taranis, Vial on Tacarigua) https://www.gamepressure.com/risen3/the-nameless-captains-treasure-side-quests-taranis/z5673e
- 153 Get Back Soon, Lad (Harry/Douglas on Kila) https://www.gamepressure.com/risen3/get-back-soon-lad/z366cd
- 154 Precious Silverware (Colby, deliberately lose Striking Arguments) https://www.gamepressure.com/risen3/precious-silverware/z166d1
- 155 Monkey Business (Pamir, Monkey Trainer, earring) https://www.gamepressure.com/risen3/monkey-business/z766d7

Existing entry R3-C2-089 The Gourmet was corrected to Lumbrok's Aromatic Wine request on Kila, sourced at https://www.gamepressure.com/risen3/the-gourmet-side-quests-kila/z76773 .

The original source index still lists other quests absent from the app (for example Taranis: We're a Band of Brothers, Gnome in the Hole, Crazy Homis, and John's Treasure; Kila: On the Warpath, Big White Hunter, and Revenge is Sweet). Additional entries and old generic walkthroughs require review before declaring coverage complete. CI for newest commits and device instrumentation not yet verified.

## 13 October 2026 — next seven recovered original journal entries

Appended **R3-C2-156** We're a Band of Brothers (Downes), **157** Gnome in the Hole (Abbas), **158** John's Treasure (Faded Diary from Taranis, dig on Calador), **159** On the Warpath (Hirutu and Tenya's Kila voodoo diplomacy), **160** Crazy Homis (Raka and Brown), **161** The Most Dangerous Gnome in the World (Brown/Raka follow-up), and **162** Big White Hunter (Tadashi's alligator and warthog test). Quest giver, start trigger, multi-step walkthrough and reward fields were provided for each. All earlier save IDs remain stable. Source references:
- https://www.gamepressure.com/risen3/were-a-band-of-brothers/z36742
- https://www.gamepressure.com/risen3/gnome-in-the-hole/z46743
- https://www.gamepressure.com/risen3/johns-treasure/z56771
- https://www.gamepressure.com/risen3/on-the-warpath/z466d4
- https://www.gamepressure.com/risen3/crazy-homis/z56744
- https://www.gamepressure.com/risen3/the-most-dangerous-gnome-in-the-world/z66745
- https://www.gamepressure.com/risen3/big-white-hunter/z366d3

**194 records (10 / 162 / 11 / 11).** Regression test totals adjusted, but newest build status pending. Source index still includes quests absent from the app (including A Delectable Meal, Better Safe Than Sorry, Revenge is Sweet, and other standalone Kila/Taranis content); do not declare fully complete or exhaustively verified.

## 13 October 2026 — Kila quest-chain audit

Added three Kila journal records with stable new IDs `R3-C2-163` A Delectable Meal (Ixil and Baraka, truth-versus-lie rewards), `R3-C2-164` Better Safe Than Sorry (Miamiti's nighttime escort, completion reward 200 Glory + Black Pearl), and `R3-C2-165` The Reckoning (Baraka and Ixil). The Reckoning payout is deliberately not asserted as a verified number. Also corrected `R3-C2-061` Forbidden Fruit to require completion of Better Safe Than Sorry first. Source: https://www.gamepressure.com/risen3/a-delectable-meal/z566d5 ; https://www.gamepressure.com/risen3/better-safe-than-sorry/z666d6 ; https://www.gamepressure.com/risen3/the-reckoning/z966d9 ; https://www.gamepressure.com/risen3/forbidden-fruit/z566cf .

**Catalog now 197 entries (10/165/11/11)**. Test counts updated but the latest CI results must still be checked. Remaining Kila index entries include Revenge is Sweet, Useless Existence, All Cats Are Grey By Night, Completely Lost; remaining Calador/Taranis and crew/weapon-guide coverage not certified. No 100% completion claim.

## 13 October 2026 — Patty/Slim recovery

Added `R3-C2-166` Revenge is Sweet with Patty, captive Slim, On the Warpath gate, Hirutu's sacrifice/spare decision and 500 Glory reward. Source: https://www.gamepressure.com/risen3/revenge-is-sweet/z866d8 . Catalog is **198 entries (10 / 166 / 11 / 11)**, existing IDs stable and regression expectations updated. Remaining external-index omissions and generic entries still need review; newest CI unverified.

## 13 October 2026 — northern Kila island reconciliation

Appended three missing original journal entries, all with separate stable IDs and walkthroughs:

- `R3-C2-167` **Useless Existence** — Leonard's gear in the southwestern cove of the northern island; 200 Glory + 3 Magic Crystals. Sources: https://www.gry-online.pl/poradniki/risen-3-wladcy-tytanow/bezuzyteczna-egzystencja/z111717 and https://gamefaqs.gamespot.com/pc/763908-risen-3-titan-lords/faqs/75733
- `R3-C2-168` **All Cats Are Grey By Night** — Cole, five Ghouls; Swamp Golem optional; 200 Glory. https://www.gamepressure.com/risen3/all-cats-are-grey-by-night/z266db
- `R3-C2-169` **Completely Lost** — Chapter 3 only; escort Crouse east from Forbidden Valley's beach to the Large Gate; faction-specific rewards. https://www.gamepressure.com/risen3/completely-lost/z5684c

Also upgraded `R3-C2-088` **The Swordmaster's Treasure**: read book upstairs at Taranis mage HQ, dig on north Kila island hill near Cole's Ghouls, receive 100 Glory and chest's Tattered Scabbard. https://www.gamepressure.com/risen3/the-swordmasters-treasure/z86774

**Catalog now 201 quest records (10 / 169 / 11 / 11), maintaining the original quest IDs.** The original Kila side-quest index's previously called-out three omissions are now represented. Wider game coverage, source-level metadata gaps, precise reward verification and Android device instrumentation are not certified. The latest workflow must pass before marking this commit built.

## 13 October 2026 — consolidated source-index completion milestone

**Scope:** Original-game walkthrough coverage of the *Gamepressure Risen 3 PC guide index* across all island side/main sections, crew, weapons and other/sea quests. This is not the same as certifying the entire engine journal, all possible branching saves, DLC, or a human-playtested 100% run. Its current **241 app navigation entries include two explicitly reference-only/duplicate milestones**, and cannot be interpreted as 241 separate completable journal quests.

### Source index reconciliation

- Retained the initial 172 record IDs and the intervening appended IDs while recovering a further **27 records in one consolidated pass**: 13 Calador/Kila/Taranis missions (`R3-C2-170`–`182`); 17 distinct crew and companion missions (`R3-C2-183`–`199`); and ten forging/open-sea missions (`R3-C2-200`–`209`). **Note: the combined figure is 40 new records in this pass (13 + 17 + 10)**; the original count rose from 201 to 241. Saved identifiers and ordering for previous quest records were not changed.
- Identified that `R3-C2-152` duplicated the existing `R3-C2-111` The Nameless Captain's Treasure. Kept ID 152 for saved data compatibility but renamed it to **Taranis clue — The Nameless Captain's Treasure**, explicitly labelled **REFERENCE ONLY** and linked the genuine quest 111. `R3-C2-092` (A New Rank — Guardians) is another legacy **REFERENCE ONLY** record for `R3-C2-091` Advancing Among the Guardians, not a distinct Guardian promotion mission.
- Replaced missing and misleading data in 26+ earlier Calador and Taranis records, including Drake's Demon Hunter rank and Ghost Eyes, Mason's Test of the Righteous, Yakov's optional Chapter-3-only fight, Green Flames, Graham's turnips, the Nameless One's campfire, Wilson's letter from Grace, Lami's missing-gnome chain, Taranis tavern minigames, Magnus's promotion, Waterproof, and the Chapter-3 Inquisition alliance.
- Made faction restrictions explicit. Do **not** require all three initiations or opposing faction-specific promotions for a single save. Yakov's quest appears only if the player chooses violence, whereas a peaceful refund does not create the mission.

### Data validation

- Source-code audit of all eight Risen 3 quest files on the development branch found **241 distinct IDs, 241 distinct displayed titles, zero blank givers, zero blank prerequisite fields, zero blank reward fields and zero missing walkthrough-step lists**.
- Automated JVM regression assertions added to check the four-section counts **10 / 209 / 11 / 11**, contiguous playOrder, unique IDs/titles, nonblank metadata and stable reference IDs.
- **Android CI:** the GitHub Actions build for this latest work must report success before claiming a verified compilation. No physical-device or emulator test pass has been observed for these new changes.

### Scope and outstanding certification constraints

The index reconciliation is now suitable as the **source-guide coverage milestone**: known separately indexed quests are represented and known shared/duplicate titles are cross-referenced, not silently double-counted. However, original in-game journals may split multiple objectives into smaller errands, source reference rewards for some stages remain explicitly unverified, and the two reference-only entries should not be treated as additional independent completion requirements. A true end-to-end **in-game 100% trophy / every internal quest state** certificate is not established by this static guide comparison. Completion is also contingent on the latest build and gameplay smoke test.

Principal references:
- https://www.gamepressure.com/risen3/
- https://www.gamepressure.com/risen3/side-quests-calador/z7666e
- https://www.gamepressure.com/risen3/side-quests-taranis/z36724
- https://www.gamepressure.com/risen3/ghost-eyes/z767ee
- https://www.gamepressure.com/risen3/a-new-rank-side-quests-calador/z567ec
- https://www.gamepressure.com/risen3/advancing-among-the-guardians/z567d4
- https://www.gamepressure.com/risen3/green-flames/z5666b
- https://www.eliteguias.com/guias/r/risen3/risen-3-titan-lords-p216.php
