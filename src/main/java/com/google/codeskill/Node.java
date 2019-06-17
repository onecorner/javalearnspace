package com.google.codeskill;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
public class Node {
	private final Integer value;
	private Node next;

	public Node(int value) {
		this.value = value;
		this.next = null;
	}

	public String toString() {
		return this.value + "," + (this.next != null ? this.next.toString() : "");
	}

}
