package com.learn.test;

/*
* @since:       created in  2019-01-24 16:43
* @author:      htj
* @modified by:
* @version:     1.1
*/
public class Father {

	/*
	 * public static void say(Father fa){ System.out.println("father"); }
	 */

	public static void say(XiaoHua xiaoHua) {
		System.out.println("xiaohua");
	}

	public static void say(XiaoMing xiaoMing) {
		System.out.println("xiaoming---");
	}

	public static void main(String[] args) {
		XiaoHua fa = new XiaoHua();
		Father.say(fa);
	}
}

class XiaoMing extends Father {

}

class XiaoHua extends Father {
}
