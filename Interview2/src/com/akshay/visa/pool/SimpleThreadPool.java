package com.akshay.visa.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 
 * @author eshak01
 *
 */
public class SimpleThreadPool {

   BlockingQueue<Runnable> threadQueue;
   List<SimpleThread> threads;
   BlockingQueue<Runnable> waitingQueue;
   int poolSize;

   public SimpleThreadPool(int poolSize) {
      if (poolSize <= 0) {
         throw new IllegalArgumentException("Pool size can'b be : " + poolSize);
      }
      this.poolSize = poolSize;
      threadQueue = new ArrayBlockingQueue<>(poolSize);
      waitingQueue = new ArrayBlockingQueue<>(poolSize * 10);
      threads = new ArrayList<SimpleThread>();
      for (int i = 0; i < poolSize; i++) {
         SimpleThread simpleThread = new SimpleThread(threadQueue);
         threads.add(simpleThread);
         simpleThread.start();
         new WaitingQueueThreadProcessor(threadQueue, waitingQueue).start();
      }
   }

   public void submit(Runnable runnable) {
      try {
         if (threadQueue.size() == poolSize) {
            waitingQueue.put(runnable);
         } else {
            threadQueue.put(runnable);
         }
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }
}

class WaitingQueueThreadProcessor extends Thread {
   BlockingQueue<Runnable> threadQueue;
   BlockingQueue<Runnable> waitingQueue;

   public WaitingQueueThreadProcessor(BlockingQueue<Runnable> threadQueue, BlockingQueue<Runnable> waitingQueue) {
      this.threadQueue = threadQueue;
      this.waitingQueue = waitingQueue;
   }

   @Override
   public void run() {
      while (true) {
         try {
            Runnable runnable = waitingQueue.take();
            threadQueue.put(runnable);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }

      }
   }

}
