# Gothic Remake and New Balance Game Tools

Checked 15 October 2026. Descriptions were written for Questbound; no mod scripts,
images, walkthrough prose or source assets are bundled. Numeric statistics, item
names, instance identifiers and command syntax are reference facts.

## Gothic 1 Remake

- https://www.nexusmods.com/gothic1remake/mods/216
- https://www.nexusmods.com/gothic1remake/mods/216?tab=docs
  - alexz006, G1R Console Tools 1.9.1 (12 July 2026), requiring UE4SS.
  - These are optional PC mod commands, not a retail/native Marvin console.
  - Item IDs are only included where the author documents them. Icon filenames
    from equipment databases are never treated as spawn identifiers.
  - Quest/chapter/guild flag changes do not execute normal story logic.
- https://www.gothic.tools/items
  - Factual equipment snapshot: 280 weapon, armor, jewelry, rune, scroll and
    ammunition entries with available numeric facts. Null fields are omitted;
    this is not advertised as every item or a verified acquisition guide.
- https://www.gothic.tools/weapons
- https://www.gothic.tools/armor
- https://www.gothic.tools/trainers
- https://www.gothic.tools/traders
- https://www.gothic.tools/recipes
- https://www.gothic.tools/guides/lockpicking-and-chest-solutions
- https://www.pcgamer.com/games/rpg/gothic-1-remake-how-to-lockpick-location/

## New Balance

- https://www.sefaris.eu/new-balance
  - Distribution overview, modified systems and collecting wisp.
- https://www.myrtana.net/en/new-balance/wiki/kody-a-marvin
  - Community instance table with a November 2025 translation note.
  - 649 distinct case-insensitive IDs after excluding entries marked removed,
    unavailable, lethal, test-only, NPC-only consumables or unknown names.
  - NPC insertion creates a new instance, not a repair of existing quest state.
- https://www.myrtana.net/en/new-balance/wiki/zbrane-sila
- https://www.myrtana.net/en/new-balance/wiki/zbrane-obratnost
- https://www.myrtana.net/en/new-balance/wiki/luky
- https://www.myrtana.net/en/new-balance/wiki/kuse
- https://www.myrtana.net/en/new-balance/wiki/zbroje
- https://www.myrtana.net/en/new-balance/wiki/stity
  - 369 equipment references. Values are from New Balance tables, not vanilla
    Gothic II. Source section dates are retained where supplied (armor March
    2026; shields October 2026). Requirements/bonuses may depend on settings.
  - Three duplicate names with contradictory statistics (Steel Spear, Beech Bow,
    Forefather Cleaver) are excluded until variants can be identified.
  - Equipment names are not used to invent insertion commands.
- https://www.myrtana.net/en/new-balance/wiki/levne-dovednosti
- https://www.myrtana.net/en/new-balance/wiki/plan-buildu
- https://www.myrtana.net/en/new-balance/wiki/asnc-rozdeleni-statu
- https://www.myrtana.net/en/new-balance/wiki/dovednosti-prehled
- https://www.reddit.com/r/worldofgothic/comments/1362wya
  - Pause/Break activation is explicitly labeled community-reported and
    build-dependent. Do not claim it works on every New Balance installation.

## Integration and verification

Both games use the shared reference screen, body/command search, categories,
clipboard action and game-prefixed favorites. They are reachable from Game Tools
and game-hub CODES/TIPS tabs. Legacy ITEMS routes resolve the combined cards.
`RemainingGameToolsTest` guards against any game returning an empty codes/tips
section, checks reference integrity and favorite isolation, and checks that
Remake commands are not classic Gothic Marvin commands.
