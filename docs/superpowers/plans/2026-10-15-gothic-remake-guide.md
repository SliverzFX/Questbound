# Gothic Remake Guide and Gothic Chapter Notes Implementation Plan

> **For agentic workers:** REQUIRED SUB-SKILL: Use superpowers:subagent-driven-development (recommended) or superpowers:executing-plans to implement this plan task-by-task. Steps use checkbox (`- [ ]`) syntax for tracking.

**Goal:** Add a distinct six-chapter Gothic 1 Remake guide and useful in-chapter notes for the five Gothic guides that need them.

**Architecture:** Generalize the existing Risen chapter-note model and Compose renderer into game-neutral guide notes while preserving the current Risen and Archolos text and placement. Add structured Gothic note data and a distinct remake GameId whose quest catalog, chapter notes, hub, saved progress, search, favorites, and palette all route independently.

**Tech Stack:** Kotlin, Jetpack Compose, Android, JUnit 4, Android Compose UI tests, GitHub Actions.

**Spec:** `docs/superpowers/specs/2026-10-15-gothic-remake-guide-design.md`

## Global Constraints

- Preserve existing quest IDs, quest order, and progress for Gothic 1, Gothic II Gold, New Balance, Gothic 3, Risen, and Archolos.
- Do not change Archolos or Risen note text, order, or rendering.
- Keep advice and checklists in guide notes, never as fake quest records.
- Remake quests must use canonical English in-game journal titles and have a source-ledger entry.
- Reconcile the remake catalog against journal evidence; neither public index total (88 or 89) is authoritative.
- Keep Gothic Remake progress separate from original Gothic progress through a unique persisted game name.

## Review Focus

- A chapter note references a quest order outside that chapter — test every note insertion point against the chapter's actual order range.
- A note-only game accidentally changes quest totals or progress — assert note counts do not affect quest lists or saved-game keys.
- Existing Risen/Archolos notes drift during model generalization — compare ordered note data and preserve the existing UI placement paths.
- Gothic Remake falls through an exhaustive game switch — add route/data/palette coverage for its GameId in the owning integration task.
- Remake quests are duplicated or unsupported — assert unique IDs, required fields, valid chapter references, and one source-ledger mapping per quest.

---

## Files and Responsibilities

- Modify `app/src/main/java/com/sliverzfx/gothicquest/RisenQuestData.kt`: replace the Risen-only note type with the shared note type and retain Risen note lookup.
- Modify `app/src/main/java/com/sliverzfx/gothicquest/ArcholosQuestData.kt`, `Risen2QuestData.kt`, and `Risen3QuestData.kt`: migrate note declarations without changing their values or order.
- Modify `app/src/main/java/com/sliverzfx/gothicquest/GothicQuestAppV2.kt`: dispatch shared note lookup and keep rendering/insertion behavior.
- Create `app/src/main/java/com/sliverzfx/gothicquest/ChapterGuideNote.kt`: shared guide-note data contract.
- Create `app/src/main/java/com/sliverzfx/gothicquest/GothicGuideNotes.kt`: notes for Gothic 1, Gothic II Gold, New Balance, and Gothic 3.
- Modify `app/src/main/java/com/sliverzfx/gothicquest/AppRoute.kt`: add remake GameId routing, quest lookup, chapter lookup, section count, and labels.
- Modify `app/src/main/java/com/sliverzfx/gothicquest/GameGuidePalette.kt`: give the remake a palette consistent with the Gothic family.
- Modify `app/src/main/java/com/sliverzfx/gothicquest/GothicQuestAppV2.kt`: open the existing remake menu button into its distinct game hub and include remake note lookup.
- Create `app/src/main/java/com/sliverzfx/gothicquest/GothicRemakeQuestData.kt` and six chapter data files `GothicRemakeChapter1Data.kt` through `GothicRemakeChapter6Data.kt`: ordered journal quests and section access.
- Create `app/src/main/java/com/sliverzfx/gothicquest/GothicRemakeGuideNotes.kt`: remake-specific chapter guidance.
- Create `docs/sources/gothic-remake-quest-sources.md`: per-quest evidence ledger, uncertainty notes, and reconciliation notes.
- Create `app/src/test/java/com/sliverzfx/gothicquest/ChapterGuideNoteTest.kt` and `GothicRemakeQuestDataTest.kt`; extend `AppRouteTest.kt` and existing guide UI tests for route and note visibility.

## Task 1: Generalize chapter-guide notes without changing current behavior

**Files:**
- Create: `app/src/main/java/com/sliverzfx/gothicquest/ChapterGuideNote.kt`
- Modify: `app/src/main/java/com/sliverzfx/gothicquest/RisenQuestData.kt`
- Modify: `app/src/main/java/com/sliverzfx/gothicquest/ArcholosQuestData.kt`
- Modify: `app/src/main/java/com/sliverzfx/gothicquest/Risen2QuestData.kt`
- Modify: `app/src/main/java/com/sliverzfx/gothicquest/Risen3QuestData.kt`
- Modify: `app/src/main/java/com/sliverzfx/gothicquest/GothicQuestAppV2.kt`
- Test: `app/src/test/java/com/sliverzfx/gothicquest/ChapterGuideNoteTest.kt`

