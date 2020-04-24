# chonk

> vktec 27/02/2020
>
> Random idea for how remote chunk loading could be implemented nicely: block updates into a border chunk loads it lazily for 8gt (makes permanent lazy loading possible, also allows instant wires etc to travel through unloaded chunks without breaking), triggering a dropper that's not facing into an inventory or a dispenser in a lazy chunk loads that chunk as entity processing for 8gt (allows remote loading of portal permaloaders, remote loaded entity processing chunks for pearl cannons, permaloaded entity processing chunks in the end, etc.)
