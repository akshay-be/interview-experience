package com.akshay.amazon;

import java.util.HashMap;

/**
 * Write a program to find consecutive subset with sum zero in an unsorted array.
 * 
 * @author eshak01
 *
 */
public class FindSubsetWithSumZero {

   public static void main(String[] args) {
      // TODO Auto-generated method stub

      int[] data = { 2, 3, -1, 7 - 6, 8, 1, 3 };

      // isSubSetavilableBF(data);
      isSubSetavilable(data);

   }

   public static void isSubSetavilable(int[] data) {
      HashMap<Integer, Integer> hashData = new HashMap<Integer, Integer>();
      int sum = 0;
      for (int i = 0; i < data.length; i++) {
         sum = sum + data[i];
         if (sum == 0 || hashData.containsKey(sum)) {
            System.out.println("Subset with Sum zero possible.");
            return;
         } else {
            hashData.put(sum, i);
         }
      }
      System.out.println("Not possible.");
   }

   public static void isSubSetavilableBF(int[] data) {
      for (int i = 0; i < data.length; i++) {
         int sum = 0;
         for (int j = i; j < data.length; j++) {
            sum += data[j];
            if (sum == 0) {
               System.out.println("Subset with Sum zero is possible..");
               return;
            }

         }
      }
      System.out.println("Not possible.");
   }

}
