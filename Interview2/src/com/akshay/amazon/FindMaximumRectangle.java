package com.akshay.amazon;

/**
 * Find the maximum area rectangle possible in the histogram array. Data unit is consider as 1. And all values will be positive values.
 * 
 * @author eshak01
 *
 */
public class FindMaximumRectangle {

   public static void main(String[] args) {
      int[] data = { 6, 2, 5, 4, 5, 1, 6 };
      System.out.println(getMaxAreaBF(data));
   }

   static int getMaxAreaBF(int[] data) {
      int maxArea = 0;
      for (int i = 0; i < data.length; i++) {
         int minHeight = data[i];
         for (int j = i + 1; j < data.length; j++) {
            minHeight = min(minHeight, data[j]);
            maxArea = max(maxArea, minHeight * (j - i + 1));
         }
      }
      return maxArea;
   }

   static int max(int value1, int value2) {
      return (value1 > value2) ? value1 : value2;
   }

   static int min(int value1, int value2) {
      return (value1 < value2) ? value1 : value2;
   }
}
