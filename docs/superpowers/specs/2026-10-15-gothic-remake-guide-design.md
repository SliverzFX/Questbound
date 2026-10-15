# Gothic Remake Guide and Gothic Chapter Notes Design

**Date:** 2026-10-15  
**Status:** Conversational design approved; this written spec is awaiting Miha's review. No implementation is authorized until this spec is approved.

## Goal

Add a complete, separately tracked Gothic 1 Remake quest guide to Questbound and place useful chapter notes and tips inside every Gothic-family chapter or part screen that does not already have them.

## Approved scope

### Gothic 1 Remake

- Add a distinct `GameId.GOTHIC_1_REMAKE`; keep the original Gothic 1 guide, saved progress, favorites, and history separate.
- Route the existing **GOTHIC 1 REMAKE** button beneath Gothic 1 to the remake's own game hub.
- Add a six-chapter journal quest catalog. Include verified main, side, automatic, missable, and faction-specific journal entries.
- Use the existing `Quest` fields: stable ID, chapter, play order, canonical title and aliases, category, giver, location, prerequisites, summary, walkthrough steps, reward, warnings, and search tags.
- Add chapter notes/tips for the remake, positioned before the first quest, between quest entries, and after the last quest where useful.

### Existing Gothic-family guides

Add chapter notes/tips to the existing guide sections for:

- Gothic 1
- Gothic II Gold Edition
- Gothic II New Balance
- Gothic 3 (using its existing seven PART sections)

Archolos already has chapter notes, so its content and behavior remain unchanged. Existing quest entries, IDs, ordering, and player progress in these guides remain unchanged; this work adds notes/tips only.

### Notes and tips

- Keep notes/tips as guide-note data, separate from `Quest` records and quest counts.
- Generalize the existing Risen note model and renderer for reuse by all guides while preserving the current Risen and Archolos note placement and rendering.
- Each guide note has a section number, insertion order (`beforeQuestOrder`), a short title, and readable paragraphs.
- `beforeQuestOrder = 1` places a note at the top; other values place it before that quest order; the existing after-last placement remains supported.
- Put concise route advice, preparation, missables, mutually exclusive outcomes, trainer/skill choices, combat or exploration tips, and chapter-transition checklists in these notes. Do not turn advice or checklist items into fake quests.
- This phase covers notes and tips embedded in chapter/part screens. Separate Game Tools references are out of scope.

## Content and verification rules

1. Use canonical English titles from the remake's journal for quest entries. Reconcile localization or punctuation variants as aliases; do not silently rename a journal entry.
2. Include only actual journal quests in the quest catalog. Keep exploration guidance, general errands, and completion checklists in notes unless the game records them as quests.
3. Cross-check each remake quest's giver/trigger, location, prerequisites, order, walkthrough, rewards, and consequential choices against quest-specific references and available in-game journal evidence.
4. Do not use the original Gothic walkthrough as proof of a remake step where the remake changed the location, trigger, route, or outcome.
5. Public remake indexes currently disagree on total quest count (88 versus 89). Treat neither count as authoritative; reconcile the final catalog against the remake's journal and maintain a source ledger mapping each quest ID to its supporting references.
6. Mark uncertain fields plainly in the app's warnings and source ledger. Do not fill gaps by inference without labeling them.
7. For the four existing guides receiving notes, review their existing chapter/part quest order and known decision points so note placement matches the actual guide flow. Do not re-audit or rewrite their quest content as part of this scope.

## Architecture

The app already represents quests with the shared `Quest` model and routes chapter screens by `GameId`. The remake will use its own data object and per-chapter Kotlin data files, following the existing Risen and Gothic chapter-data patterns. Its chapter notes will be included in the same game-specific lookup used by the chapter screen.

The Risen-only `RisenGuideNote` model and `NavRisenGuideNote` renderer will become game-neutral chapter-guide-note types. Existing Risen and Archolos note data will retain identical text, order, and rendering. A new Gothic note lookup will provide content for Gothic 1, Gothic II Gold, New Balance, Gothic 3, and the remake.

Adding the new game ID also requires updating exhaustive game mappings for quest lists, chapter lists and counts, chapter labels, palettes, menu route, search, favorites, and resume/progress keys. The persisted game name must be unique so remake progress cannot collide with original Gothic progress.

## Acceptance criteria

- The remake button opens a distinct remake game hub instead of the coming-soon placeholder.
- The remake hub exposes six chapter entries; chapter contents appear in chronological order.
- Every committed remake quest has a unique stable ID, required quest fields, and a source-ledger entry. Notes/tips do not affect quest counts.
- Every chapter/part screen for Gothic 1, Gothic II Gold, New Balance, Gothic 3, and the remake has useful notes/tips, with opening guidance and additional interstitial or closing notes where they materially help.
- Archolos and all Risen guides retain their current note text, ordering, and display.
- Search, favorites, completion status, Continue/Recent, back navigation, and the Gothic remake placeholder regression tests account for the new distinct game.
- Structural tests detect duplicate IDs, missing required fields, invalid chapter/order references, empty notes, and missing note coverage.
- Android unit tests, UI-test compilation, debug APK build, and emulator UI tests pass before the work is reported complete.

## Source leads

- [THQ Nordic launch announcement](https://thqnordic.com/news/gothic-1-remake-is-out-now-welcome-to-the-colony)
- [Gothic 1 Remake on Steam](https://store.steampowered.com/app/1297900/Gothic_1_Remake/)
- [Community quest index reporting 89 quests](https://colony-guide.com/gothic-1-remake/quests/)
- [Community walkthrough reporting 88 quests](https://colony-guide.com/gothic-1-remake/walkthrough/)

These are starting points for reconciliation, not a substitute for checking the journal and quest-specific walkthrough evidence. The source ledger and final quest list will be created during implementation research.

## Review

This design keeps the remake's state separate from the original, keeps actual quests distinct from chapter advice, and preserves the already-working Risen and Archolos note behavior. The main verification risk is incomplete or inconsistent third-party quest coverage; the source-ledger and journal-reconciliation rules address it.
