package com.google.codeskill;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by jhons on 2019/1/12.
 */
/*
* @since: 2019-01-12 15:50
* @author:htj
*
*
*/
public class MyLinkedList implements Iterable<Integer> {

    Node head;

    Node tail;

    public MyLinkedList() {
        head = null;
        tail = null;
    }

    public void add(int value) {
        Node node = new Node(value);
        if (tail == null) {
            head = node;
        } else
            tail.setNext(node);
        tail = node;
    }

    class ListIterator implements Iterator<Integer> {
        Node currentNode;

        public ListIterator(Node head) {
            currentNode = head;
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public Integer next() {
            if (currentNode == null) {
                throw new NoSuchElementException("can not find such node");
            }
            int value = currentNode.getValue();
            currentNode = currentNode.getNext();
            return value;
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new ListIterator(head);
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        for (int i : list) {
            System.out.println(i);
        }
    }


}
