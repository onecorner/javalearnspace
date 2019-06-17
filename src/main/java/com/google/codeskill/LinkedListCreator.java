package com.google.codeskill;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinkedListCreator {

	/**
	 * @Description: create a linked list
	 * @Author: htj
	 * @date : 2019/1/10 14:37
	 * @param data
	 *            :
	 * @return : Node
	 */
	public static Node createLinkedList(List<Integer> data) {
		if (data.isEmpty()) {
			return null;
		}
		Node firstNode = new Node(data.get(0));
		Node next = createLinkedList(data.subList(1, data.size()));
		firstNode.setNext(next);
		return firstNode;
	}

	public static void main(String[] args) {
		LinkedListCreator creator = new LinkedListCreator();
		System.out.println(LinkedListCreator.createLinkedList(new ArrayList<>()));
		System.out.println(LinkedListCreator.createLinkedList(Arrays.asList(1)));
		System.out.println(LinkedListCreator.createLinkedList(Arrays.asList(1, 2, 3, 4, 5)));
	}
}
