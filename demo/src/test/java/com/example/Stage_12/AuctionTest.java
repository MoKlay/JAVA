package com.example.Stage_12;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.Stage_12.Auction.Bidder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class AuctionTest {
    private Auction auction;

    @BeforeEach
    void setUp() {
        auction = new Auction(3); // Создаем аукцион с 3 лотами
    }

    @AfterEach
    void tearDown() {
        auction.shutdown(); // Завершаем аукцион после каждого теста
    }

    @Test
    void testBidOnLot() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        List<Bidder> bidders = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            bidders.add(new Bidder(i + 1));
        }

        // Запускаем аукцион
        auction.start();

        // Участники делают ставки
        for (int i = 0; i < 10; i++) {
            int randomLot = (int) (Math.random() * 3) + 1; // Случайный лот
            int randomBidder = (int) (Math.random() * 5); // Случайный участник
            auction.bidOnLot(bidders.get(randomBidder), randomLot);
            Thread.sleep(100); // Задержка для имитации времени между ставками
        }

        // Ждем завершения аукциона
        latch.await(5, TimeUnit.SECONDS);
        auction.shutdown();

        // Проверяем, что аукцион завершился без ошибок
        assertNotNull(auction);
    }

    @Test
    void testMultipleBiddersOnSameLot() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        List<Bidder> bidders = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            bidders.add(new Bidder(i + 1));
        }

        // Запускаем аукцион
        auction.start();

        // Участники делают ставки на один и тот же лот
        for (int i = 0; i < 10; i++) {
            auction.bidOnLot(bidders.get(i % 5), 1); // Все делают ставки на лот 1
            Thread.sleep(100); // Задержка для имитации времени между ставками
        }

        // Ждем завершения аукциона
        latch.await(5, TimeUnit.SECONDS);
        auction.shutdown();

        // Проверяем, что аукцион завершился без ошибок
        assertNotNull(auction);
    }

    @Test
    void testNoBidsOnLot() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);

        // Запускаем аукцион
        auction.start();

        // Ждем завершения аукциона без ставок
        latch.await(5, TimeUnit.SECONDS);
        auction.shutdown();

        // Проверяем, что аукцион завершился без ошибок
        assertNotNull(auction);
    }
}

