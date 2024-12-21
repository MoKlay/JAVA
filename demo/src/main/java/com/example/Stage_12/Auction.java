package com.example.Stage_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;

/*
 * Разработать многопоточное приложение. Использовать возможности, предоставляемые пакетом java.util.concurrent. Не
 * использовать слово synchronized.
 * Все сущности, желающие получить доступ к ресурсу, должны быть потоками.
 * 
 * Аукцион. На торги выставляется несколько лотов. Участники аукциона делают заявки. 
 * Заявку можно корректировать в сторону увеличения несколько раз за торги одного лота. 
 * Аукцион определяет победителя и переходит
 * к следующему лоту. 
 * Участник, не заплативший за лот в заданный промежуток времени, отстраняется на несколько лотов от торгов
 */

public class Auction {
  private final ConcurrentHashMap<Integer, Lot> lots;
  private final ExecutorService executor;
  private static final int maxBidIncrementTime = 1000; // 1 секунда

  public Auction(int numLots) {
    lots = new ConcurrentHashMap<>();
    for (int i = 0; i < numLots; i++) {
      lots.put(i + 1, new Lot(i + 1)); // Лоты нумеруются с 1
    }
    executor = Executors.newFixedThreadPool(20);
  }

  public void start() {
    for (int lotId : lots.keySet()) {
      executor.execute(lots.get(lotId)::runAuction); // Более компактный вызов
    }
  }

  public void shutdown() {
    executor.shutdown();
    try {
      executor.awaitTermination(5, TimeUnit.SECONDS); // Подождать завершения потоков
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }

  public void bidOnLot(Bidder bidder, int lotId) {
    executor.execute(() -> lots.get(lotId).placeBid(bidder));
  }

  public static void main(String[] args) {
    Auction auction = new Auction(5);
    auction.start();

    // Имитация участников
    List<Bidder> bidders = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      bidders.add(new Bidder(i + 1));
    }

    for (int i = 0; i < 20; i++) {
      int randomLot = (int) (Math.random() * 5) + 1; // Случайный лот
      int randomBidder = (int) (Math.random() * 10); // Случайный участник
      auction.bidOnLot(bidders.get(randomBidder), randomLot);
      try {
        Thread.sleep((long) (Math.random() * 500)); // Случайная задержка
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }

    auction.shutdown();
    System.out.println("Аукцион завершен.");
  }

  static class Lot {
    private final int id;
    private final AtomicReference<Bidder> winner = new AtomicReference<>();
    private final AtomicInteger currentBid = new AtomicInteger(0);
    private final Map<Bidder, Integer> bids = new ConcurrentHashMap<>();
    private final ReentrantLock lock = new ReentrantLock();

    public Lot(int id) {
      this.id = id;
    }

    public void placeBid(Bidder bidder) {
      lock.lock();
      try {
        int bid = bids.getOrDefault(bidder, 0) + 10; // Увеличение ставки на 10
        if (bid > currentBid.get()) {
          bids.put(bidder, bid);
          currentBid.set(bid);
          winner.set(bidder);
          System.out.println("Лот " + id + ": Новая ставка от участника " + bidder.id + " - " + bid);
        } else {
          System.out.println("Лот " + id + ": Ставка от участника " + bidder.id + " слишком низкая.");
        }
      } finally {
        lock.unlock();
      }
    }

    public void runAuction() {
      try {
        System.out.println("Аукцион для лота " + id + " начался.");
        Thread.sleep(maxBidIncrementTime); // Ждем время на увеличение ставок
        if (winner.get() != null) {
          System.out
              .println("Лот " + id + ": Победитель - участник " + winner.get().id + ", ставка: " + currentBid.get());
          // Здесь можно добавить логику оплаты
        } else {
          System.out.println("Лот " + id + ": Никто не сделал ставку.");
        }
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }
  }

  static class Bidder {
    private final int id;

    public Bidder(int id) {
      this.id = id;
    }

    @Override
    public String toString() {
      return "Bidder{" +
          "id=" + id +
          '}';
    }
  }
}
