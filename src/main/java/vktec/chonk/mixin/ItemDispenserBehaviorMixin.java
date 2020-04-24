package vktec.chonk.mixin;

import net.minecraft.block.dispenser.ItemDispenserBehavior;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.ChunkPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import vktec.chonk.Chonk;

@Mixin(ItemDispenserBehavior.class)
public abstract class ItemDispenserBehaviorMixin {
	@Inject(method = "dispense", at = @At("HEAD"))
	private void loadChunkOnDispense(BlockPointer block, ItemStack item, CallbackInfoReturnable ci) {
		World world = block.getWorld();
		if (world.isClient()) return;
		Chonk.loadEntityTicking((ServerWorld)world, new ChunkPos(block.getBlockPos()));
	}
}
