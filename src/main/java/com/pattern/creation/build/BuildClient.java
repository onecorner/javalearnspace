package com.pattern.creation.build;

/**
 * @fomatter:off
 * 目的：将一个复杂的构建与其表示相分离，使得同样的构建过程可以创建不同的表示
 * 肯德基案例：汉堡、可乐、薯条等等不会改变，但是套餐却会经常变化
 *
 * 将变与不变相互分离
 *
 * 角色：
 *     建造者：返回实例
 *     导演：管理建造出来的依赖关系。
 * 和工程模式的关系，依赖于工厂模式来生成实例
 * @formatter:on
 * @author jhons
 * @since 2019/5/31 16:12
 */
public class BuildClient {
    public static void main(String[] args) {
        ManBuilder manBuilder = new ManBuilder();
        manBuilder.buildBody();
        manBuilder.buildFoot();
        manBuilder.buildHead();

        Person person = new PersonDirector().constructPerson(manBuilder);

        System.out.println(person);
    }
}
