# Gothic 1 Remake quest source ledger

This ledger supports the remake quest guide in the app. The quest index is used to reconcile exact English titles, chapter assignment, and the indexed rewards. The linked chapter walkthroughs provide quest-specific route context, NPCs, sequence, faction consequences, missables, and combat/puzzle details. The guide summaries are paraphrased for in-app use.

## Reconciliation

The Colony Guide quest index lists 40 + 16 + 17 + 9 + 5 + 1 = **88 chapter-assigned entries** across the six in-game chapters. It separately lists **The Stranger** under “No chapter” (Chromanin 1 reward), which makes the page’s headline count 89. Because the app guide is organized by the six journal chapters, The Stranger is intentionally excluded from chapter quest totals rather than assigned to a chapter without journal evidence. This preserves the index’s distinction and avoids inflating any chapter count.

Another public walkthrough reports a different aggregate total. The app uses the six chapter subtotals and exact named entries as its catalog boundary, not a community headline count. Quest order numbers are stable app ordering within each chapter; they are not claimed to reproduce the game’s hidden activation order.

## Evidence limits and uncertainty

- Quest titles, chapter placement, and listed rewards are checked against the linked full quest index.
- Chapter narrative pages are strong secondary evidence for the linked story beats and route decisions, but they are not first-party journal captures. Some optional side quests have short summaries where publicly indexed evidence gives limited steps. Those entries are kept conservative and the generic follow-up step explicitly depends on what the player’s journal asks.
- In-game journal screenshots and direct save-file verification were not available during this implementation. The catalog should be revised if a release patch changes a displayed title or chapter assignment.
- The source pages report Patch 1.0.5 (August 27, 2026). This is the source snapshot date; later patches may alter quest behavior.

## Per-quest mapping

