package vktec.chonk;

import java.util.Comparator;
import net.minecraft.server.world.ChunkHolder;
import net.minecraft.server.world.ChunkTicketType;
import net.minecraft.server.world.ServerChunkManager;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.ChunkPos;

public class Chonk {
	// Lasts for 8gt, one per chunk
	public static final ChunkTicketType<ChunkPos> TICKET = ChunkTicketType.create("chonk", Comparator.comparingLong(ChunkPos::toLong), 8);

	public static void loadTicking(ServerChunkManager manager, ChunkPos pos) {
		load(manager, pos, 1);
	}

	public static void loadEntityTicking(ServerWorld world, ChunkPos pos) {
		load(world.getChunkManager(), pos, 2);
	}

	private static void load(ServerChunkManager manager, ChunkPos pos, int level) {
		manager.addTicket(Chonk.TICKET, pos, level, pos);

		ChunkHolder holder = manager.getChunkHolder(pos.toLong());
		if (holder.getLevel() > 33 - level) manager.tick();
	}
}
