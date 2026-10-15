# Questbound consistency verification — 15 October 2026

## Scope and result

The nine-game data/navigation audit and 78 local JVM regressions pass after the
fixes below. All 49 chapters/parts have opening guidance. Each game has populated
CODES and TIPS cards using the shared searchable reference screen.

This verifies structural consistency of the included catalogue, not exhaustive
coverage of every internal game quest, numeric reward, patch or branching save.

| Game | Sections | Guide records | Codes/items cards | Tips |
| --- | ---: | ---: | ---: | ---: |
| Gothic | 6 | 47 | 324 | 16 |
| Gothic 1 Remake | 6 | 88 | 326 | 9 |
| Gothic II Gold | 6 | 202 | 1100 | 26 |
| New Balance | 6 | 619 | 1022 | 15 |
| Gothic 3 | 7 | 426 | 1961 | 15 |
| Risen | 4 | 283 | 834 | 21 |
| Risen 2 | 4 | 324 | 580 | 18 |
| Risen 3 | 4 | 241 | 63 | 19 |
| Archolos | 6 | 192 | 5590 | 31 |

All games have unique quest IDs and nonblank title, giver, location,
prerequisites, summary, reward description and walkthrough lists. Counts include
reference-only records and mutually exclusive paths; they are not per-save
completion requirements. Nonblank fields are not proof of factual accuracy.

## Issues found and corrected

- Two Remake UI tests matched both a search field/result or both back buttons.
  The corrected tests select the result's unique quest ID and the top back button.
  The failing device run had 61 passes out of 63 on API 35, Pixel 6.
- Four original Gothic quests had empty reward fields: G1-C3-01, G1-C5-01,
  G1-C5-02 and G1-C6-01. Added outcome descriptions; no guessed numeric XP.
- Risen 3 legacy references R3-C2-092 and R3-C2-152 were labeled in the data but
  treated as trackable quests. They now use the shared reference classification,
  disappear from completion denominators and retain their saved IDs/favorites.
  Chapter/all-quest headers now distinguish references for this game too.

Original Gothic outcome references (not Remake):
- https://strategywiki.org/wiki/Gothic/Orc_Cemetery
- https://strategywiki.org/wiki/Gothic/Way_into_the_Sleeper%27s_Temple
- https://strategywiki.org/wiki/Gothic/The_Magic_Sword_URIZIEL
- https://strategywiki.org/wiki/Gothic/Game_mechanics

## Remaining release gates

- Check the new commit's Android CI run after these changes. Previous green
  compilation/unit-test/APK results do not certify a newer commit.
- Latest full device test run must pass; a new UI regression checks the Risen 3
  reference detail does not offer quest-completion controls.
- Latest phone and tablet visual checks, including large text and the Remake
  logo/banner, have not been performed on physical hardware in this audit.
- The existing workflow builds a debug/preview APK. It does not certify a signed
  Google Play release bundle or the store account/release configuration.

No whole-app release sign-off is claimed while these gates remain open.
