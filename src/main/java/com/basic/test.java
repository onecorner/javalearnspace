package com.basic;

/**
 * @author jhons
 * @since 2019/5/30 12:01
 */
public class test {
    public static void main(String[] args) {
        String username = System.getenv("spring_database_username");
        String password = System.getenv("spring_database_password");
        System.out.println(username);
        System.out.println(password);
    }


}
