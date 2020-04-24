package vktec.chonk.mixin;

import net.minecraft.server.world.ServerChunkManager;
import net.minecraft.world.chunk.Chunk;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import vktec.chonk.Chonk;

@Mixin(ServerChunkManager.class)
public abstract class ServerChunkManagerMixin {
	@Shadow private @Final Thread serverThread;

	@Inject(method = "getChunk(IILnet/minecraft/world/chunk/ChunkStatus;Z)Lnet/minecraft/world/chunk/Chunk;", at = @At("RETURN"))
	private void loadChunkOnAccess(CallbackInfoReturnable<Chunk> ci) {
		if (Thread.currentThread() != this.serverThread) return;

		Chunk chonk = ci.getReturnValue();
		if (chonk != null) Chonk.loadTicking((ServerChunkManager)(Object)this, chonk.getPos());
	}
}
