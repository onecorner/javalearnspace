package com.google.codeskill;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by jhons on 2019/1/10.
 */
/*
 * @since: 2019-01-10 15:05
 * 
 * @author:htj 1->2->3->4->5->null 5->4->3->2->1->null 【5，【4，【3，【2，【1】】】】】
 *
 */
public class ReverseLinkedList {

	public Node reverseLinkedList(Node head) {
		if (head == null || head.getNext() == null) {
			return head;
		}
		Node newHead = reverseLinkedList(head.getNext());
		head.getNext().setNext(head);
		head.setNext(null);
		return newHead;
	}

	public static void main(String[] args) {
		ReverseLinkedList revertor = new ReverseLinkedList();
		System.out.println(revertor.reverseLinkedList(LinkedListCreator.createLinkedList(new ArrayList<>())));
		System.out.println(revertor.reverseLinkedList(LinkedListCreator.createLinkedList(Arrays.asList(1))));
		System.out
				.println(revertor.reverseLinkedList(LinkedListCreator.createLinkedList(Arrays.asList(1, 2, 3, 4, 5))));
	}
}
