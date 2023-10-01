package com.anma.java.core.concur;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompFutuMiscTest {
    @Test
    void asyncCalcTest() {
        var startMoment = LocalDateTime.now();

        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(() -> {
            System.out.println(">> completableFuture2 :: supply async");
            calc(100_000);
            return "Completed";
        });
        try {
            String result2 = completableFuture2.get();
            System.out.println(result2);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        var end = Duration.between(startMoment, LocalDateTime.now()).toMillis();
        System.out.println(" >>> " + end);
    }

    @Test
    void simpleCalcTest() {
        var startMoment = LocalDateTime.now();
        calc(100_000);
        var end = Duration.between(startMoment, LocalDateTime.now()).toMillis();
        System.out.println(" >>> " + end);
    }



    private static void calc(long times) {
        for (int i = 0; i < times; i++) {
            long a = 82234243142431432L;
            var rand = new Random().nextInt(1000000, 1000000000);
            long[] arr = {rand * 3L, rand * 2L, rand, rand, rand, rand, rand, rand, rand, rand};
            for (int j = 0; j < arr.length; j++) {
                a = arr[j] + a / 212339 - (123134 + 980980665) + (123123123 + 31213123)
                        / 3 - 23213213 / 3 * 20 / 4 / 2 * 2 / 20 * 20;
                a = arr[j] + a / 343339 - (123134 + 980980665) + (123123123 + 31213123)
                        / 3 - 21213213 / 3 * 20 / 2 / 2 * 3 / 18 * 20;
                a = arr[j] + a / 212339 - (123134 + 980980665) + (123123123 + 31213123)
                        / 3 - 21321213 / 3 * 20 / 2 / 3 * 2 / 20 * 10;
                long b = a / 12345 + 1034324 - 123123 * 2 / 45 / 2 * 40 * 2 / 12 / 2 * 10;
                long c = a - b;
                System.out.println(c);
            }
        }
    }
}
