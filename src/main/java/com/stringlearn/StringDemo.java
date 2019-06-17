package com.stringlearn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.lang.reflect.Method;

/*
* @since:       created in  2019-01-21 14:03
* @author:      htj
* @modified by:
* @version:     1
*/
public class StringDemo {

	public static void main(String[] args) {
		String str = "test";
		String str2 = "test";
		System.out.println(str == str2);

		Student stu = new Student(1, "test");
		Student stu1 = new Student(1, "test");
		System.out.println(stu == stu1);

		final Method[] declaredMethod = Student.class.getDeclaredMethods();
		for (Method method : declaredMethod) {
			System.out.println(method.getName());
		}
	}
}

@Data
@EqualsAndHashCode
@AllArgsConstructor
class Student {
	private int age;
	private String name;
}
