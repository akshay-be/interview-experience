package com.akshay.visa.pool;

import java.util.concurrent.BlockingQueue;

/**
 * 
 * @author eshak01
 *
 */
public class SimpleThread extends Thread {

   static int count = 0;
   private BlockingQueue<Runnable> threads;

   public SimpleThread(BlockingQueue<Runnable> threads) {
      super("MyThread-" + count);
      this.threads = threads;
      count++;
   }

   @Override
   public void run() {
      while (true) {
         try {
            Runnable runnable = threads.take();
            runnable.run();
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }
}
