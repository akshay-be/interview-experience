package com.akshay.learn.array;

import java.util.Stack;

/**
 * Given an array, print the Next Greater Element (NGE) for every element. The Next greater Element for an element x is the first greater element on the right
 * side of x in array. Elements for which no greater element exist, consider next greater element as -1.
 * 
 * 
 * a) For any array, rightmost element always has next greater element as -1. 
 * b) For an array which is sorted in decreasing order, all elements have next greater element as -1.
 * 
 * @author eshak01
 *
 */
public class NextGreaterElement {

   public static void main(String[] args) {
      int[] data = { 4, 5, 2, 25 };
      
      printNextGreaterElementBF(data);
      printNextGreaterElement(data);
   }

   private static void printNextGreaterElementBF(int[] data) {
      System.out.println("This solution is using brute force method.. O(n^2)");
      for (int i = 0; i < data.length; i++) {
         for(int j=i+1;j<data.length;j++) {
            if(data[j] > data[i]) {
               System.out.println(data[i]+" NextGreaterElement is : "+data[j]);
               break;
            }
         }
      }
      System.out.println(data[data.length-1]+" NextGreaterElement is : "+-1);
   }
   
   
   private static void printNextGreaterElement(int[] data) {
      System.out.println("This solution is using Stack O(n)");
      Stack<Integer> stack = new Stack<Integer>();
      stack.push(data[0]);
      for (int i = 0; i < data.length; i++) {
         int next = data[i];
         //if (!stack.isEmpty()) {
            int preivous = stack.pop();
            while (preivous < next) {
               System.out.println(preivous + " NextGreaterElement is : " + next);
               if (stack.isEmpty())
                  break;
               preivous = stack.pop();
            }
            if (preivous > next) {
               stack.push(preivous);
            }
        // }
         stack.push(next);
      }
      for (Integer integer : stack) {
         System.out.println(integer + " NextGreaterElement is : " + -1);
      }

   }
}
