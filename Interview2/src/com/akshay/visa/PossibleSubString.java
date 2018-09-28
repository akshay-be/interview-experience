package com.akshay.visa;

/**
 * 
 * @author eshak01
 *
 */
public class PossibleSubString {

   public static void main(String[] args) {
      //printSubString("akshaybe");
      //printSubStringRecursive("akshaybe");
      printSubStringOnLength("akshaybe");

   }

   public static void printSubStringOnLength(String data) {
      for (int end = data.length(); end >0; end--) {
         for (int start = 0; start <= data.length()-end; start++) {
            System.out.println(data.substring(start, start+end));
         }
      }
   }
   
   
   public static void printSubString(String data) {
      for (int i = 0; i < data.length(); i++) {
         for (int j = data.length(); j > i; j--) {
            System.out.println(data.substring(i, j));
         }
      }
   }
   
   public static void printSubStringRecursive(String data) {
      if(data.isEmpty()) {
         return ;
      }
      if(data.length()==1) {
         System.out.println(data);
         return;
      }
      String first = data.substring(0, data.length()-1);
      String second = data.substring(1,data.length());
      System.out.println(first);
      System.out.println(second);
      printSubStringRecursive(first);
      printSubStringRecursive(second);
   }

}
