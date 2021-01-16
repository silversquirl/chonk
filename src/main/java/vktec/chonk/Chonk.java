package vktec.chonk;

import java.util.Comparator;
import net.minecraft.server.world.ChunkHolder;
import net.minecraft.server.world.ChunkTicketType;
import net.minecraft.server.world.ServerChunkManager;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.ChunkPos;

public class Chonk {
	// Lasts for 1gt exactly, one per chunk
	// The ticket time is 2gt here because the ticket isn't processed until one tick after it's created - it will last for exactly 1gt
	public static final ChunkTicketType<ChunkPos> TICKET = ChunkTicketType.create("chonk", Comparator.comparingLong(ChunkPos::toLong), 2);

	public static void loadTicking(ServerWorld world, ChunkPos pos) {
		ServerChunkManager manager = world.getChunkManager();
		manager.addTicket(Chonk.TICKET, pos, 1, pos);
	}

	public static void loadEntityTicking(ServerWorld world, ChunkPos pos) {
		ServerChunkManager manager = world.getChunkManager();
		manager.addTicket(Chonk.TICKET, pos, 2, pos);
	}
}
