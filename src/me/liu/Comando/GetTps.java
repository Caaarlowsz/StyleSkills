package me.liu.Comando;

import org.bukkit.event.Listener;

public class GetTps implements Runnable, Listener {
	public static int TICK_COUNT;
	public static long[] TICKS;
	public static long LAST_TICK;

	static {
		GetTps.TICK_COUNT = 0;
		GetTps.TICKS = new long[600];
		GetTps.LAST_TICK = 0L;
	}

	public static double getTPS() {
		return getTPS(100);
	}

	public static double getTPS(final int ticks) {
		if (GetTps.TICK_COUNT < ticks) {
			return 20.0;
		}
		final int target = (GetTps.TICK_COUNT - 1 - ticks) % GetTps.TICKS.length;
		final long elapsed = System.currentTimeMillis() - GetTps.TICKS[target];
		return ticks / (elapsed / 1000.0);
	}

	public static long getElapsed(final int tickID) {
		final long time = GetTps.TICKS[tickID % GetTps.TICKS.length];
		return System.currentTimeMillis() - time;
	}

	@Override
	public void run() {
		GetTps.TICKS[GetTps.TICK_COUNT % GetTps.TICKS.length] = System.currentTimeMillis();
		++GetTps.TICK_COUNT;
	}
}
