package org.springframework.core.annotation;

import org.junit.Test;
import org.springframework.stereotype.Component;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

import static org.junit.Assert.assertNotNull;

/**
 * @ClassName
 * @since: created in 2019-05-24 15:30
 * @author: htj
 * @modified by:
 * @version:
 **/
public class AnnotationUtilTest {
	@Test
	public void findMethodAnnotationOnLeaf() throws Exception {
		Method m = Leaf.class.getMethod("annotatedOnLeaf");
		Order order = m.getAnnotation(Order.class);
		System.out.println(order.value());
		assertNotNull(order);
		// 获取指定的注解类型
		assertNotNull(m.getAnnotation(Order.class));
		// 获取指定的方法
		// assertNotNull(getAnnotation(m, Order.class));
		// assertNotNull(findAnnotation(m, Order.class));
	}

	public interface AnnotatedInterface {

		@Order(0)
		void fromInterfaceImplementedByRoot();
	}

	@Retention(RetentionPolicy.RUNTIME)
	@Inherited
	@interface Transactional {

		boolean readOnly() default false;
	}

	@Component("meta2")
	@Transactional(readOnly = true)
	@Retention(RetentionPolicy.RUNTIME)
	@interface Meta2 {
	}

	@Meta2
	@Retention(RetentionPolicy.RUNTIME)
	@interface MetaMeta {
	}

	@Component("meta1")
	@Order
	@Retention(RetentionPolicy.RUNTIME)
	@Inherited
	@interface Meta1 {
	}

	public static class Root implements AnnotatedInterface {

		@Order(27)
		public void annotatedOnRoot() {
		}

		@Meta1
		public void metaAnnotatedOnRoot() {
		}

		public void overrideToAnnotate() {
		}

		@Order(27)
		public void overrideWithoutNewAnnotation() {
		}

		public void notAnnotated() {
		}

		@Override
		public void fromInterfaceImplementedByRoot() {
		}
	}

	public static class Leaf extends Root {

		@Order(25)
		public void annotatedOnLeaf() {
		}

		@Meta1
		public void metaAnnotatedOnLeaf() {
		}

		@MetaMeta
		public void metaMetaAnnotatedOnLeaf() {
		}

		@Override
		@Order(1)
		public void overrideToAnnotate() {
		}

		@Override
		public void overrideWithoutNewAnnotation() {
		}
	}
}
