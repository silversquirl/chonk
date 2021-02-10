# chonk

[![Discord](https://img.shields.io/badge/chat%20on-discord-7289DA?logo=discord)](https://discord.gg/zEnfMVJqe6)

A server-side mod that adds simple, flexible remote chunk loading mechanics to Minecraft 1.16+.

## Mechanics

For an overview of vanilla chunk loading mechanics in 1.14+, see [this page](https://gist.github.com/Drovolon/24bfaae00d57e7a8ca64b792e14fa7c6).

- Block updates crossing chunk borders load the destination chunk as `TICKING` (lazy) for 1 gametick
- Dispensing an item into the world loads the chunk the dropper or dispenser is in as `ENTITY_TICKING` for 1 gametick
- An entity changing dimension loads the destination chunk as `TICKING` (lazy) for 1 gametick (nether portals will load for 299gt as normal)
