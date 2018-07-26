package com.akshay.walmart;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Given an array arr[], find a Noble integer in it. 
 * An integer x is said to be Noble in arr[] if the number of integers greater than x are equal to x. 
 * If there are many Noble integers, return any of them. If there is no, then return -1.
 * 
 * 
 * 
   Input  : [7, 3, 16,10]
   Output : 3  
   Number of integers greater than 3
   is three.
   
   Input  : [-1, -9, -2, -78, 0]
   Output : 0
   Number of integers greater than 0
   is zero.

 * @author eshak01
 *
 */
public class FindNobleInteger {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      int[] inputData = { 7, 3, 9, 10,2,1,14,4 };
      int nobelNumber = findNobelBF(inputData);
      if (nobelNumber != -1) {
         System.out.println("Nobel number is : " + nobelNumber);
      } else {
         System.out.println("Nobel number is not possible.");
      }
   }

   static int findNobelBF(int data[]) {
      for (int i = 0; i < data.length; i++) {
         int count = 0;
         for (int j = 0; j < data.length; j++) {
            if (data[j] >= data[i] && i!=j) {
               count++;
            }
         }
         if (count == data[i])
            return data[i];
      }
      return -1;
   }
   
   static int findNobel(int data[]) {
      Arrays.sort(data);
      for (int i = 0; i < data.length; i++) {
         if (data[i] == data.length - 1 - i) {
            return data[i];
         }
      }
      return -1;
   }

}
