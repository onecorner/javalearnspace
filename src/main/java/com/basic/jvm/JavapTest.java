package com.basic.jvm;

/**
 * @fomatter:off
 * 栈顶:操作数栈的栈顶
 * 能创建的线程数的具体计算 （最大地址空间（MaxProcessMemory） - JVM堆内存 - ReservedOsMemory（系统保留内存）） / (ThreadStackSize) = Number of threads
 * ThreadStackSize：通过 XX:ThreadStackSize 设置 是-Xss的别名,建议使用-Xss，因为XX:ThreadStackSize 不稳定
 * 一个进程所能分配的最大内存是多少？
 * 一般来说，一个java进程在一个4G内存32位操作系统上面所能占有的最大内存不超过2G，
 * 32位CPU本身只支持2的32次方也就是4G内存的大小，不过一些j较新的CPU也支持更大的内存，
 * 内存和操作系统一样，区分32位和64位的。
 * JMM：
 *   主内存：可以简单的理解位对内存
 *   工作内存：可以简单的理解为虚拟机栈
 * 
 * @formatter:on
 * @author htj
 * @since 2019/6/5 15:57
 */
public class JavapTest {

    public void method1(int a) {
        // iload_1 将第二个int型本地变量推送至操作数栈顶
        // istore_2 将int类型值存入局部变量2
        int s = a;
        // iload_2
        // iinc 将指定int型变量增加指定值
        // 将栈顶的值保存到slot_2，即对应代码应该是变量x
        int x = s++;
    }

    public int calc() {
        // bipush 100 首先局部变量表中第0位索引的Slot默认是用于传递方法所属对象实例的引用,并且将100推入操作数栈。
        // istore_1 然后将操作数栈的值出栈，并存储在局部变量表中。
        int a = 100;
        int b = 200;
        int c = 300;
        // iload_a iload_2 是将数据从本地变量表当中加载到操作数栈
        // iadd 是将操作数头顶的两个栈顶元素出栈，做整型加法，然后把结果重新入栈，所以现在操作数中的数据是300
        return (a + b) * c; // ireturn从当前方法返回int
    }

    public void method2() {}

    public static void main(String[] args) {
        // dup 复制栈顶数值并将复制值压入栈顶
        // invokespecial 根据编译时类型来调用实例方法
        // astore_1 将引用类型或returnAddress类型值存入局部变量1
        JavapTest j = new JavapTest();
        // aload_1 从局部变量1中装载引用类型值
        // iconst_1 将int类型常量1压入栈
        // invokestatic 调用类（静态）方法
        // 调度对象的实便方法：invokevirtual
        // bipush 11 将单字节的常量值(-128~127)推送至栈顶
        j.method1(11);
    }

}
