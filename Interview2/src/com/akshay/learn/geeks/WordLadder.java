package com.akshay.learn.geeks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Word Ladder (Length of shortest chain to reach a target word) Given a dictionary, and two words ‘start’ and ‘target’ (both of same length). Find length of
 * the smallest chain from ‘start’ to ‘target’ if it exists, such that adjacent words in the chain only differ by one character and each word in the chain is a
 * valid word i.e., it exists in the dictionary. It may be assumed that the ‘target’ word exists in dictionary and length of all dictionary words is same.
 * 
 * 
 *  Input:  Dictionary = {POON, PLEE, SAME, POIE, PLEA, PLIE, POIN}
 *            start = TOON
 *            target = PLEA
 *  Output: 7
 *  Explanation: TOON - POON - POIN - POIE - PLIE - PLEE - PLEA
 *
 * @author eshak01
 * Solution is not complete still.
 *
 */
public class WordLadder {

   public static void main(String[] args) {
      List<String> dictionary = new ArrayList<String>();
      dictionary.add("POON");
      dictionary.add("PLEE");
      dictionary.add("SAME");
      dictionary.add("POIE");
      dictionary.add("PLEA");
      dictionary.add("PLIE");
      dictionary.add("POIN");

      int length = shortestChainLen(dictionary, "TOON", "PLEA");
      // System.out.println(" Length : " + leangth);

      System.out.println(findMatchWithOneChange("TOON", "POON"));
   }

   private static int shortestChainLen(List<String> dictionary, String start, String target) {
      Node<String> root = new Node<>("start");
      Map<String, Boolean> visited = new HashMap<>();
      Queue<String> queue = new LinkedList<>();
      queue.add(start);
      while (!queue.isEmpty()) {
         String word = queue.poll();
         List<String> partialMatchs = getPartialMatchs(word, dictionary);
         for (String next : partialMatchs) {
            if (!visited.containsKey(next)) {
               queue.add(next);
               Node<String> node = root.addChild(new Node<String>(next));
            }   
         }
      }

      return 0;
   }

   private static List<String> getPartialMatchs(String word, List<String> dictionary) {
      List<String> data = new ArrayList<String>();
      for (String entry : dictionary) {
         if (findMatchWithOneChange(word, entry)) {
            data.add(entry);
         }
      }
      return data;
   }

   private static boolean findMatchWithOneChange(String first, String second) {
      int numOfDiff = 0;
      int i = 0;
      while (i < first.length()) {
         if (first.charAt(i) != second.charAt(i)) {
            numOfDiff++;
         }
         if (numOfDiff == 2) {
            break;
         }
         i++;
      }
      if (numOfDiff == 1)
         return true;
      else
         return false;
   }
}


class Node<T> {

   private T data = null;

   private List<Node<T>> children = new ArrayList<>();

   private Node<T> parent = null;

   public Node(T data) {
      this.data = data;
   }

   public Node<T> addChild(Node<T> child) {
      child.setParent(this);
      this.children.add(child);
      return child;
   }

   public void addChildren(List<Node<T>> children) {
      children.forEach(each -> each.setParent(this));
      this.children.addAll(children);
   }

   public List<Node<T>> getChildren() {
      return children;
   }

   public T getData() {
      return data;
   }

   public void setData(T data) {
      this.data = data;
   }

   private void setParent(Node<T> parent) {
      this.parent = parent;
   }

   public Node<T> getParent() {
      return parent;
   }
}

