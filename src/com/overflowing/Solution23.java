package com.overflowing;

import util.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution23 {
    public ListNode<Integer> mergeKLists(ListNode<Integer>[] lists) {
        PriorityQueue<Head23> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for(ListNode<Integer> list: lists) {
            if(list==null) continue;
            queue.add(new Head23(list.val, list));
        }
        if(queue.isEmpty()) return null;
        ListNode<Integer> head = queue.remove().list;
        ListNode<Integer> curr = head;
        while(!queue.isEmpty()) {
            if(curr.next != null) {
                queue.add(new Head23(curr.next.val, curr.next));
            }
            curr.next = queue.remove().list;
            curr = curr.next;
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
class Head23 {
    public int val;
    public ListNode<Integer> list;
    public Head23(int val, ListNode<Integer> list) {
        this.val = val;
        this.list = list;
    }
}

