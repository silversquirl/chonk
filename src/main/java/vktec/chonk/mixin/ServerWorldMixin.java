package vktec.chonk.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.ChunkPos;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import vktec.chonk.Chonk;

@Mixin(ServerWorld.class)
public abstract class ServerWorldMixin {
	@Inject(method = "addEntity", at = @At("HEAD"))
	private void loadChunkOnEntityCreation(Entity entity, CallbackInfoReturnable ci) {
		Chonk.loadEntityTicking((ServerWorld)(Object)this, new ChunkPos(entity.getBlockPos()));
	}
}
