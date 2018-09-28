package com.akshay.visa.pool;

/**
 * 
 * @author eshak01
 *
 */
public class TestThreadPool {

   public static void main(String[] args) {
      SimpleThreadPool pool = new SimpleThreadPool(10);
      
      for(int i=0;i<100;i++) {
         pool.submit(new MySampleRunnable());
      }
   }
}

class MySampleRunnable implements Runnable {
   
   
   @Override 
   public void run() {
      System.out.println(""+Thread.currentThread().getName());
   }
}

