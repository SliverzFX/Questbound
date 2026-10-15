# Chapter-page introductions

## Scope

Added 31 opening descriptions for Gothic, Gothic 1 Remake, Gothic II Gold,
New Balance and Gothic 3. The shared chapter-note lookup places each description
before the existing contextual notes and first quest. Gothic 3 uses `Part guide`
because its seven sections group regional quests and reference material.

Risen and Archolos retain their existing opening descriptions. Risen 3 Chapter 2's
existing overview now appears before quest 1 instead of quest 4.

## Content basis

Each description summarizes the quests in the corresponding source section:

- Gothic: `GothicQuestData.kt` and `GothicGuideNotes.kt`.
- Remake: `GothicRemakeChapter1Data.kt` through `GothicRemakeChapter6Data.kt`,
  with the detailed provenance in `gothic-remake-quest-sources.md`.
- Gothic II Gold: the `Gothic2Chapter*` data files. The descriptions distinguish
  the Eye of Innos storyline from the overlapping Jharkendar browsing route.
- New Balance: the `NewBalanceChapter*` data files. The text preserves the
  existing warnings about alternative routes and version-dependent prerequisites.
- Gothic 3: `Gothic3Part1Data.kt` through `Gothic3Part7Data.kt`. Part 7 is explicitly
  described as reference material, not additional journal quests.

Supporting walkthrough references checked on 2026-10-15:

- [Gothic walkthrough](https://strategywiki.org/wiki/Gothic/Walkthrough)
- [Gothic II: Night of the Raven walkthrough index](https://strategywiki.org/wiki/Gothic_II%3A_Night_of_the_Raven/Table_of_Contents)
- [Gothic II: Night of the Raven guide](https://gamefaqs.gamespot.com/pc/920919-gothic-ii-night-of-the-raven/faqs/45017)
- [Gothic 3 walkthrough](https://pcigre.com/gothic-3-walkthrough/)

## Coverage

`ChapterGuideNoteTest` checks that every section of every game has opening text,
that the new Gothic overviews precede their contextual guidance, and that quest
totals and the existing Risen/Archolos note lookups are preserved.