**Interfaces:**
- Produces: `internal data class ChapterGuideNote(val chapter: Int, val beforeQuestOrder: Int, val title: String, val paragraphs: List<String>)`.
- Produces: `internal fun GameId.chapterGuideNotes(chapter: Int): List<ChapterGuideNote>`, returning notes in authored insertion order for the selected game and chapter.
- Consumes: existing note data values and `GameId` note lookups for Risen, Risen II, Risen III, and Archolos.

- [ ] **Step 1: Write failing tests** for lookup ordering, empty chapter lookup, top-of-chapter placement value 1, and allowed after-last placement value `lastQuestOrder + 1`.
- [ ] **Step 2: Run** `./gradlew testDebugUnitTest --tests '*ChapterGuideNoteTest'`; confirm the new shared type and lookup do not exist.
- [ ] **Step 3: Implement the shared data class and lookup**, migrate the existing four games' note declarations, and replace the chapter-screen Risen-only dispatch with the shared lookup while preserving the current renderer output.
- [ ] **Step 4: Run** `./gradlew testDebugUnitTest --tests '*ChapterGuideNoteTest' --tests '*ArcholosQuestDataTest' --tests '*Risen*QuestDataTest'`; confirm all pass and existing note values/order are unchanged.
- [ ] **Step 5: Commit** as `refactor: generalize chapter guide notes`.

## Task 2: Add chapter notes to the existing Gothic guides

**Files:**
- Create: `app/src/main/java/com/sliverzfx/gothicquest/GothicGuideNotes.kt`
- Modify: `app/src/main/java/com/sliverzfx/gothicquest/GothicQuestAppV2.kt`
- Test: `app/src/test/java/com/sliverzfx/gothicquest/ChapterGuideNoteTest.kt`

**Interfaces:**
- Consumes: `GameId.chapterGuideNotes(chapter)` and existing quest ordering.
- Produces: note coverage for Gothic 1, Gothic II Gold, New Balance (chapters 1–6), and Gothic 3 (parts 1–7); Archolos remains on its already-existing lookup.

- [ ] **Step 1: Write failing coverage tests** asserting every existing Gothic chapter/part has an opening note, all insertion orders are between 1 and that section's last quest order plus one, and useful interstitial/closing notes are present where a consequential transition or route split warrants them.
- [ ] **Step 2: Run** `./gradlew testDebugUnitTest --tests '*ChapterGuideNoteTest'`; confirm Gothic coverage is missing.
- [ ] **Step 3: Author concise chapter notes** from existing guide quest order and verified decision points: preparation, route choices, missables, skill/trainer advice, combat/exploration tips, and transition checklists. Add them through the shared lookup without changing quest data.
- [ ] **Step 4: Run** `./gradlew testDebugUnitTest --tests '*ChapterGuideNoteTest' --tests '*Gothic3QuestDataTest'`; confirm coverage and valid positions.
- [ ] **Step 5: Commit** as `feat: add notes to Gothic chapter guides`.

## Task 3: Integrate Gothic Remake as an independent game

**Files:**
- Modify: `app/src/main/java/com/sliverzfx/gothicquest/AppRoute.kt`
- Modify: `app/src/main/java/com/sliverzfx/gothicquest/GameGuidePalette.kt`
- Modify: `app/src/main/java/com/sliverzfx/gothicquest/GothicQuestAppV2.kt`
- Create: `app/src/main/java/com/sliverzfx/gothicquest/GothicRemakeQuestData.kt`
- Create: `app/src/main/java/com/sliverzfx/gothicquest/GothicRemakeChapter1Data.kt` through `GothicRemakeChapter6Data.kt`
- Create: `app/src/main/java/com/sliverzfx/gothicquest/GothicRemakeGuideNotes.kt`
- Test: `app/src/test/java/com/sliverzfx/gothicquest/AppRouteTest.kt`
- Test: `app/src/test/java/com/sliverzfx/gothicquest/GothicRemakeQuestDataTest.kt`
- Test: existing `app/src/androidTest/java/com/sliverzfx/gothicquest/GothicReferenceScreenTest.kt` and `QuestGuidesLibraryTest.kt`

**Interfaces:**
- Produces: `GameId.GOTHIC_1_REMAKE` with unique persisted name `Gothic 1 Remake`, six chapter sections, its own `quests()` and `chapterQuests(chapter)`, palette, notes, and GameHub navigation.
- Produces: `GothicRemakeQuestData.chapter(number): List<Quest>` sorted by `playOrder`.
- Consumes: `Quest`, `ChapterGuideNote`, existing Gothic menu artwork, game hub, progress, search, favorites, and resume behavior.

