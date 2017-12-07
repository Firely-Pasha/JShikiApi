package net.pagala.JShikiApi.Core;

/**
 * Created by firely-pasha on 24.09.17.
 */

public class Timer {
    private static long start;

    public static void start() {
        start = System.currentTimeMillis();
        System.out.println("Timer started.");
    }

    public static void end() {
        System.out.println("Timer ended: " + (System.currentTimeMillis() - start));
    }
}