| App ID | Canonical quest title | Chapter | Evidence |
|---|---|---|---|
| `G1R-C1-001` | A Few Drops Too Much | Welcome to the Colony | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/1/) |
| `G1R-C1-002` | A Letter from the Fire Mages | Welcome to the Colony | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/1/) |
| `G1R-C1-003` | A Piece Of The Pie | Welcome to the Colony | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/1/) |
| `G1R-C1-004` | A Ring for Fingers | Welcome to the Colony | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/1/) |
| `G1R-C1-005` | Aaron's Chest | Welcome to the Colony | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/1/) · [Quest walkthrough](https://colony-guide.com/gothic-1-remake/quests/aarons-chest/) |
| `G1R-C1-006` | Admission to the Swamp Camp | Welcome to the Colony | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/1/) · [Quest walkthrough](https://colony-guide.com/gothic-1-remake/quests/joining-the-swamp-camp/) |
| `G1R-C1-007` | Aiming High | Welcome to the Colony | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/1/) · [Quest walkthrough](https://colony-guide.com/gothic-1-remake/quests/aiming-high/) |
| `G1R-C1-008` | Baloro's Weapon | Welcome to the Colony | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/1/) · [Quest walkthrough](https://colony-guide.com/gothic-1-remake/quests/baloros-weapon/) |
| `G1R-C1-009` | Beak Performance | Welcome to the Colony | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/1/) · [Quest walkthrough](https://colony-guide.com/gothic-1-remake/quests/beak-performance/) |
| `G1R-C1-010` | Beasts of Khorinis I | Welcome to the Colony | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/1/) |
| `G1R-C1-011` | Beasts of Khorinis III | Welcome to the Colony | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/1/) · [Quest walkthrough](https://colony-guide.com/gothic-1-remake/quests/beasts-of-khorinis-iii/) |
| `G1R-C1-012` | Beasts of Khorinis IV | Welcome to the Colony | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/1/) · [Quest walkthrough](https://colony-guide.com/gothic-1-remake/quests/beasts-of-khorinis-iv/) |
| `G1R-C1-013` | By the Hand of a Master | Welcome to the Colony | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/1/) · [Quest walkthrough](https://colony-guide.com/gothic-1-remake/quests/by-the-hand-of-a-master/) |
| `G1R-C1-014` | Casting Shadows (Joining the Old Camp) | Welcome to the Colony | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/1/) |
| `G1R-C1-015` | Customer Recruitment | Welcome to the Colony | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/1/) |
| `G1R-C1-016` | Horatio the Peasant | Welcome to the Colony | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/1/) |
| `G1R-C1-017` | Joining the New Camp | Welcome to the Colony | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/1/) |
| `G1R-C1-018` | Lurker at the Dam | Welcome to the Colony | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/1/) |
| `G1R-C1-019` | New Fence for Fisk | Welcome to the Colony | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/1/) |
| `G1R-C1-020` | New Souls for the Brotherhood | Welcome to the Colony | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/1/) |
| `G1R-C1-021` | Out of Sight | Welcome to the Colony | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/1/) |
| `G1R-C1-022` | Recipe of the Sect | Welcome to the Colony | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/1/) |
| `G1R-C1-023` | Relief for Ghorim | Welcome to the Colony | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/1/) |
| `G1R-C1-024` | Shrike's Hut | Welcome to the Colony | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/1/) |
| `G1R-C1-025` | Snaf's Recipe | Welcome to the Colony | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/1/) |
| `G1R-C1-026` | Something the Matter? | Welcome to the Colony | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/1/) |
| `G1R-C1-027` | Special Pieces | Welcome to the Colony | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/1/) |
| `G1R-C1-028` | The Amulet | Welcome to the Colony | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/1/) |
| `G1R-C1-029` | The forgotten Recipe | Welcome to the Colony | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/1/) |
| `G1R-C1-030` | The Gloves Are Off | Welcome to the Colony | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/1/) |
| `G1R-C1-031` | The Lurker´s Bite | Welcome to the Colony | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/1/) |
| `G1R-C1-032` | The Price of Magic | Welcome to the Colony | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/1/) |
| `G1R-C1-033` | The Raid | Welcome to the Colony | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/1/) |
| `G1R-C1-034` | The Swampweed Harvest | Welcome to the Colony | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/1/) |
| `G1R-C1-035` | The vanished Warder | Welcome to the Colony | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/1/) |
| `G1R-C1-036` | Thirsty Farmers | Welcome to the Colony | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/1/) |
| `G1R-C1-037` | Trial of Trust | Welcome to the Colony | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/1/) |
| `G1R-C1-038` | Ulbert's Storage | Welcome to the Colony | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/1/) |
| `G1R-C1-039` | Up to His Neck | Welcome to the Colony | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/1/) |
| `G1R-C1-040` | Whistler's Sword | Welcome to the Colony | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/1/) |
| `G1R-C2-001` | Beasts of Khorinis II | The Nest of the Minecrawlers | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/2/) |
| `G1R-C2-002` | Bully for Bullit | The Nest of the Minecrawlers | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/2/) |
| `G1R-C2-003` | Cog In The Wheel | The Nest of the Minecrawlers | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/2/) |
| `G1R-C2-004` | Double Double | The Nest of the Minecrawlers | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/2/) |
| `G1R-C2-005` | The Almanac | The Nest of the Minecrawlers | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/2/) |
| `G1R-C2-006` | The Brotherhood's Great Plan | The Nest of the Minecrawlers | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/2/) |
| `G1R-C2-007` | The Brotherhood's Plan | The Nest of the Minecrawlers | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/2/) |
| `G1R-C2-008` | The Focus Stone | The Nest of the Minecrawlers | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/2/) |
| `G1R-C2-009` | The Great Awakening | The Nest of the Minecrawlers | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/2/) |
| `G1R-C2-010` | The Lost Apprentice | The Nest of the Minecrawlers | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/2/) |
| `G1R-C2-011` | The Minecrawlers' Nest | The Nest of the Minecrawlers | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/2/) |
| `G1R-C2-012` | The Orc Cemetery | The Nest of the Minecrawlers | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/2/) |
| `G1R-C2-013` | The Templar's Blade | The Nest of the Minecrawlers | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/2/) |
| `G1R-C2-014` | The Water Mages' Messenger | The Nest of the Minecrawlers | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/2/) |
| `G1R-C2-015` | The Weed Delivery | The Nest of the Minecrawlers | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/2/) |
| `G1R-C2-016` | The Weed Monopoly | The Nest of the Minecrawlers | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/2/) |
| `G1R-C3-001` | A New Allegiance | Artifacts of Ancient Power | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/3/) |
| `G1R-C3-002` | Bar the Truth | Artifacts of Ancient Power | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/3/) |
| `G1R-C3-003` | Flames to the Flood | Artifacts of Ancient Power | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/3/) |
| `G1R-C3-004` | Focus in the Monastery Ruin | Artifacts of Ancient Power | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/3/) |
| `G1R-C3-005` | Focus in the Mountain Fortress | Artifacts of Ancient Power | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/3/) |
| `G1R-C3-006` | Focus in the Troll Canyon | Artifacts of Ancient Power | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/3/) |
| `G1R-C3-007` | Focus Under the Stonehenge | Artifacts of Ancient Power | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/3/) |
| `G1R-C3-008` | Initiation into the Circle of Water | Artifacts of Ancient Power | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/3/) |
| `G1R-C3-009` | Joining the Mercenaries | Artifacts of Ancient Power | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/3/) |
| `G1R-C3-010` | Joining the Templars | Artifacts of Ancient Power | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/3/) |
| `G1R-C3-011` | Joining the Warders | Artifacts of Ancient Power | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/3/) |
| `G1R-C3-012` | Point of no Return | Artifacts of Ancient Power | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/3/) |
| `G1R-C3-013` | Secrets | Artifacts of Ancient Power | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/3/) |
| `G1R-C3-014` | The Focus Stones | Artifacts of Ancient Power | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/3/) |
| `G1R-C3-015` | The Rogues' Camp | Artifacts of Ancient Power | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/3/) |
| `G1R-C3-016` | The Water Mages' Plan | Artifacts of Ancient Power | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/3/) |
| `G1R-C3-017` | Trial of Fire | Artifacts of Ancient Power | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/3/) |
| `G1R-C4-001` | A Shaman Shunned | Xardas | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/4/) |
| `G1R-C4-002` | Beasts of Khorinis V | Xardas | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/4/) |
| `G1R-C4-003` | Escape-Plan | Xardas | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/4/) |
| `G1R-C4-004` | Recovering the Free Mine | Xardas | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/4/) |
| `G1R-C4-005` | The Banner of Banners | Xardas | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/4/) |
| `G1R-C4-006` | The Minecrawler Armor | Xardas | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/4/) |
| `G1R-C4-007` | The Orc Enclave | Xardas | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/4/) |
| `G1R-C4-008` | The Temple of Innos | Xardas | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/4/) |
| `G1R-C4-009` | Xardas | Xardas | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/4/) |
| `G1R-C5-001` | A Warrior's Honor | The Custodians of the Portal | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/5/) |
| `G1R-C5-002` | Between a Rock and a Hard Place | The Custodians of the Portal | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/5/) |
| `G1R-C5-003` | Sleeper's Temple (The Dreamer's Nightmare) | The Custodians of the Portal | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/5/) |
| `G1R-C5-004` | Uriziel | The Custodians of the Portal | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/5/) |
| `G1R-C5-005` | Way to the Sleeper Temple (The Path Chosen) | The Custodians of the Portal | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/5/) |
| `G1R-C6-001` | The Sleeper's Awakening | The Halls of the Sleeper | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) · [Chapter walkthrough](https://colony-guide.com/gothic-1-remake/chapter/6/) |

## Excluded unchaptered entry

| Title | Source classification | Reason |
|---|---|---|
| The Stranger | [Quest index](https://colony-guide.com/gothic-1-remake/quests/) lists it under “No chapter” | Not included in the six-chapter guide until journal evidence assigns it to a chapter. |

## Sources

- [Gothic 1 Remake full quest index](https://colony-guide.com/gothic-1-remake/quests/)
- [Chapter 1: Welcome to the Colony](https://colony-guide.com/gothic-1-remake/chapter/1/)
- [Chapter 2: The Nest of the Minecrawlers](https://colony-guide.com/gothic-1-remake/chapter/2/)
- [Chapter 3: Artifacts of Ancient Power](https://colony-guide.com/gothic-1-remake/chapter/3/)
- [Chapter 4: Xardas](https://colony-guide.com/gothic-1-remake/chapter/4/)
- [Chapter 5: The Custodians of the Portal](https://colony-guide.com/gothic-1-remake/chapter/5/)
- [Chapter 6: The Halls of the Sleeper](https://colony-guide.com/gothic-1-remake/chapter/6/)