- [ ] **Step 1: Add failing route and catalog tests** for persisted-name separation, six-chapter routing, empty/invalid chapter behavior, and uniqueness/required quest fields for the initial catalog skeleton.
- [ ] **Step 2: Run** `./gradlew testDebugUnitTest --tests '*AppRouteTest' --tests '*GothicRemakeQuestDataTest'`; confirm the new GameId and catalog are absent.
- [ ] **Step 3: Add the remake GameId to all exhaustive mappings** (quests, chapter quests, section count/label, palette, background/logo fallbacks, chapter notes, and home menu callback). Route the existing **GOTHIC 1 REMAKE** card button to `AppRoute.GameHub(GameId.GOTHIC_1_REMAKE)`.
- [ ] **Step 4: Implement six ordered chapter data sources** and remake note lookup using stable IDs prefixed `G1R-`; do not share Gothic 1 IDs or completion state.
- [ ] **Step 5: Run** `./gradlew testDebugUnitTest --tests '*AppRouteTest' --tests '*GothicRemakeQuestDataTest'`; confirm route, catalog shape, progress-key separation, and note placement.
- [ ] **Step 6: Run** `./gradlew compileDebugKotlin compileDebugAndroidTestKotlin`; confirm exhaustive routing and Compose UI compile.
- [ ] **Step 7: Commit** as `feat: add Gothic Remake game guide`.

## Task 4: Research and verify the remake quest catalog

**Files:**
- Modify: `app/src/main/java/com/sliverzfx/gothicquest/GothicRemakeChapter1Data.kt` through `GothicRemakeChapter6Data.kt`
- Create: `docs/sources/gothic-remake-quest-sources.md`
- Test: `app/src/test/java/com/sliverzfx/gothicquest/GothicRemakeQuestDataTest.kt`

**Interfaces:**
- Consumes: the six chapter data files and `GothicRemakeQuestData.quests`.
- Produces: a complete verified quest set using the `Quest` model fields; each quest ID has at least one quest-specific source-ledger mapping.

- [ ] **Step 1: Add failing catalog integrity tests** for unique IDs, nonblank required fields, valid chapter/order references, unique order within each chapter, six-chapter coverage, and a source-ledger ID match for every quest.
- [ ] **Step 2: Run** `./gradlew testDebugUnitTest --tests '*GothicRemakeQuestDataTest'`; confirm empty/incomplete catalog fails integrity assertions.
- [ ] **Step 3: Research each journal quest** against in-game journal evidence where available and quest-specific walkthrough sources; record source and uncertainty per quest in the ledger. Reconcile 88/89 community totals from actual entries instead of hard-coding either.
- [ ] **Step 4: Fill canonical journal quest titles, aliases, giver/trigger, location, prerequisites, walkthrough steps, rewards, consequences, and tags** in chapter order. Put general advice and checklist material in `GothicRemakeGuideNotes.kt`, not quest records.
- [ ] **Step 5: Run** `./gradlew testDebugUnitTest --tests '*GothicRemakeQuestDataTest' --tests '*AppRouteTest'`; confirm catalog, source-ledger, and six-section invariants pass.
- [ ] **Step 6: Commit** as `feat: verify Gothic Remake quest catalog`.

## Task 5: Verify app navigation and guide-note presentation

**Files:**
- Modify: `app/src/androidTest/java/com/sliverzfx/gothicquest/GothicReferenceScreenTest.kt`
- Modify: `app/src/androidTest/java/com/sliverzfx/gothicquest/QuestGuidesLibraryTest.kt`
- Modify: `app/src/test/java/com/sliverzfx/gothicquest/AppRouteTest.kt`

**Interfaces:**
- Consumes: all shared note lookups, five Gothic guide coverages, remake hub, and game ID.
- Produces: UI coverage for opening the remake from the Gothic 1 menu card and seeing a note in a chapter screen; search, favorites, completion, Continue/Recent, back navigation, and old saved-route behavior stay valid.

- [ ] **Step 1: Write failing UI assertions** for selecting the remake button, opening its distinct six-chapter hub, and showing chapter guidance in the selected chapter; add navigation checks for favorites, search, Continue/Recent, and return-to-menu.
- [ ] **Step 2: Run the focused emulator UI tests** for the affected screen and confirm they fail on the missing remake route or note rendering before implementation.
- [ ] **Step 3: Add only the UI hooks needed** for stable selection and note visibility assertions; preserve Gothic 1 routing and all existing game card behavior.
- [ ] **Step 4: Run the required verification:** `./gradlew testDebugUnitTest compileDebugAndroidTestKotlin assembleDebug`, then the repository's emulator UI-test workflow. Confirm GitHub Actions reports unit tests, UI-test compilation, debug APK, and emulator UI tests passing.
- [ ] **Step 5: Commit** as `test: cover Gothic Remake and chapter notes`.
